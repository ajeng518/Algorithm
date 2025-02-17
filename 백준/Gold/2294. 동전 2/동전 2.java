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
    Arrays.fill(dp, Integer.MAX_VALUE-1);

    dp[0]=0;
    
    for(int i=0; i<n; i++){
      for(int j=coin[i]; j<=k; j++){
       
        dp[j]=Math.min(dp[j-coin[i]]+1, dp[j]);
      }
    }

    if(dp[k]==Integer.MAX_VALUE-1) dp[k]=-1;

    System.out.println(dp[k]);
  }
}