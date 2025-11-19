import java.util.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static boolean[][] visited;
    static int n, k;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt();
            starts[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int cnt=0;
        visited=new boolean[n][n];

        for(int i =0; i<k;i++){
            if(visited[starts[i][0]-1][starts[i][1]-1]) continue;

            cnt+=bfs(starts[i][0]-1, starts[i][1]-1);
        }

        System.out.println(cnt);
    }

    private static int bfs(int x, int y){
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y]=true;
        int cnt=0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            cnt++;

            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                if(nx <0 || nx >= n) continue;
                
                int ny = cur[1]+dy[i];
                if(ny <0 || ny >= n) continue;

                if(visited[nx][ny]) continue;
                if(grid[nx][ny]==1) continue;

                visited[nx][ny]=true;
                q.add(new int[]{nx, ny});
            }
        }

        return cnt;
    }
}