import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int n, k;

    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map=new int[n][n];
        visited= new boolean[n][n][k+1];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[] start =new int[2];
        int[] end = new int[2];
        
        st = new StringTokenizer(br.readLine());
        start[0]=Integer.parseInt(st.nextToken())-1;
        start[1]=Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        end[0]=Integer.parseInt(st.nextToken())-1;
        end[1]=Integer.parseInt(st.nextToken())-1;

        System.out.println(bfs(start, end));

    }

    private static int bfs(int[] start, int[] end){
        Deque<int[]> q =  new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], k});
        visited[start[0]][start[1]][k]=true;

        int cnt=0;

        while(!q.isEmpty()){
            int size= q.size();
            while(size-- > 0){
                int[] cur = q.poll();

                if(cur[0]==end[0] && cur[1]==end[1]){
                    return cnt;
                } 

                for(int i=0; i<4; i++){
                    int nx = cur[0]+dx[i];
                    if(nx< 0 || nx>=n) continue;

                    int ny = cur[1]+dy[i];
                    if(ny < 0 || ny >= n) continue;

                    if(visited[nx][ny][cur[2]]) continue;

                    if(map[nx][ny]==1){
                        if(cur[2] > 0){
                            q.add(new int[]{nx, ny, cur[2]-1});
                            visited[nx][ny][cur[2]-1]=true;
                        }
                    }else{
                        q.add(new int[]{nx, ny, cur[2]});
                        visited[nx][ny][cur[2]]=true;
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}