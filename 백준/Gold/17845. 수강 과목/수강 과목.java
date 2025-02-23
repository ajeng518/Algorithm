import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n=Integer.parseInt(st.nextToken());//최대공부시간
    int k=Integer.parseInt(st.nextToken());//과목수

    int[][] subject=new int[k+1][2];
    for(int i=1; i<=k; i++){
      st=new StringTokenizer(br.readLine());
      
      subject[i][0]=Integer.parseInt(st.nextToken());
      subject[i][1]=Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[k+1][n+1];
    
    for(int j=1;j <= k; j++){
      for(int now=1; now <= n; now++){
        if(now - subject[j][1]< 0){
          dp[j][now]=dp[j-1][now];
          continue;
        } 

        dp[j][now]=Math.max(dp[j-1][now], dp[j-1][now-subject[j][1]] + subject[j][0]);
      }
    }
    

    System.out.println(dp[k][n]);
  }
}