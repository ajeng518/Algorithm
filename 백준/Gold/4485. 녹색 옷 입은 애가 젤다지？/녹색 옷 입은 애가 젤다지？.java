import java.util.*;
import java.io.*;

public class Main {
  static int[] dx={-1, 0 ,1 ,0};
  static int[] dy={0, 1, 0, -1};

  static class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;

    Node(int x, int y, int cost){
      this.x=x;
      this.y=y;
      this.cost=cost;
    }

    public int compareTo(Node o){
      return this.cost-o.cost;
    }
  }
  
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
      
      PriorityQueue<Node> pq=new PriorityQueue<>();
      pq.add(new Node(0, 0, dp[0][0]));

      while(!pq.isEmpty()){
        Node cur=pq.poll();
        if(cur.x==n-1 && cur.y==n-1) break;

        for(int i=0;i<4;i++){
          int nx=cur.x+dx[i];
          if(nx<0 || nx>=n) continue;
          int ny=cur.y+dy[i];
          if(ny<0 || ny>=n) continue;

          if(dp[nx][ny]<= dp[cur.x][cur.y]+map[nx][ny]) continue;
          dp[nx][ny]= dp[cur.x][cur.y]+map[nx][ny];
          pq.add(new Node(nx, ny, dp[nx][ny]));
        }
      }
      
      sb.append("Problem ").append(idx).append(": ").append(dp[n-1][n-1]).append("\n");
      idx++;
    }

    System.out.println(sb);
  }
}