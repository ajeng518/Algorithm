import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[][][] dp= new int[n+1][m+1][4+1];
        for(int i=1; i<=n; i++){
            for(int j = 0; j<=m;j++){
                for(int k=1; k<= 4; k++)
                    dp[i][j][k]=Integer.MIN_VALUE;
            }
        }

        for(int k=1; k<=4; k++){
            dp[1][0][k] = (arr[1]==k? 1:0);
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=m; j++){
                for(int k=1; k<=4; k++){
                    for(int l=1; l<=4; l++){
                        if(k==l){
                            dp[i][j][k]= Math.max(dp[i][j][k], dp[i-1][j][l] + (arr[i] == k? 1: 0));
                        }

                        if(l!=k && j > 0){
                            dp[i][j][k]= Math.max(dp[i][j][k], dp[i-1][j-1][l] + (arr[i] == k? 1: 0));
                        }
                    }
                }
            }
        }

        int ans=0;

        for(int j=0; j<=m; j++){
            for(int k=1; k<=4; k++)
                ans = Math.max(ans, dp[n][j][k]);
        }

        System.out.println(ans);
    }
}