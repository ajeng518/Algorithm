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
        q.add(new int[]{0, 0});
        q.add(new int[]{0, m-1});
        q.add(new int[]{n-1, 0});
        q.add(new int[]{n-1, m-1});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            water.add(new int[]{cur[0], cur[1]});

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