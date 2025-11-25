import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m, iceCnt, lastSize;
    static int[][] grid;
    static List<int[]> melt;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        iceCnt=0;

        grid = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();

                if(grid[i][j]==1){
                    iceCnt++;
                }
            }
        }

        melt= new ArrayList<>();
        visited = new boolean[n][m];

        System.out.println(process()+" "+lastSize);

    }

    private static int process(){
        int time=0;
        lastSize =iceCnt;

        while(iceCnt > 0){
            lastSize =iceCnt;

            findWater();
            meltIce();

            time++;
        }

        return time;
    }

    private static void findWater(){
        Deque<int[]> q=new ArrayDeque<>();

        q.add(new int[]{0, 0});
        visited[0][0]=true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                if(nx <0 || nx>= n) continue;

                int ny = cur[1] + dy[i];
                if(ny<0 || ny>= m) continue;

                if(visited[nx][ny]) continue;
                if(grid[nx][ny]==1) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
                
            }
        }
    }

    private static void meltIce(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) continue;

               if(!isMelting(i, j)) continue;

                melt.add(new int[]{i, j});
                iceCnt--;
            }
        }

        for(int[] cur : melt){
            visited[cur[0]][cur[1]]=true;
            grid[cur[0]][cur[1]]=0;
        }
    }
    private static boolean isMelting(int x, int y){
        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            if(nx <0 || nx>= n) continue;

            int ny = y + dy[d];
            if(ny<0 || ny>= m) continue;

            if(grid[nx][ny]==1) continue;
            if(!visited[nx][ny]) continue;

            
            return true;
        }

        return false;
    }
}