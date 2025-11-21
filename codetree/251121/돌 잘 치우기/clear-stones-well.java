import java.util.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};

    static boolean[][] visited;
    static int n, k, m, maxCnt;
    static int[][] grid;
    static int[][] startPoints;
    static List<int[]> rockList;
    static Deque<int[]> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//map size
        k = sc.nextInt();//start cnt
        m = sc.nextInt();//make turn

        rockList = new ArrayList<>();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if(grid[i][j]==1){
                    rockList.add(new int[]{i, j});
                }
            }
        }

        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt();
            startPoints[i][1] = sc.nextInt();
        }
        // Please write your code here.
        //0: go, 1: stop

        maxCnt=0;
        combi(0, 0);
        System.out.println(maxCnt);
    }
    private static void preProcess(){
        q=new ArrayDeque<>();
        visited=new boolean[n][n];

        for (int i = 0; i < k; i++) {
            q.add(new int[]{startPoints[i][0] - 1, startPoints[i][1] - 1});
            visited[startPoints[i][0] - 1][startPoints[i][1] - 1]=true;
        }

        return;
    }

    private static void combi(int now, int cnt){
        if(cnt == m){
            maxCnt=Math.max(maxCnt, bfs());

            return;
        }

        for(int i=now; i<rockList.size(); i++){
            grid[rockList.get(i)[0]][rockList.get(i)[1]]=0;
            combi(i+1, cnt+1);
            grid[rockList.get(i)[0]][rockList.get(i)[1]]=1;
        }

    }

    private static int bfs(){
        preProcess();
        int cnt=0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;

            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                if(nx <0 || nx >= n) continue;
                
                int ny = cur[1]+dy[i];
                if(ny <0 || ny >= n) continue;
                if(grid[nx][ny] == 1) continue;

                if(visited[nx][ny]) continue;

                visited[nx][ny]=true;
                q.add(new int[]{nx, ny});
            }
        }

        return cnt;
    }
}