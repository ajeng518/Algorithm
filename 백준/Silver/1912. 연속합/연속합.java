import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = input[0];
        int max=input[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
            max=Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}