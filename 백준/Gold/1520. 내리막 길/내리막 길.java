import java.util.*;
import java.io.*;

public class Main {
  static int[] dx={-1, 0, 1, 0};
  static int[] dy={0, 1, 0, -1};
  static int n, m;
  static int[][]map, dp;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n=Integer.parseInt(st.nextToken());
    m=Integer.parseInt(st.nextToken());
    
    map=new int[n][m];
    dp=new int[n][m];
    
    for(int i=0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      
      for(int j=0;j<m;j++){
        map[i][j]=Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    }

    dp[0][0]=1;
    System.out.println(dfs(n-1,m-1));
    
  }

  private static int dfs(int x, int y){
    if(x==0 && y==0){
      return dp[x][y];
    }
    if(dp[x][y] != -1) return dp[x][y];

    dp[x][y]=0;
    
    for(int i=0; i<4; i++){
      int nx=x+dx[i];
      if(nx < 0 || nx >= n) continue;
      int ny=y+dy[i];
      if(ny < 0 || ny >= m) continue;

      if(map[nx][ny] <= map[x][y]) continue;

      dp[x][y] += dfs(nx, ny);
    }

    return dp[x][y];
  }
}