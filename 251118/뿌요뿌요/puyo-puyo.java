import java.util.Scanner;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};

    static int n, cnt;
    static int[][] grid;
    static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited=new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // Please write your code here.
        int maxIdx=0;
        int bombCnt=0;
        int maxCnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) continue;

                cnt=0;
                visited[i][j]=true;
                dfs(i, j, grid[i][j]);

                if(cnt >=4)
                    bombCnt++;

                if(cnt > maxCnt){
                    maxCnt=cnt;
                    maxIdx=grid[i][j];
                }
            }
        }

        System.out.println(bombCnt+" "+maxCnt);
    }

    private static void dfs(int x, int y, int k){
        cnt++;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            if(nx <0 || nx>=n) continue;

            int ny=y+dy[i];
            if(ny <0 ||ny>=n) continue;

            if(visited[nx][ny]) continue;
            if(grid[nx][ny] != k) continue;

            visited[nx][ny]=true;
            dfs(nx, ny, k);
        }
    }
}