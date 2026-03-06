import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        int[] arr= {0, 1, 2, 5};
        dp[0]=1;

        int MOD = 10007;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=3;j++){
                if(i < arr[j]) continue;

                dp[i]=(dp[i] + dp[i-arr[j]])%MOD;
            }
        }

        System.out.println(dp[n]);
    }
}