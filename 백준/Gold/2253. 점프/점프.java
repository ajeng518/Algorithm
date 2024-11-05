import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken().trim());
        int m = Integer.parseInt(st.nextToken().trim());

        List<Integer> cantGo = new ArrayList<>();
        String input;
        int cnt = 0;
        while (cnt < m) {
            if ((input = br.readLine().trim()).equals("")) continue;

            cantGo.add(Integer.parseInt(input));
            cnt++;
        }

        int maxJump = (int) Math.sqrt(2 * n) + 2;
        int[][] dp = new int[n + 1][maxJump];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 10001);
        }

        dp[1][0] = 0;

        for (int i = 2; i <= n; i++) {
            if (cantGo.contains(i)) continue;

            int limit = (int) Math.sqrt(2 * i) + 1;

            for (int v = 1; v <= limit; v++) {
                if (i - v < 0) continue;
                
                if (v - 1 >= 0 && v + 1 < maxJump) { // 경계 조건을 확인합니다.
                    dp[i][v] = Math.min(dp[i - v][v - 1], Math.min(dp[i - v][v], dp[i - v][v + 1])) + 1;
                } else if (v - 1 >= 0) { // `v + 1`이 범위를 벗어날 경우
                    dp[i][v] = Math.min(dp[i - v][v - 1], dp[i - v][v]) + 1;
                } else { // `v - 1`도 범위를 벗어날 경우
                    dp[i][v] = dp[i - v][v] + 1;
                }
            }
        }

        int maxValue = 10001;

        for (int i = 0; i < maxJump; i++) {
            maxValue = Math.min(maxValue, dp[n][i]);
        }

        if (maxValue == 10001) maxValue = -1;

        System.out.println(maxValue);
    }
}