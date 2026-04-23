import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        String a =" "+br.readLine();
        String b =" "+br.readLine();
        int n = a.length()-1;
        int m = b.length()-1;

        int[][] dp = new int[n+1][m+1];
        dp[1][1] = (a.charAt(1) == b.charAt(1))? 1: 0;

        for(int i=2; i<=n; i++){
            if(a.charAt(i) == b.charAt(1)){
                dp[i][1]=1;
            }else dp[i][1]=dp[i-1][1];
        }

        for(int j=2; j<=m; j++){
            if(a.charAt(1) == b.charAt(j)){
                dp[1][j] = 1;
            }else dp[1][j]=dp[1][j-1];
        }

        for(int i=2; i<=n; i++){
            for(int j=2; j<=m; j++){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j]=dp[i-1][j-1] + 1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}