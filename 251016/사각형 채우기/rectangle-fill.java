import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] dp=new int[n+3];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2]) % 10007;
        }

        System.out.println(dp[n]%10007);
    }
}