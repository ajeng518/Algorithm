import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb=new StringBuilder();
    
    int t = Integer.parseInt(br.readLine());//test cnt
    
   while(t-->0){
      int n = Integer.parseInt(br.readLine());// coin
      int[] coin=new int[n+1];
      
      st = new StringTokenizer(br.readLine());
      for(int i=1;i<=n;i++){
        coin[i]=Integer.parseInt(st.nextToken());
      }
      
      int m=Integer.parseInt(br.readLine());// want value

      int[]dp=new int[m+1];

      for(int i=1; i<=n; i++){
        if(coin[i]>m) continue;
        dp[coin[i]]+=1;
        
        for(int value=coin[i]; value<=m; value++){
          if(value-coin[i]<=0) continue;

          dp[value]+=dp[value-coin[i]];
        }
      }

      sb.append(dp[m]).append("\n");
    }

    System.out.println(sb);
  }
}