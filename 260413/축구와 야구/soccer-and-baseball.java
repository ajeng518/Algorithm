import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] s = new int[n+1];
        int[] b = new int[n+1];
        int[][][] dp = new int[n+1][11+1][9+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            s[i]=Integer.parseInt(st.nextToken());
            b[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=n;i++){
            for(int j = 0;j <= 11; j++){
                Arrays.fill(dp[i][j], -1_000_000_000);
            }
        }

        dp[0][0][0]=0;

        for(int i=1; i<=n; i++){
            for(int j=0; j<=11; j++){
                for(int k=0; k<=9; k++){
                    dp[i][j][k]=Math.max(dp[i-1][j][k], dp[i][j][k]);

                    if(j > 0){
                        dp[i][j][k] = Math.max(dp[i-1][j-1][k] + s[i], dp[i][j][k]);
                    }

                    if(k > 0){
                        dp[i][j][k] = Math.max(dp[i-1][j][k-1] + b[i], dp[i][j][k]);
                    }
                }
            }
        }

        System.out.println(dp[n][11][9]);
    }
}