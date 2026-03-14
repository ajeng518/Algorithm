import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp=new int[n+1][3+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i], -1);

        dp[0][0]=0;
        dp[1][0]=coins[1];

        for(int i=2;i<=n;i++){
            dp[i][0]=dp[i-2][0]+coins[i];

            for(int j=1;j<=3;j++){
                if(i-2 < 0) continue;
                if(j==3)
                    dp[i][j]=dp[i-2][j] +coins[i];
                else dp[i][j]= Math.max(dp[i-1][j-1], dp[i-2][j]) + coins[i];
            }
        }

        int ans=-1;
        for(int i=0;i<=3;i++) ans=Math.max(ans, dp[n][i]);
        System.out.println(ans);
    }
}