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

        int[] dp=new int[sum+1];
        // for(int i=0;i<=n;i++)
        //     Arrays.fill(dp[i], 101);

        Arrays.fill(dp, 101);
        dp[0]=1;

        for(int i=1;i<=n; i++){
            for(int j=1;j<=sum;j++){
                if(j < arr[i] ) continue;
                else dp[j]=Math.min(dp[j-arr[i]] + 1, dp[j]);
            }
        }

        String answer="No";
        int ans=Integer.MAX_VALUE;

        if(dp[sum/2] < 101) answer="Yes"; 

        // if(ans < Integer.MAX_VALUE) 
        System.out.println(answer);

    }
}