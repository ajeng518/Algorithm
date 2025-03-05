import java.util.*;
import java.io.*;

public class Main {
  static int max, n, k;
  static int[] word;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n=Integer.parseInt(br.readLine());
    int[][] map=new int[n][n];

    for(int i=0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0;j<n;j++){
        map[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    int[][][] dp=new int[3][n][n];//0: 가로, 1: 세로, 2: 대각선
    for(int i=1;i<n;i++){
      if(map[0][i]==1) break;
      
      dp[0][0][i]=1;
    }

    for(int i=1; i<n; i++){
      for(int j=2; j<n; j++){
        if(map[i][j]==1) continue;

        //가로
          dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
        //세로
          dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
        
        //대각선
        if(map[i-1][j]==1 || map[i][j-1]==1) continue;
        dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
      }
    }

    System.out.println(dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1]);
  }
}