import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left=0;
        int right=1000000;
        int ans=1000000;

        while(left <= right){
            int mid = (left+right)/2;

            if(chkColorCnt(mid)){
                right=mid-1;
                ans=Math.min(ans, mid);
            }else left=mid+1;
        }

        return ans;
    }

    private static boolean chkColorCnt(int mid){
        boolean[][] visited=new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) continue;
                if(bfs(mid, i, j, visited)*2 >= n*n) return true;
            }
        }

        return false;
    }

    private static int bfs(int mid, int x, int y, boolean[][] visited){
        int[] dx={-1, 0, 1, 0};
        int[] dy={ 0, 1, 0, -1};

        int cnt=0;
        Deque<int[]>q = new ArrayDeque<>();

        q.add(new int[]{x, y, mid});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4; i++){
                int nx = cur[0]+ dx[i];
                if(nx <0 || nx>=n) continue;

                int ny=cur[1]+dy[i];
                if(ny <0 || ny>=n) continue;

                if(visited[nx][ny]) continue;
                if(Math.abs(map[cur[0]][cur[1]]-map[nx][ny]) > mid) continue;

                q.add(new int[]{nx, ny, mid});
                visited[nx][ny]=true;
            }

            cnt++;
        }

        return cnt;
    }
}