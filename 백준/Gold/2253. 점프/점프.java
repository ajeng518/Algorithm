import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n =Integer.parseInt(st.nextToken().trim());
        int m =Integer.parseInt(st.nextToken().trim());

        Set<Integer> noStep = new HashSet<>();
        while(m-->0) noStep.add(Integer.parseInt(br.readLine().trim()));
        
        int MAXINT=1000001;
        int max = (int)Math.sqrt(n*2)+2;
        
        int[][] dp=new int[n+1][max];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i], MAXINT);

        dp[1][0]=0;

        for(int i=2;i<=n;i++){
            if(noStep.contains(i)) continue;
            
            int limit = (int)Math.sqrt(n*2)+1;
            
            for(int j = 1; j <= limit; j++){
                if(i - j < 0) continue;
                
                if(j-1>=0 && j+1<max){
                    dp[i][j]=Math.min(dp[i-j][j-1], Math.min(dp[i-j][j], dp[i-j][j+1])) + 1;
                }else if(j-1>=0){
                    dp[i][j]=Math.min(dp[i-j][j-1], dp[i-j][j]) + 1;
                }else{
                    dp[i][j]=dp[i-j][j]+1;
                }
            }
        }

        int minAns = MAXINT;
        for(int i =0;i< max; i++){
            minAns=Math.min(minAns, dp[n][i]);
        }

        if(minAns >= MAXINT) System.out.println(-1);
        else System.out.println(minAns);
  }
}