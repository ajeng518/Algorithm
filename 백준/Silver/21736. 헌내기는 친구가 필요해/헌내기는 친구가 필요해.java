import java.util.*;
import java.io.*;

public class Main {    
    static int sx, sy;
    static int[] dx={0, 1, 0, -1};
    static int[] dy={1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map=new char[n][m];
        for(int i =0;i<n;i++){
            map[i]=br.readLine().toCharArray();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]!='I') continue;

                sx=i;
                sy=j;
                break;
            }
        }

        int ans = bfs(n, m, map);
        if(ans==0) System.out.println("TT");
        else System.out.println(ans);
        
    }

    private static int bfs(int n, int m, char[][] map){
        int cnt=0;
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sx, sy});

        boolean[][] visited=new boolean[n][m];
        visited[sx][sy]=true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(map[cur[0]][cur[1]]=='P') cnt++;

            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                if(nx<0 ||nx>=n) continue;
                
                int ny=cur[1]+dy[i];
                if(ny<0||ny>=m) continue;

                if(visited[nx][ny]) continue;
                if(map[nx][ny]=='X') continue;

                visited[nx][ny]=true;
                q.add(new int[]{nx,ny});
            }
        }

        return cnt;
    }
}