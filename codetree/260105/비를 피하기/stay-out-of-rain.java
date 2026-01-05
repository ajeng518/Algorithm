import java.util.*;

public class Main {
    static int n, h, m;
    static int[][] ans, a;
    static boolean[][] visited;
    static int[] dx={-1 ,0, 1, 0};
    static int[] dy={0 ,1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        ans=new int[n][n];
        visited=new boolean[n][n];

        process();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void process (){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(h==0) return;
                if(a[i][j] != 2) continue;

                // if(h > 0 && m <=0){
                //     ans[i][j]=-1;
                //     h--;
                // } else{
                    int time = bfs(i, j);
                    ans[i][j]=time;

                    // if(time != -1)
                    //     m--;
                    h--;
                // }
                
            }
        }
    }

    private static int bfs(int x, int y){
        Deque<int[]>q =new ArrayDeque<>();
        boolean[][] chk = new boolean[n][n];
        q.add(new int[]{x, y});
        chk[x][y]=true;
        int cnt=0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int[] cur = q.poll();

                if(a[cur[0]][cur[1]]== 3){
                    // if( !visited[cur[0]][cur[1]]){
                        // visited[cur[0]][cur[1]]=true;
                        return cnt;
                    // }
                    // else continue;
                }

                for(int i=0;i< 4; i++){
                    int nx = cur[0]+dx[i];
                    if(nx <0 || nx>=n) continue;

                    int ny = cur[1]+dy[i];
                    if(ny < 0 || ny>=n) continue;

                    if(chk[nx][ny]) continue;
                    if(a[nx][ny]==1) continue;

                    q.add(new int[]{nx, ny});
                    chk[nx][ny]=true;
                }
            }

            cnt++;
        }

        return -1;
    }
}