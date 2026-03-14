import java.util.*;

public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_T=10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = 0;//time 합
        int[] exp = new int[n+1];
        int[] time = new int[n+1];
        for (int i = 1; i <= n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();

            t+=time[i];
        }

        int[][] dp=new int[n+1][t+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        dp[0][0]=0;

        for(int i=1; i<=n; i++){
            for(int j =0; j<=t; j++){
                if(j - time[i] >= 0) 
                    dp[i][j]=Math.max(dp[i-1][j-time[i]] + exp[i], dp[i][j]);

                dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
            }
        }

        int ans=INT_MAX;
        for(int j=0;j<=t;j++){
            if(dp[n][j] < m ) continue;
            ans = Math.min(ans, j);
        }

        if(ans ==INT_MAX) ans =-1;

        System.out.println(ans);
    }
}