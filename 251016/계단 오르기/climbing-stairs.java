import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] dp=new int[n+1];
        if(n>=2)
            dp[2]=1;
        if(n>=3)    
            dp[3]=1;

        for(int i =4;i<=n;i++){
            if(dp[i-2] > -1)
                dp[i]+=dp[i-2];
            if(dp[i-3] > -1){
                dp[i]+=dp[i-3];
            }
        }

        System.out.println(dp[n]);
    }
}