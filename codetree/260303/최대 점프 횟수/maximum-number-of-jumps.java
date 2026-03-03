import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int MAX_JUMP=-1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Please write your code here.
        int[] dp  = new int[n];
        Arrays.fill(dp, -1);
        dp[0]=0;

        for(int i=1; i<n; i++){
            for(int j=0; j < i; j++){
                if(dp[j]==MAX_JUMP) continue;
                if(j + arr[j] < i) continue;

                dp[i]=Math.max(dp[i], dp[j] + 1);
            }
        }

        int answer=0;
        for(int i=0;i<n;i++) answer=Math.max(answer, dp[i]);

        System.out.println(answer);
    }
}