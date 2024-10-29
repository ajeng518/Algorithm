import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dXY = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};//서 북 동 남
    static int[][] map, idx;
    static int n, m;
    static Map<Integer, Integer> size;
    static StringBuilder sb = new StringBuilder();
//    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        process();
        System.out.println(sb);

    }

    public static void process() {
        boolean[][] visited = new boolean[m][n];
        idx = new int[m][n];
        size = new HashMap<>();

        int roomCnt = 0;
        int max = Integer.MIN_VALUE;
        int newMax = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 방 개수 세기 및 가장 넓은 방 크기 구하기
                if (!visited[i][j]) {
                    roomCnt++;
                    int now = bfs(i, j, visited, roomCnt);
                    size.put(roomCnt, now);

                    max = Math.max(now, max);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;

                //벽하나 제거하면서 얻을 수 있는 가장 넓은 방 크기 구하기
                for (int k = 0; k < 4; k++) {
                    if ((map[i][j] & (1 << k)) == 0) //이 방면에 벽 없음
                        continue;

                    int nx = i + dXY[k][0];
                    if (nx < 0 || nx >= m) continue;

                    int ny = j + dXY[k][1];
                    if (ny < 0 || ny >= n) continue;

                    if (idx[i][j] == idx[nx][ny]) continue;

                    newMax = Math.max((size.get(idx[i][j]) + size.get(idx[nx][ny])), newMax);

                }
            }
        }

        sb.append(roomCnt).append("\n");
        sb.append(max).append("\n");
        sb.append(newMax);
    }

    public static int bfs(int sx, int sy, boolean[][] visited, int roomCnt) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.add(new int[]{sx, sy});//좌표와 cnt
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            idx[cur[0]][cur[1]] = roomCnt;
            cnt++;

            for (int i = 0; i < 4; i++) {
                if ((map[cur[0]][cur[1]] & (1 << i)) != 0) //이 방면에 벽이 있다면
                    continue;

                int nx = cur[0] + dXY[i][0];
                if (nx < 0 || nx >= m) continue;

                int ny = cur[1] + dXY[i][1];
                if (ny < 0 || ny >= n) continue;

                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return cnt;
    }
}