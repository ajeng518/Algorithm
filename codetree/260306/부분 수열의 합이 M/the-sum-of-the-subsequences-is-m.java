import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] dp=new int[m+1];
        Arrays.fill(dp, 101);
        dp[0]=0;

        for(int i=0;i<n;i++){
            for(int j=m; j>=0; j--){
                if(j< arr[i]) continue;

                dp[j]=Math.min(dp[j], dp[j-arr[i]]+1);
            }
        }

        int ans= dp[m];
        if(ans==101 ) ans=-1;
        System.out.println(ans);
    }
}