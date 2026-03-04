import java.util.*;

public class Main {
    static final int INT_MAX=101;
    static final int MAX_R = 100;
    static final int MAX_N = 100;

    static int n;
    static int[][] dp, num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n][n];
        num = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                num[i][j] = sc.nextInt();

        int ans=INT_MAX;

        for(int lowerBound=1; lowerBound<=MAX_R; lowerBound++){
            int maxBound = solve(lowerBound);

            if(maxBound == INT_MAX) continue;

            ans=Math.min(maxBound - lowerBound, ans);
        }

        System.out.println(ans);
    }

    private static void init(){
        for(int i=0;i<n;i++) Arrays.fill(dp[i], INT_MAX);
        dp[0][0] = num[0][0];

        for(int i=1;i<n;i++){
            dp[0][i]=Math.max(dp[0][i-1], num[0][i]);
            dp[i][0]=Math.max(dp[i-1][0], num[i][0]);
        }
    }

    private static int solve(int lowerBound){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(num[i][j] >= lowerBound) continue;

                num[i][j]=INT_MAX;
            }
        }

        init();

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.max(Math.min(dp[i-1][j], dp[i][j-1]), num[i][j]);
            }
        }

        return dp[n-1][n-1];
    }
}