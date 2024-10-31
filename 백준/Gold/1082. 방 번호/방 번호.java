import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num, cost;
    static int n, m;
    static String maxNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        cost = new int[n];
        maxNum = "0";
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        String[] dp = new String[m + 1];
        Arrays.fill(dp, "-1");

        for (int i = 0; i < n; i++) {
            if (cost[i] > m) continue;

            dp[cost[i]] = String.valueOf(i);
        }

        for (int i = 0; i <= m; i++) {
            if (dp[i].equals("-1")) continue;

            for (int j = 0; j < n; j++) {
                if (i + cost[j] > m) continue;

                String newString = dp[i] + String.valueOf(j);

                BigInteger n1 = new BigInteger(newString);
                BigInteger n2 = new BigInteger(dp[i + cost[j]]);

                int result = n1.compareTo(n2);
                if (result > 0)
                    dp[i + cost[j]] = newString;

            }
        }

        for (String s : dp)
        {
            BigInteger num1 = new BigInteger(s);
            BigInteger num2 = new BigInteger(maxNum);

            int result = num1.compareTo(num2);

            if (result > 0)
                maxNum = s;
        }

        System.out.println(maxNum);
    }

}