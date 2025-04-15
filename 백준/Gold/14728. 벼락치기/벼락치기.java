import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int t =Integer.parseInt(st.nextToken());

        int[][] learn = new int[n+1][2];
        int[][] dp=new int[n+1][t+1];

        for(int i = 1; i <= n; i++){
            st=new StringTokenizer(br.readLine());

            learn[i][0]=Integer.parseInt(st.nextToken());//공부시간
            learn[i][1]=Integer.parseInt(st.nextToken());//배점
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<= t; j++){
                if(j-learn[i][0]<0) dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-learn[i][0]]+learn[i][1]);
                }
            }
        }

        System.out.println(dp[n][t]);
    }
}