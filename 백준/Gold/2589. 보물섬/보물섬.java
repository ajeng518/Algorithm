import java.util.*;
import java.io.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    
    static boolean[][] visited;
    static int r, c;
    static char[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map=new char[r][c];
        for(int i =0;i<r;i++) map[i]=br.readLine().toCharArray();

        int max = 0;
        for(int i =0 ;i<r; i++){
            for(int j=0;j<c;j++){
                if(map[i][j] =='W') continue;//바다
                
                visited = new boolean[r][c];
                max=Math.max(bfs(i, j), max);
            }
        }

        System.out.println(max);

    }

    private static int bfs(int x, int y){
        Deque<int[]> q =new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y]=true;
        int cnt =-1;

        while(!q.isEmpty()){
            int size=q.size();

            while(size-- > 0){
                int[] cur = q.poll();
    
                for(int i =0; i<4; i++){
                    int nx =cur[0]+dx[i];
                    if(nx <0 ||nx>=r )continue;
                    
                    int ny=cur[1]+dy[i];
                    if(ny <0 || ny>=c) continue;
    
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny]=='W') continue;
                    
                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }
            cnt++;
        }

        return cnt;
    }
}