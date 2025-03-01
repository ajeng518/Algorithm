import java.util.*;
import java.io.*;

public class Main {
  static int[] dx={-1, 0 ,1 ,0};
  static int[] dy={0, 1, 0, -1};
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb=new StringBuilder();
    int idx=1;

    while(true){
      int n=Integer.parseInt(br.readLine());
      if(n==0) break;
  
      int[][] map=new int[n][n];
      for(int i=0;i<n;i++){
        st=new StringTokenizer(br.readLine());
        for(int j=0;j<n;j++){
          map[i][j]=Integer.parseInt(st.nextToken());
        }
      }
  
      int[][] dp=new int[n][n];
      for(int i=0;i<n;i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
      dp[0][0]=map[0][0];
      
      PriorityQueue<int[]> pq=new PriorityQueue<>((a1, a2)-> a1[2]-a2[2]);
      pq.add(new int[]{0, 0, dp[0][0]});

      while(!pq.isEmpty()){
        int[] cur=pq.poll();
        if(cur[0]==n-1 && cur[1]==n-1) break;

        for(int i=0;i<4;i++){
          int nx=cur[0]+dx[i];
          if(nx<0 || nx>=n) continue;
          int ny=cur[1]+dy[i];
          if(ny<0 || ny>=n) continue;

          if(dp[nx][ny]<= dp[cur[0]][cur[1]]+map[nx][ny]) continue;
          dp[nx][ny]= dp[cur[0]][cur[1]]+map[nx][ny];
          pq.add(new int[]{nx, ny, dp[nx][ny]});
        }
      }
      
      sb.append("Problem ").append(idx).append(": ").append(dp[n-1][n-1]).append("\n");
      idx++;
    }

    System.out.println(sb);
  }
}