import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[][] dp=new int[N+1][K+1];
        for(int i=0;i<=N;i++) Arrays.fill(dp[i], -1000000009);

        if(arr[1] >= 0) dp[1][0]=arr[1];
        else dp[1][1]=arr[1];


        int ans=arr[1];

        for(int i=2; i <= N; i++){
            if(arr[i] >= 0){
                dp[i][0]=Math.max(dp[i-1][0] + arr[i], arr[i]);
                ans=Math.max(ans, dp[i][0]);

                for(int j=1; j<=K; j++){
                    if(dp[i-1][j] == -1000000009) continue;

                    dp[i][j] = dp[i-1][j] + arr[i];
                    ans=Math.max(ans, dp[i][j]);
                }
            }else{
                dp[i][1]=Math.max(dp[i-1][0]+arr[i], arr[i]);
                ans=Math.max(ans, dp[i][1]);

                for(int j=1;j<=K;j++){
                    if(dp[i-1][j-1] == 1000000009) continue;

                    dp[i][j]=dp[i-1][j-1]+arr[i];
                    ans=Math.max(ans,dp[i][j]);
                }
            }
            
        }

        System.out.println(ans);        
    }
}