import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp=new int[n+1][10];
        
        for(int i=1; i<=9; i++){
            dp[1][i]=1;
        }

        for(int i = 1; i < n; i++){
            for(int j=0; j <= 9; j++){
                if(j > 0){
                    dp[i+1][j-1] = (dp[i+1][j-1] + dp[i][j]) % MOD;
                }

                if(j < 9){
                    dp[i+1][j+1] = (dp[i+1][j+1] + dp[i][j]) % MOD;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<=9; i++){
            ans = (ans + dp[n][i]) % MOD;
        }

        System.out.println(ans);
    }
}