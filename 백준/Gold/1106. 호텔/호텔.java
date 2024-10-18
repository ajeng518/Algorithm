import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken()); //인원수
        int n = Integer.parseInt(st.nextToken());//홍보 경우의 수

        int[] cost = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1100];
        Arrays.fill(dp, INF);
        dp[0] = 0;


        for (int j = 0; j < n; j++) {
            for (int i = 1; i < 1100; i++) {
                if (i - value[j] < 0) continue;

                dp[i] = Math.min(dp[i - value[j]] + cost[j], dp[i]);
            }
        }

        int ans = dp[c];

        for (int i = c + 1; i < 1100; i++)
            ans = Math.min(ans, dp[i]);

        System.out.println(ans);
    }
}