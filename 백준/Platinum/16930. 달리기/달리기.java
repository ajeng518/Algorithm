import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] map=new char[n][m];
        
        for(int i=0;i<n;i++){
            map[i]=br.readLine().toCharArray();
        }

        st=new StringTokenizer(br.readLine());
        int[] start = {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};
        int[] end = {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};

        System.out.println(bfs(n, m, k, map, start, end));
        
  }

    private static int bfs(int n, int m, int k, char[][] map, int[] start, int[] end){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
        Deque<int[]> q = new ArrayDeque<>();
        int cnt =0;
        
        q.add(start);
        visited[start[0]][start[1]]=0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int dist = visited[cur[0]][cur[1]];

            if(cur[0]==end[0] && cur[1]==end[1]) return dist;
            
            for(int d=0; d<4; d++){
                for(int len = 1; len<=k; len++){
                    int nx = cur[0]+(dx[d]*len);
                    if(nx < 0 || nx >= n) break;

                    int ny = cur[1]+(dy[d]*len);
                    if(ny < 0 || ny >= m) break;
                    if(map[nx][ny]=='#') break;
                    
                    if(visited[nx][ny]<=dist) break;
                    if(visited[nx][ny]==dist+1) continue;

                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=dist+1;
                }
            }

        }

        return -1;
    }
}