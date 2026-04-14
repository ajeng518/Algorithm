import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] room = new int[n+1][3];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer (br.readLine());
            room[i][0]=Integer.parseInt(st.nextToken());
            room[i][1]=Integer.parseInt(st.nextToken());
            room[i][2]=Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][3];
        dp[1][0]=room[1][0];
        dp[1][1]=room[1][1];
        dp[1][2]=room[1][2];

        for(int i=2; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + room[i][0];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + room[i][1];
            dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + room[i][2];
        }


        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }
}