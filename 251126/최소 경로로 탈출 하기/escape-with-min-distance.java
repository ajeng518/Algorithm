import java.util.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        // Please write your code here.

        System.out.println(bfs());
    }

    private static int bfs(){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited= new boolean[n][m];

        q.add(new int[]{0, 0});
        visited[0][0]=true;
        int cnt =0;
        while(!q.isEmpty()){
            int size =q.size();

            while(size-- > 0){
                int[] cur = q.poll();
                if(cur[0]==n-1 && cur[1]==m-1) return cnt;

                for(int i=0;i<4; i++){
                    int nx = cur[0]+dx[i];
                    if(nx < 0 || nx>=n) continue;

                    int ny = cur[1]+dy[i];
                    if(ny < 0 || ny>=m) continue;

                    if(visited[nx][ny]) continue;
                    if(a[nx][ny] == 0) continue;

                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }

            cnt++;
        }

        return -1;
    }
}