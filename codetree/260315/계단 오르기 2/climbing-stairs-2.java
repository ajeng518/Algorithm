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

        dp[1][1]=coins[1];
        dp[2][0]=coins[2];
        dp[2][2]=coins[1]+coins[2];

        for(int i=3;i<=n;i++){
            for(int j=0;j<=3;j++){
                if(dp[i-2][j] != 0)
                    dp[i][j]= Math.max(dp[i-2][j]+ coins[i], dp[i][j]) ;
                
                if(j > 0 && dp[i-1][j-1] != 0)
                    dp[i][j]=Math.max(dp[i-1][j-1] + coins[i], dp[i][j]);
            }
        }

        int ans=-1;
        for(int i=0;i<=3;i++) ans=Math.max(ans, dp[n][i]);
        System.out.println(ans);
    }
}