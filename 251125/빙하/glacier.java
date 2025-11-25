import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m, iceCnt, lastSize;
    static int[][] grid;
    static List<int[]> water;
    static boolean[][] visited;
    static Deque<int[]> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        iceCnt=0;
        water= new ArrayList<>();
        visited = new boolean[n][m];

        grid = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();

                if(grid[i][j]==1){
                    iceCnt++;
                }
            }
        }

        System.out.println(process()+" "+lastSize);

    }

    private static int process(){
        int time=0;
        lastSize =iceCnt;

        q=new ArrayDeque<>();
        findWater();

        while(iceCnt > 0){
            lastSize =iceCnt;
            
            meltIce();
            
            time++;
        }

        return time;
    }

    private static void findWater(){
        for(int i=0;i<n;i++){
            if(i==0 || i==n-1){
                for(int j=1;j<m-1;j++){
                    q.add(new int[]{i, j});
                    water.add(new int[]{i, j});
                    visited[i][j]=true;
                    
                }
                continue;
            }
            q.add(new int[]{i, 0});
            q.add(new int[]{i, m-1});

            water.add(new int[]{i, 0});
            water.add(new int[]{i, m-1});

            visited[i][0]=true;
            visited[i][m-1]=true;
        }

        visited[0][0]=true;
        visited[0][m-1]=true;
        visited[n-1][0]=true;
        visited[n-1][m-1]=true;

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
                water.add(new int[]{nx, ny});
            }
        }

        q=new ArrayDeque<>();
        for(int[] wat : water){
            q.add(new int[]{wat[0], wat[1]});
        }
    }

    private static void meltIce(){
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int[] cur = q.poll();

                if(iceCnt == 0) break;

                for(int i=0;i<4;i++){
                    int nx = cur[0]+dx[i];
                    if(nx <0 || nx>= n) continue;

                    int ny = cur[1]+dy[i];
                    if(ny<0 || ny>= m) continue;

                    if(visited[nx][ny]) continue;
                    if(grid[nx][ny]==0) continue;

                    visited[nx][ny]=true;
                    grid[nx][ny] = 0;
                    
                    iceCnt--;
                    q.add(new int[]{nx, ny});
                }
            }
            break;
        }
    }
}