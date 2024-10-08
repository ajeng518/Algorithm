import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());
        int ans = 0;

        if (subin >= sister) {
            ans = subin - sister;
        } else {
            int[] dp = new int[100001];
            for (int i = 0; i < subin; i++) dp[i] = subin - i;

            for (int cur = subin + 1; cur <= sister; cur++) {
                int min;
                if (cur % 2 == 0)
                    min = dp[cur / 2] + 1;
                else {
                    min = Math.min(dp[(cur - 1) / 2] + 2, dp[(cur + 1) / 2] + 2);
                }

                dp[cur] = Math.min(dp[cur - 1] + 1, min);
            }
            ans = dp[sister];
        }

        System.out.println(ans);
    }

}