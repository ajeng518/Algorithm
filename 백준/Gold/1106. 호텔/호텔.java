import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp= new int[1101];
        Arrays.fill(dp, 1000000);
        dp[0]=0;

        int[] w=new int[n+1];
        int[] v=new int[n+1];
        
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            w[i]=Integer.parseInt(st.nextToken());
            v[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            for(int j=v[i];j<=1100;j++){
                dp[j]=Math.min(dp[j], dp[j-v[i]]+w[i]);
            }
        }

        int ans=Integer.MAX_VALUE;
        
        for(int i=c;i<=1100;i++){
            ans=Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
