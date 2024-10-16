import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, dp;
    static int min, n;
    static final int INF = 16_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][(1 << n)];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int ans = dfs(0, 1);
        System.out.println(ans);
    }

    public static int dfs(int now, int visit) {
        if (visit == (1 << n) - 1) {//
            if (map[now][0] == 0) return INF;
            return map[now][0];
        }

        if (dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;

        for (int i = 0; i < n; i++) {
            if ((visit & (1 << i))!=0) continue;
            if (map[now][i] == 0) continue;

            dp[now][visit] = Math.min(dfs(i, visit | (1 << i)) + map[now][i], dp[now][visit]);
        }

        return dp[now][visit];
    }
}