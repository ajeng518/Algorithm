import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static final int MAX_H=500;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());


        map=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left = 0;
        int right = MAX_H;

        int ans = MAX_H;

        while(left <= right){
            int mid = (left + right)/ 2;

            if(isPossible(mid)){
                right=mid-1;
                ans=Math.min(ans, mid);
            }else left=mid+1;
        }

        return ans;
    }

    private static boolean isPossible(int mid){
        for(int lo=1; lo <= MAX_H; lo++){
            visited=new boolean[n][m];

            int hi = lo + mid;

            if(map[0][0] >=lo && map[0][0] <= hi)
                bfs(lo, hi);
            if(visited[n-1][m-1]) return true;
            
        }

        return false;
    }

    private static void bfs(int lo, int hi){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited[0][0]=true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                if(nx <0 || nx>=n) continue;

                int ny = cur[1]+dy[i];
                if(ny<0 || ny>=m) continue;

                if(visited[nx][ny]) continue;

                if(map[nx][ny] < lo || map[nx][ny] > hi) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
            }            
        }
    }
}