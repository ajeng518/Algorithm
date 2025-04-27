import java.util.*;
import java.io.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n, m, k, cnt;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st=new StringTokenizer(br.readLine());
            m=Integer.parseInt(st.nextToken());//가로
            n=Integer.parseInt(st.nextToken());//세로
            k=Integer.parseInt(st.nextToken());

            map=new int[n][m];
            visited=new boolean[n][m];
            cnt=0;

            for(int i=0;i<k;i++){
                st=new StringTokenizer(br.readLine());
                int py=Integer.parseInt(st.nextToken());//가로
                int px=Integer.parseInt(st.nextToken());//세로

                map[px][py]=1;
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==0) continue;
                    if(visited[i][j]) continue;

                    bfs(i, j);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y){
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] cur =q.poll();
            
            for(int i=0;i<4;i++){
                int nx =cur[0]+dx[i];
                if(nx<0 || nx>=n) continue;
                
                int ny=cur[1]+dy[i];
                if(ny<0 || ny>=m) continue;

                if(map[nx][ny]==0)continue;
                if(visited[nx][ny])continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
            }
        }
    }
}