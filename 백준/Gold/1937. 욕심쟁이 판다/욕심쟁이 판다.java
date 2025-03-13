import java.util.*;
import java.io.*;

public class Main {
  static int[][] map;
  static int[][] dp;
  static int n;
  static int[] dx={-1, 0, 1, 0};
  static int[] dy={0, 1, 0, -1};
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n=Integer.parseInt(br.readLine());
    map=new int[n][n];   
    for(int i=0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      
      for(int j=0;j<n;j++){
        map[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    int ans=0;
    dp=new int[n][n];
    
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        ans=Math.max(dfs(i, j), ans);
      }
    }

    System.out.println(ans);
  }

  private static int dfs(int sx, int sy){
    if(dp[sx][sy]!=0) return dp[sx][sy];
    
    dp[sx][sy]=1;

     for(int i=0;i<4; i++){
        int nx=sx+dx[i];
        if(nx<0 || nx>=n) continue;
        int ny=sy+dy[i];
        if(ny<0 || ny>=n) continue;

        if(map[nx][ny] <= map[sx][sy]) continue;

       dp[sx][sy]=Math.max(dp[sx][sy], dfs(nx, ny)+1);
      }

    return dp[sx][sy];
  }
}