import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());

    int[] coin=new int[n];
    for(int i=0;i<n;i++) coin[i]=Integer.parseInt(br.readLine());

    int[] dp=new int[k+1];

    dp[0]=1;
    
    for(int i=0; i<n; i++){
      for(int j=1; j<=k; j++){
       if(j-coin[i]<0) continue;
        dp[j]=dp[j-coin[i]]+dp[j];
      }
    }

    System.out.println(dp[k]);
  }
}