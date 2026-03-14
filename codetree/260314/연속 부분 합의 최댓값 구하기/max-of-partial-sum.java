import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max =1000*100000;

        int[] nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1]=nums[1];

        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            ans=Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}