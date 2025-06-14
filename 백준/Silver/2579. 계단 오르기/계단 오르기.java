import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] num=new int[n+1];
        
        for(int i=1;i<=n;i++){
            num[i]=Integer.parseInt(br.readLine());
        }

        int[][] dp=new int[n+1][2];
        dp[1][0]=num[1];
        
        if(n>1){
            dp[2][0]=num[1]+num[2];
            dp[2][1]=num[2];

            for(int i=3;i<=n;i++){
                int temp=0;

                dp[i][0]=dp[i-1][1]+num[i];

                if(dp[i-2][0] > dp[i-2][1]) temp = dp[i-2][0]+num[i];
                else temp = dp[i-2][1]+num[i];

                dp[i][1]=temp;
            }
        }

        int max = dp[n][0]>=dp[n][1]? dp[n][0]: dp[n][1];
        
        System.out.println(max);
  }
}