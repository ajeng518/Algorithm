import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    int n=Integer.parseInt(br.readLine());
    int mod=1000000;
    int[][][] dp=new int[n+1][2][3];
    dp[1][0][0]=1;
    dp[1][1][0]=1;
    dp[1][0][1]=1;

    for(int i=2;i<=n;i++){
      dp[i][0][0]=(dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%mod;
      dp[i][1][0]=(dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2]+dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2])%mod;
      dp[i][0][1]=dp[i-1][0][0]%mod;
      dp[i][0][2]=dp[i-1][0][1]%mod;
      dp[i][1][1]=dp[i-1][1][0]%mod;
      dp[i][1][2]=dp[i-1][1][1]%mod;
    }

    int ans=0;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        ans+=dp[n][i][j];
      }
    }
    
    System.out.println(ans%mod);
  }
}