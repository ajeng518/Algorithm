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

        if(sum % 2 != 0){
            System.out.println("No");
            System.exit(0);
        } 

        int[][] dp=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], 101);
        dp[0][0]=1;

        for(int i=1;i<=n; i++){
            for(int j=1;j<=sum;j++){
                if(j < arr[i] ) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.min(dp[i-1][j-arr[i]] + 1, dp[i-1][j]);
            }
        }

        String answer="No";
        int ans=Integer.MAX_VALUE;

        for(int i=0; i<=sum/2+1; i+=2){
            if(dp[n][i]>=101) continue;
            
            ans=Math.min(i, ans);
        }

        if(ans < Integer.MAX_VALUE) answer="Yes"; 
        System.out.println(answer);

    }
}