import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp= new int[n+1][m+1];
        for(int j=1; j<=m; j++) dp[1][j]=arr[1][j];

        for(int i=2; i<=n; i++){
            for(int j=1; j<=m;j++){
                for(int k=1; k<=m; k++){
                    if(j==k) continue;

                    dp[i][j]=Math.max(dp[i][j], dp[i-1][k]+arr[i][j]);
                }
            }
        }
        int ans=0;
        for(int j=1; j<=m;j++) ans=Math.max(dp[n][j], ans);

        System.out.println(ans);
;    }
}