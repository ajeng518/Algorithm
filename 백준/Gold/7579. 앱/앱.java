import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] num = new int[n + 1][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                num[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][10001];
        int ans = INF;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j - num[i][1] < 0)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j - num[i][1]] + num[i][0], dp[i - 1][j]);

                if (dp[i][j] >= m) {
                    ans = Math.min(ans, j);
                }
            }
        }

        System.out.println(ans);
    }
}