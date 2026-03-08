import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[] dp=new int[m+1];
        // for(int i=0; i<=m; i++)
        //     Arrays.fill(dp[i], -1);
        Arrays.fill(dp, -1);
        dp[0]=0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i < w[j]){
                   continue;
                }
                dp[i]=Math.max(dp[i-w[j]] + v[j], dp[i]);
            }
        }

        int ans=0;
        for(int i=1;i<=m;i++){
            ans=Math.max(dp[i], ans);
        }

        System.out.println(ans);

    }
}