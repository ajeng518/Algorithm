import java.util.*;
import java.io.*;

public class Main {
  static int n, len;
  static int[][] map;
  static int[] dx={-1, 0, 1, 0};
  static int[] dy={0, 1, 0, -1};
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n=Integer.parseInt(br.readLine());
    
    map=new int[n][n];
    
    for(int i=0;i<n;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0; j<n; j++){
        map[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    int island=1;
    boolean[][]visited=new boolean[n][n];
    
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(map[i][j]== 0) continue;
        if(visited[i][j]) continue;
        
        bfs(i, j, true, ++island, visited);
        
      }
    }

    // for(int i=0;i<n;i++) System.out.println(Arrays.toString(map[i]));

    visited=new boolean[n][n];
    int min=Integer.MAX_VALUE;
    
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(map[i][j]==0)continue;
        if(visited[i][j]) continue;
        if(!chkNotCenter(i,j, map[i][j])) continue;
        
        bfs(i,j,false, map[i][j], new boolean[n][n]);

        min=Math.min(len, min);
      }
    }

    System.out.println(min);
    
  }

  private static boolean chkNotCenter(int x, int y, int island){
    int cnt=0;
    for(int i=0; i<4; i++){
      int nx=x+dx[i];
      if(nx<0||nx>=n) continue;
      int ny=y+dy[i];
      if(ny<0||ny>=n) continue;
      
      if(map[nx][ny]==0) return true;
    }

    return false;
  }

  private static void bfs(int sx, int sy, boolean findMine, int mine, boolean[][] chk){
    Deque<int[]> q=new ArrayDeque<>();
    q.add(new int[]{sx,sy, 0});
    chk[sx][sy]=true;
    map[sx][sy]=mine;

    while(!q.isEmpty()){
      int[] cur=q.poll();
      
      if(!findMine){
        if(map[cur[0]][cur[1]] != mine && map[cur[0]][cur[1]] != 0){
          len=cur[2] - 1;
          return;
        } 
      }

      for(int i=0; i<4; i++){
        int nx = cur[0] + dx[i];
        if(nx<0 || nx>=n) continue;
        int ny = cur[1] + dy[i];
        if(ny<0 || ny>=n) continue;
        
        if(chk[nx][ny])continue;
        
        if(findMine){//내 구역 찾기
          if(map[nx][ny]== 0) continue;

          q.add(new int[]{nx, ny});
          chk[nx][ny]=true;
          map[nx][ny]=mine;
        }else{//다리 놓기 위한 다른 섬 탐색
          if(map[nx][ny] == mine) continue;

          q.add(new int[]{nx, ny, cur[2]+1});
          chk[nx][ny]=true;
        }
        
      }
    }
  }
}