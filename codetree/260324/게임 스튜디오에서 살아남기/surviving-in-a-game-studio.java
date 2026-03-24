import java.util.*;
import java.io.*;

public class Main {
    static final int MOD =1_000_000_007;

    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][][]dp=new int[n+1][5][5];//n일,  t, b
        dp[1][0][0]=1;
        dp[1][1][0]=1;
        dp[1][0][1]=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    //t 받음
                    dp[i+1][j+1][0] = (dp[i+1][j+1][0] + dp[i][j][k]) % MOD;
                    //g 받음
                    dp[i+1][j][0] = (dp[i+1][j][0] + dp[i][j][k]) % MOD;
                    //b 받음
                    dp[i+1][j][k+1]= (dp[i+1][j][k+1] + dp[i][j][k])% MOD;
                }
            }
        }

        int ans=0;
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                ans = (ans + dp[n][i][j])% MOD;
            }
        }

        System.out.println(ans);
    }
}