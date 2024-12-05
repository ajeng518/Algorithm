import java.util.*;
import java.io.*;

public class Main {
    public static class Santa implements Comparable<Santa> {
        int idx;
        int x;
        int y;
        boolean sleep;
        int sleepTurn;
        int d;

        public Santa(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.sleep = false;
            this.sleepTurn = 0;
            this.d=0;
        }

        @Override
        public int compareTo(Santa o) {
            if (this.d == o.d) {
                if (this.x == o.x) {
                    return o.y - this.y; //
                }
                return o.x - this.x; //
            }
            return this.d-o.d;
        }
    }

    //    static int[][] way8 = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int[][] way4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//상우하좌 우선

    static int[] rudolph;//루돌프 현재 위치
    static int[] score;
    static int[][] map;
    static int n, m, p, c, d;
    static Map<Integer, Santa> santaMap;
    static boolean[] dead;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//겜판 크기
        m = Integer.parseInt(st.nextToken());//턴수
        p = Integer.parseInt(st.nextToken());//산타수
        c = Integer.parseInt(st.nextToken());//루돌프 힘
        d = Integer.parseInt(st.nextToken());//산타힘

        map = new int[n + 1][n + 1];
        dead = new boolean[p + 1];
        score = new int[p + 1];

        st = new StringTokenizer(br.readLine());
        //루돌프 위치
        rudolph = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        santaMap = new HashMap<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            map[sx][sy] = idx;
            santaMap.put(idx, new Santa(idx, sx, sy));
        }


        for (int i = 1; i <= m; i++) {
            if (isFinish()) break;

            // 루돌프 돌진
            rudolphGo(i);

            // 산타 돌진
            santaGo(i);
            //점수
            chkScore();

        }

        for (int i = 1; i <= p; i++) {
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb);


    }

    public static void rudolphGo(int turn) {
        Santa nearSanta = finidNearSanta();

        if (nearSanta.x >= 1 || nearSanta.x <= n || nearSanta.y >= 1 || nearSanta.y <= n) {
            int diffX = rudolph[0] - nearSanta.x;
            int diffY = rudolph[1] - nearSanta.y;

            if (diffX < 0) diffX = 1;
            else if (diffX > 0) diffX = -1;

            if (diffY < 0) diffY = 1;
            else if (diffY > 0) diffY = -1;

                rudolph[0] += diffX;
                rudolph[1] += diffY;

            //돌진한 곳에 산타가 있다면?
            if (rudolph[0] == nearSanta.x && rudolph[1] == nearSanta.y) {

                //산타 날라감
                nearSanta.x += diffX * c;
                nearSanta.y += diffY * c;
                score[nearSanta.idx] += c;
                nearSanta.sleepTurn = turn;
                nearSanta.sleep = true;

                map[rudolph[0]][rudolph[1]] = 0;
                //상호작용
                interactions(nearSanta.idx, nearSanta.x, nearSanta.y, diffX, diffY);
            }
        }
    }

    public static Santa finidNearSanta() {
        PriorityQueue<Santa> pq = new PriorityQueue<>();

        for (int idx=1;idx<=p;idx++) {
            if (dead[idx]) continue;

            Santa newSanta=santaMap.get(idx);
            newSanta.d=(int)(Math.pow(rudolph[0]-newSanta.x, 2)+Math.pow(rudolph[1]-newSanta.y, 2 ));
            pq.add(newSanta);
        }

        if (pq.isEmpty()) return null;
        else return pq.poll();
    }

    public static void santaGo(int turn) {
        for (int i = 1; i <= p; i++) {
            if (dead[i]) continue;
            if (santaMap.get(i).sleep) {
                //기절중이라 못움직임
                if (santaMap.get(i).sleepTurn + 2 > turn) continue;
            }
            Santa cur = santaMap.get(i);

            int min = (int) (Math.pow(rudolph[0] - cur.x, 2) + Math.pow(rudolph[1] - cur.y, 2));
            int dir = -1;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + way4[d][0];
                int ny = cur.y + way4[d][1];

                if (nx < 1 || nx > n || ny < 1 || ny > n || map[nx][ny] > 0) continue;

                int dist = (int) (Math.pow(rudolph[0] - nx, 2) + Math.pow(rudolph[1] - ny, 2));
                if (dist < min) {
                    dir = d;
                    min = dist;
                }
            }

            //루돌프로 가까워지는 방향이 존재 할때
            if (dir != -1) {
                //기존에 있던 산타 위치는 없앰
                map[cur.x][cur.y] = 0;

                cur.x += way4[dir][0];
                cur.y += way4[dir][1];

                //루돌프랑 충돌하면
                if (rudolph[0] == cur.x && rudolph[1] == cur.y) {
                    score[cur.idx] += d;
                    cur.sleep = true;
                    cur.sleepTurn = turn;

                    int nx = cur.x + (-way4[dir][0] * d);
                    int ny = cur.y + (-way4[dir][1] * d);

                    interactions(i, nx, ny, -way4[dir][0], -way4[dir][1]);
                } else {
                    map[cur.x][cur.y] = i;
                    santaMap.put(i, cur);
                }
            }

        }
    }

    public static void interactions(int idx, int x, int y, int moveX, int moveY) {
        if (x > 0 && x <= n && y > 0 && y <= n) {//산타가 유효범위 안에 있는가?
            if (map[x][y] > 0) {//이동할 칸에 다른 산타있다면
                interactions(map[x][y], x + moveX, y + moveY, moveX, moveY);
            }

            map[x][y] = idx;
            santaMap.get(idx).x = x;
            santaMap.get(idx).y = y;
        } else {
            dead[idx] = true;
        }
    }

    public static void chkScore() {
        for (int idx : santaMap.keySet()) {
            if (dead[idx]) continue;

            score[idx]++;
        }
    }

    public static boolean isFinish() {
        for (int i = 1; i <= p; i++) {
            if (!dead[i]) return false;
        }

        return true;
    }
}