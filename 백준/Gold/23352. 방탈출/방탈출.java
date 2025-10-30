import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int[] ans;

    static int[] dx={-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map= new int[n][m];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        ans=new int[2501];
        int maxLen =0;
        
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(map[i][j]==0) continue;
                
                maxLen = Math.max(maxLen, bfs(i, j));
            }
        }

        System.out.println(ans[maxLen]);
    }

    private static int bfs(int startX, int startY){
        Deque<int[]> q = new ArrayDeque<>();
        visited=new boolean[n][m];
        visited[startX][startY]=true;
        q.add(new int[]{startX, startY, map[startX][startY], 0, 1});
        int cnt =0;

        while(!q.isEmpty()){
            int s = q.size();

            while(s-- > 0){
                int[] cur = q.poll();
                
                if(cur[4] > 1){
                    ans[cur[4]] = Math.max(cur[2]+cur[3], ans[cur[4]]);
                }
                
                 for(int i=0;i<4;i++){
                     int nx = cur[0] + dx[i];
                     if(nx <0 ||nx>=n) continue;

                     int ny = cur[1] + dy[i];
                     if(ny < 0 || ny >= m) continue;

                     if(visited[nx][ny]) continue;
                     if(map[nx][ny] == 0) continue;

                     q.add(new int[]{nx,ny, cur[2], map[nx][ny], cur[4]+1});
                     visited[nx][ny]=true;
                 }
            }
            
            cnt++;
        }

        return cnt;
    }
}
