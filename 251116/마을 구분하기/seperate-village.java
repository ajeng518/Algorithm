import java.util.*;
import java.io.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] grid;
    static boolean[][] visited;
    static int n, cnt, vill;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();

        n = sc.nextInt();
        grid = new int[n][n];
        List<Integer> cntList=new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.
        cnt=0;
        vill=0;
        visited=new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) continue;
                if(grid[i][j]==0) continue;

                visited[i][j]=true;
                dfs(i, j);
                vill++;

                cntList.add(cnt);
                cnt=0;
            }
        }

        sb.append(vill).append("\n");
        Collections.sort(cntList);
        for(int i=0;i<cntList.size(); i++) sb.append(cntList.get(i)).append("\n");

        System.out.print(sb);

    }

    private static void dfs(int x, int y){
        cnt++;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            if(nx <0 || nx>=n) continue;

            int ny = y+dy[i];
            if(ny <0 || ny>=n) continue;

            if(grid[nx][ny]==0) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny]=true;
            dfs(nx, ny);
        }
    }
}