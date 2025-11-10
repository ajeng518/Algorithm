import java.util.*;
public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        if(bfs(n, m, grid)) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean bfs(int n, int m, int[][] grid){
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q= new ArrayDeque<>();

        visited[0][0]=true;
        q.add(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0]==n-1 && cur[1]==m-1) return true;

            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                if(nx < 0 || nx>= n) continue;
                
                int ny = cur[1]+dy[i];
                if(ny < 0 || ny>= m) continue;

                if(grid[nx][ny]==0) continue;
                if(visited[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
            }
        }

        return false;
    }
}