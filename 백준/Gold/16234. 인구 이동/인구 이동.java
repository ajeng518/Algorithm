import java.util.*;
import java.io.*;

public class Main {
  static int[][] map;
  static int n, l, r;
  static boolean[][] visited;
  
  static int[] dx={-1, 0, 1, 0};
  static int[] dy={0, 1, 0, -1};
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    n=Integer.parseInt(st.nextToken());
    l=Integer.parseInt(st.nextToken());
    r=Integer.parseInt(st.nextToken());
    
    map=new int[n][n];
    for(int i=0;i<n;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0;j<n;j++){
        map[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    int ans=0;
    while(true){
      visited=new boolean[n][n];
      int cnt=0;
      for(int i=0;i<n ;i++){
        for(int j=0; j<n; j++){
          if(visited[i][j]) continue;
          if(!bfs(i, j)) continue;

          cnt++;
        }
      }
      if(cnt==0) break;
      ans++;
    }

    System.out.println(ans);
  }

  private static boolean bfs(int sx, int sy){
    Deque<int[]> q=new ArrayDeque<>();
    q.add(new int[]{sx, sy});
    visited[sx][sy]=true;
    List<int[]> openList=new ArrayList<>();

    while(!q.isEmpty()){
      int[] cur=q.poll();
      openList.add(cur);
      
      for(int i=0;i<4;i++){
        int nx=cur[0]+dx[i];
        if(nx<0 || nx>=n) continue;
        
        int ny=cur[1]+dy[i];
        if(ny<0 ||ny>=n) continue;

        if(visited[nx][ny]) continue;
        if(Math.abs(map[cur[0]][cur[1]]-map[nx][ny])<l || Math.abs(map[cur[0]][cur[1]]-map[nx][ny])>r) continue;

        q.add(new int[]{nx, ny});
        visited[nx][ny]=true;
      }
    }

    if(openList.size()>1){
      openDoor(openList);
      return true;
    }else{
      return false;
    }
  }

  private static void openDoor(List<int[]> openList){
    int sum=0;
    
    for(int i=0;i<openList.size(); i++){
      int[] cur=openList.get(i);
      sum+=map[cur[0]][cur[1]];
    }

    int avg=sum/openList.size();

    for(int i=0;i<openList.size(); i++){
      int[] cur=openList.get(i);
      map[cur[0]][cur[1]]=avg;
    }
  }
}