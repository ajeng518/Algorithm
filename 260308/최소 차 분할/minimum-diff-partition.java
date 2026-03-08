import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }

        int[][] dp=new int[n+1][sum+1];
        // for(int i=0;i<=n;i++)
        //     Arrays.fill(dp[i], -1);
        dp[0][0]=0;

        for(int i=1;i<=n; i++){
            for(int j=1;j<=sum;j++){
                if(j < arr[i] ) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j-arr[i]] + 1, dp[i-1][j]);
            }
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[n][i]<=0) continue;
            ans=Math.min(Math.abs(2*i -sum), ans);
        }

        System.out.println(ans);

    }
}