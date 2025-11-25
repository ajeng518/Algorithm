import java.util.*;

public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};

    static int[][] grid, idxMap;
    static int n, k, u, d, max;
    static Map<Integer, int[]> cityMap;
    static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        
        grid = new int[n][n];
        idxMap = new int[n][n];
        cityMap=new HashMap<>();
        int idx=1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                cityMap.put(idx, new int[]{i, j});
                idxMap[i][j]=idx++;
            }
        }

        // Please write your code here.

        process();

        System.out.println(max);
    }

    private static void process(){
        //k개 조합 구하기
        temp=new int[k];
        max=0;

        combi(1, 0);
    }

    private static void combi(int cur, int cnt){
        if(cnt == k){
            int curCnt = bfs();
            max=Math.max(curCnt, max);
            return;
        }

        for(int i =cur; i <= n*n; i++){
            temp[cnt]=i;
            combi(i+1, cnt+1);
        }
    }

    private static int bfs(){
        Deque<Integer> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        Set<Integer> go = new HashSet<>();

        for(int i =0;i<k;i++){
            int city = temp[i];
            q.add(city);

            int[] cur = cityMap.get(city);
            visited[cur[0]][cur[1]]=true;
            // System.out.println("city: "+city+",  x: "+cur[0]+", y: "+cur[1]);
        }

        while(!q.isEmpty()){
            int curCity = q.poll();
            int[] cur = cityMap.get(curCity);
            
            // System.out.println("현재: "+curCity+",  x: "+cur[0]+", y: "+cur[1]);

            for(int i=0;i<4; i++){
                int nx = cur[0]+dx[i];
                if(nx<0 || nx>=n) continue;

                int ny = cur[1]+dy[i];
                if(ny<0 || ny>=n) continue;

                if(visited[nx][ny]) continue;
                if(Math.abs(grid[cur[0]][cur[1]] - grid[nx][ny]) < u) continue;
                if(Math.abs(grid[cur[0]][cur[1]] - grid[nx][ny]) > d) continue;

                visited[nx][ny]=true;
                q.add(idxMap[nx][ny]);
                go.add(idxMap[nx][ny]);
            }
        }

        // System.out.println(go.size()+"개  갑니다.!!");
        return go.size()+k;


    }
}