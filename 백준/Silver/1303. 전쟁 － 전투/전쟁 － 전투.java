import java.util.*;
import java.io.*;

public class Main {
    static boolean[][]visited;
    static int[] dx={1, 0, -1, 0};
    static int[] dy={0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());//
        int m = Integer.parseInt(st.nextToken());//

       char[][] map=new char[m][n];
        for(int i=0;i<m;i++){
            map[i]=br.readLine().toCharArray();
        }
        
        int[] ans=new int[2];
        visited=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) continue;
                
                int[] cur=bfs(m, n, map, i, j, map[i][j]);
                ans[0]+=cur[0];
                ans[1]+=cur[1];
            }
        }

        System.out.println(ans[0]+" "+ans[1]);
        
    }

    private static int[] bfs(int m, int n, char[][] map, int sx, int sy, char target){
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sx, sy});

        visited[sx][sy]=true;
        int cnt=0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;

            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                if(nx<0 || nx>=m) continue;

                int ny=cur[1]+dy[i];
                if(ny<0 || ny>=n) continue;

                if(map[nx][ny]!= target) continue;
                if(visited[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
            }
        }

        cnt*=cnt;
        
        if(target=='W'){
            return new int[]{cnt, 0};
        }else{
            return new int[]{0, cnt};
        }
    }
}