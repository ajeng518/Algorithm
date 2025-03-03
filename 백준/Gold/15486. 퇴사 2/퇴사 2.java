import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n=Integer.parseInt(br.readLine());
    int[][] work = new int[n+2][2];
    
    for(int i=1;i<=n;i++){
      st=new StringTokenizer(br.readLine());
      work[i][0]=Integer.parseInt(st.nextToken());
      work[i][1]=Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n+2];
    int max=-1;
    
    for(int i=1; i <= n+1; i++){
      int[] cur=work[i];
      
      if(max<dp[i])
        max=dp[i];
    
      int next= i + cur[0];
      if(next > n+1) continue;
      
      dp[next]=Math.max(max+cur[1], dp[next]);
    }

    System.out.println(dp[n+1]);
  }
}