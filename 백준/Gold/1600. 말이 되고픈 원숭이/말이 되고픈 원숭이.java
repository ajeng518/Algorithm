import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int k, w, h, map[][], dx[], dy[], cnt, com[];
    static boolean chk[][][];
    static Deque<int[]> q = new ArrayDeque<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());//말 뛰기 가능 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());//세로길이
        w = Integer.parseInt(st.nextToken());//가로길이

        map = new int[w][h];
        chk = new boolean[w][h][k+1];
        cnt = 0;
        com = new int[w * h];//조합 경우 결과 넣기
        
        dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2, 0, 1, 0, -1};
        dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1, 1, 0, -1, 0};

        //지도 입력받기
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < h; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (bfs(0, 0))
            System.out.println(cnt);
        else
            System.out.println(-1);
    }

    private static boolean bfs(int x, int y) {
        q.offer(new int[]{0, 0, 0, k});
        chk[0][0][k]=true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (--size >= 0) {
                int[] temp = q.poll();

                if (temp[0] == w - 1 && temp[1] == h - 1) {
                    cnt=temp[2];
                    return true;
                }

                for (int i = 8; i < dx.length; i++) {
                    int nowX = temp[0] + dx[i];
                    int nowY = temp[1] + dy[i];
                    if (nowX < 0 || nowY < 0 || nowX >= w || nowY >= h
                            || map[nowX][nowY] == 1 || chk[nowX][nowY][temp[3]] == true)
                        continue;
                    chk[nowX][nowY][temp[3]] = true;
                    q.offer(new int[]{nowX, nowY,temp[2]+1, temp[3]});
                }
                if(temp[3]>0){
                    for (int i = 0; i < 8; i++) {
                        int nowX = temp[0] + dx[i];
                        int nowY = temp[1] + dy[i];
                        if (nowX < 0 || nowY < 0 || nowX >= w || nowY >= h
                                || map[nowX][nowY] == 1 || chk[nowX][nowY][temp[3]-1] == true)
                            continue;
                        chk[nowX][nowY][temp[3]-1] = true;
                        q.offer(new int[]{nowX, nowY,temp[2]+1,temp[3]-1});
                    }
                }
            }
        }
        return false;
    }

    private static int OverIdx(int now) {
        if (now > 0) return 0;
        return 8;
    }
}

