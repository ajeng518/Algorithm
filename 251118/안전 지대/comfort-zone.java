import java.util.Scanner;
public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};

    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        
        int maxHigh=0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
                maxHigh=Math.max(maxHigh, grid[i][j]);
            }
        }
        
        int max = 1;
        int k =1;
        int maxK=1;

        while(k++ < maxHigh){
            int cur=0;
            visited=new boolean[n][m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]) continue;
                    if(grid[i][j] <= k) continue;

                    visited[i][j]=true;
                    dfs(i, j, k);
                    cur++;
                }
            }

            if(cur > max){
                max=cur;
                maxK=k;
            }
        }

        System.out.println(maxK+" "+max);
    }

    private static void dfs(int x, int y, int k){

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            if(nx <0 || nx>=n) continue;

            int ny=y+dy[i];
            if(ny <0 ||ny>=m) continue;

            if(visited[nx][ny]) continue;
            if(grid[nx][ny] <= k) continue;

            visited[nx][ny]=true;
            dfs(nx, ny, k);
        }
    }
}