import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            profit[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);

        dp[0][0]=0;
        for(int i=0;i<=n;i++){//길이
            for(int j=1;j<=n;j++){//가치 arr
                if(i < j){
                    dp[i][j]=dp[i][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-j][i-1]+profit[j], dp[i][j-1]);
                }
            }
        }

        int ans=0;
        for(int i=0;i<=n;i++){
            ans=Math.max(dp[n][i], ans);
        }

        System.out.println(ans);
    }
}