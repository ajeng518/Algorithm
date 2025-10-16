import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] dp=new int[n+4];
        dp[0]=1;


        for(int i =2;i<=n;i++){
            if(i-2 < 0) continue;
            if(dp[i-2] > 0)
                dp[i]+=dp[i-2];

            if(i-3 < 0) continue;    
            if(dp[i-3] > 0){
                dp[i]+=dp[i-3];
            }
        }

        System.out.println(dp[n]%10007);
    }
}