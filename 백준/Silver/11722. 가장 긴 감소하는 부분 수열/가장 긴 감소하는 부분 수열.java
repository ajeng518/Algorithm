import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] friend;
    static int[][] dp;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        
       int[] num=new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) num[i]=Integer.parseInt(st.nextToken());

        int[] dp=new int[n+1];
        int max =-1;
        
        for(int i=1; i<=n; i++){
            dp[i]=1;
            for(int j=1; j<i; j++){
                if(num[j]<=num[i]) continue;
                dp[i]=Math.max(dp[j]+1, dp[i]);
            }

            max=max<dp[i]?dp[i]:max;
        }

        System.out.println(max);
    }
}