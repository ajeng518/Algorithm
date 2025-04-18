import java.util.*;
import java.io.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map=new char[n][n];
        
        for(int i =0;i<n;i++) map[i]=br.readLine().toCharArray();

        visited=new boolean[n][n];

        int cnt=0;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                
                bfs(i, j, map[i][j], n, map);
                cnt++;
            }
        }

        visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]!='G') continue;
                map[i][j]='R';
            }
        }

        int cnt2=0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                // if(map[i][j]!= 'R') continue;
                
                bfs(i, j, map[i][j], n, map);
                cnt2++;
            }
        }

        System.out.println(cnt+" "+cnt2);
        
    }

    private static boolean bfs(int sx, int sy, char target, int n, char[][] map){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy]=true;

        while(!q.isEmpty()){
            int[] cur =q.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0]+dx[i];
                if(nx<0 || nx>= n) continue;

                int ny = cur[1]+dy[i];
                if(ny<0 || ny>= n) continue;

                if(map[nx][ny]!=target) continue;
                if(visited[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
            }
        }

        return true;
    }
}