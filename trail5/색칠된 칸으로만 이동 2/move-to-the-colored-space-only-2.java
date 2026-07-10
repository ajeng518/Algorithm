import java.io.*;
import java.util.*;

public class Main {
    static int n, m, startX, startY;
    static long max, ans;
    static long[][] map, color;
    static List<int[]> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max=0;

        map = new long[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]= Long.parseLong(st.nextToken());
                max=Math.max(max, map[i][j]);
            }
        }

        ans=0;

        color = new long[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                color[i][j]= Integer.parseInt(st.nextToken());

                if(color[i][j] == 1){
                    startX=i;
                    startY=j;
                }
            }
        }
        System.out.println(binarySearch());
    }

    private static long binarySearch(){
        long left=0;
        long right=max;
        long ans=max;

        while(left <= right){
            long mid = (left+right)/2;

            if(chkColorCnt(mid)){
                right=mid-1;
                ans=mid;
            }else left=mid+1;
        }

        return ans;
    }

    private static boolean chkColorCnt(long mid){
        boolean[][] visited=new boolean[n][m];

        bfs(mid, visited);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(color[i][j] == 0) continue;

                if(!visited[i][j]) return false;
            }
        }

        return true;
    }

    private static void bfs(long mid, boolean[][] visited){
        int[] dx={-1, 0, 1, 0};
        int[] dy={ 0, 1, 0, -1};

        int cnt=0;
        Deque<int[]>q = new ArrayDeque<>();

        q.add(new int[]{startX, startY});
        visited[startX][startY]=true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4; i++){
                int nx = cur[0]+ dx[i];
                if(nx <0 || nx >= n) continue;

                int ny= cur[1]+dy[i];
                if(ny <0 || ny >= m) continue;

                if(visited[nx][ny]) continue;
                if(Math.abs(map[cur[0]][cur[1]]-map[nx][ny]) > mid) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
            }
        }
    }
}