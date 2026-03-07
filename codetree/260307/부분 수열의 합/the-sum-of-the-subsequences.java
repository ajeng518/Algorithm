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
        Arrays.fill(dp, -1);
        dp[0]=1;

        for(int i=0;i<n;i++){
            for(int j=m; j>=0;j--){
                if(j < arr[i]) continue;
                if(dp[j-arr[i]]==-1) continue;

                dp[j]=Math.max(dp[j], dp[j-arr[i]]);
            }
        }

        if(dp[m]==1) System.out.println("Yes");
        else System.out.println("No");
    }
}