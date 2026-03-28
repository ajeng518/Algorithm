import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] start =new int[n+1];
        int[] end = new int[n+1];
        int[] value = new int[n+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            start[i]=Integer.parseInt(st.nextToken());
            end[i]=Integer.parseInt(st.nextToken());
            value[i]=Integer.parseInt(st.nextToken());
        }

        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i], -1);
        
        for(int j=1; j<=n;j++){
            if(start[j] == 1) dp[1][j]=0;
        }

        for(int i=2;i<=m;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){                    
                    if(start[k]>i-1 || end[k]< i-1) continue;
                    if(start[j]>i || end[j]< i) continue;

                    dp[i][j]=Math.max(dp[i-1][k] + Math.abs(value[j]-value[k]), dp[i][j]);

                }
            }
        }

        int max = -1;
        for(int i=0;i<=n;i++){
            max=Math.max(dp[m][i], max);
        }

        System.out.println(max);
    }
}