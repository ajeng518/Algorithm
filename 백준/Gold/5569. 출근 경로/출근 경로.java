import java.util.*;
import java.io.*;

public class Main {
  static int mod= 100000;
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int w=Integer.parseInt(st.nextToken());
    int h=Integer.parseInt(st.nextToken());

    int[][][][] dp=new int[h+1][w+1][2][2]; //dp배열 [x][y][현재방향][방향 바꿀건지여부: 0 불가능, 1 가능]
    
    for(int i=1;i<h;i++){
      dp[i][0][0][1]=1;
    }
    for(int j=1;j<w;j++){
         dp[0][j][1][1]=1;
    }

    for(int i = 1; i < h ; i++){
      for(int j = 1; j < w; j++){
        dp[i][j][0][1] = (dp[i-1][j][0][0] + dp[i-1][j][0][1])%mod;
        dp[i][j][0][0] = dp[i-1][j][1][1];
      
        dp[i][j][1][1] = (dp[i][j-1][1][0] + dp[i][j-1][1][1])%mod;
        dp[i][j][1][0] = dp[i][j-1][0][1];
        
      }
    }

    int ans= dp[h-1][w-1][0][0] + dp[h-1][w-1][0][1] + dp[h-1][w-1][1][0] + dp[h-1][w-1][1][1];
        
    System.out.println((ans % mod));
    
  }
}