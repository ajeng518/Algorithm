import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    
        int[] num=new int[n+1];
        int[] dp=new int[n+1];
        Arrays.fill(dp, 1000001);

        dp[1]=0;
        dp[0]=0;

        for(int i=2;i<=n;i++){
            if(i % 3 == 0 && dp[i]>dp[i/3]+1){
                dp[i]=dp[i/3]+1;
                num[i]=i/3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                num[i] = i / 2;

            }
            if (i - 1 >= 0 && dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                num[i] = i - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        int max=n;
        for(int i=0;i<=dp[n]; i++){
            sb.append(max).append(" ");
            max=num[max];
        }

        System.out.println(sb);
    }
}