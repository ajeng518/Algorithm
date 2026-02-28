import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0 ,-1};
    static int n;
    static int[][] grid, dp;

    private static int dfs(int x, int y){
        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y]=1;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            if(nx < 0 || nx>= n) continue;

            int ny = y+dy[i];
            if(ny<0 || ny>=n) continue;

            if(grid[nx][ny] <= grid[x][y]) continue;

            dp[x][y]=Math.max(dp[x][y], 1+ dfs(nx, ny));
        }

        return dp[x][y];
    }
}