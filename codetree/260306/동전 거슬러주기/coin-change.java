import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n+1];
        for (int i = 1; i <= n; i++)
            coin[i] = sc.nextInt();
        // Please write your code here.

        int[] dp= new int[m+1];
        Arrays.fill(dp, 10001);
        dp[0]=0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(coin[j] > i) continue;
                if(dp[i-coin[j]]==10001) continue;

                dp[i]=Math.min(dp[i], dp[i-coin[j]] + 1);
            }
        }
        
        if(dp[m]==10001) dp[m]=-1;
        System.out.println(dp[m]);

    }
}