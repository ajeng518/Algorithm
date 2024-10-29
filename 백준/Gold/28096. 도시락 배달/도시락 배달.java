import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int f, w, l, n;
    static int[] cur;
    static int[][] dp, position;
    static int[][] escalator;
    static int[][] dist;
    static final int INF = 16_000_000;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCase; test++) {
            st = new StringTokenizer(br.readLine());
            f = Integer.parseInt(st.nextToken()); //층수
            w = Integer.parseInt(st.nextToken()); // x
            l = Integer.parseInt(st.nextToken()); //y
            n = Integer.parseInt(st.nextToken()); // 직원수

            escalator = new int[][]{{1, 1}, {1, l}, {w, 1}, {w, l}}; //에스컬레이터 위치
            dist = new int[n + 1][n + 1];
            dp = new int[n + 1][(1 << (n + 1))];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
                Arrays.fill(dist[i], INF);
            }

            position = new int[n + 1][3];

            for (int i = 0; i <= n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 3; j++)
                    position[i][j] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>();
            for (int q = 0; q < 4; q++) list.add(new int[]{escalator[q][0], escalator[q][1]});

            sb.append(dfs(0, 1)).append("\n");

        }

        System.out.println(sb);
    }

    public static int dfs(int now, int visit) {
        if (visit == (1 << (n + 1)) - 1) {
            return 0;
        }

        if (dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;

        for (int i = 0; i <= n; i++) {
            if ((visit & (1 << i)) != 0) continue;

            int cost = 0;

            cur = new int[2];
            cur[0] = Math.abs(position[now][1] + position[i][1]) / 2;
            cur[1] = +Math.abs(position[now][2] + position[i][2]) / 2;

            int x = 1;
            int y = 1;

            if (cur[0] > w / 2) x = w;
            if (cur[1] > l / 2) y = l;

            int[] nowEl = {x, y};

            if (position[now][0] == position[i][0]) {
                cost += Math.abs(position[now][1] - position[i][1]) + Math.abs(position[now][2] - position[i][2]);
            } else {
                cost += Math.abs(position[now][1] - nowEl[0]) + Math.abs(position[now][2] - nowEl[1]);
                cost += position[now][0] < position[i][0] ? (position[i][0] - position[now][0]) * 2 : (position[now][0] - position[i][0]);
                cost += Math.abs(position[i][1] - nowEl[0]) + Math.abs(position[i][2] - nowEl[1]);
            }

            dist[now][i] = Math.min(dist[now][i], cost);

            dp[now][visit] = Math.min(dfs(i, visit | (1 << i)) + dist[now][i], dp[now][visit]);
        }

        return dp[now][visit];

    }
}