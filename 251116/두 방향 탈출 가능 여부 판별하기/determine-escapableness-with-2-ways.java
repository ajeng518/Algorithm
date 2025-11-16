import java.util.Scanner;
public class Main {
    static int[] dx={0, 1};
    static int[] dy={1, 0};
    static boolean[][] visited;
    static int n, m;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        visited=new boolean[n][m];

        if(dfs(0, 0)) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean dfs(int x, int y){
        if(x==n-1 && y==m-1){
            return true;
        }

        for(int i=0;i<2;i++){
            int nx = x+dx[i];
            if(nx <0 || nx>=n) continue;

            int ny = y+dy[i];
            if(ny <0 || ny>=m) continue;

            if(grid[nx][ny]==0) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny]=true;
            if(dfs(nx, ny)) return true;
        }

        return false;
    }
}