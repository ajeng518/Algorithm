import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n + 1];
        for (int i = 1; i <= n; i++) input[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][2];

        dp[1][0] = input[1];

        if (n > 1) {
            dp[2][0] = input[1] + input[2];
            dp[2][1] = input[2];

            for (int i = 3; i <= n; i++) {
                int jmp2 = 0;

                //1칸 점프
                dp[i][0] = dp[i - 1][1] + input[i];

                //2칸 점프
                if (dp[i - 2][0] > dp[i - 2][1]) {
                    jmp2 = dp[i - 2][0] + input[i];
                } else {
                    jmp2 = dp[i - 2][1] + input[i];
                }

                dp[i][1] = jmp2;
            }
        }

        int max = dp[n][0] >= dp[n][1] ? dp[n][0] : dp[n][1];
        System.out.println(max);
    }
}