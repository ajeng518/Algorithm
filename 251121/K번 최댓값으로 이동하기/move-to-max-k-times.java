import java.util.*;

public class Main {
    static class MaxNum implements Comparable<MaxNum>{
        int num;
        int x;
        int y;

        MaxNum(int num, int x, int y){
            this.num=num;
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(MaxNum o){
            if(o.num == this.num){
                if(this.x == o.x){
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return o.num - this.num;
        }
    }

    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};

    static int n, k, r, c;
    static boolean[][] visited;
    static PriorityQueue<MaxNum> pq;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//크기
        k = sc.nextInt();//반복할수 있는 횟수

        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        r = sc.nextInt()-1;
        c = sc.nextInt()-1;

        visited=new boolean[n][n];

        while(k-- > 0){
            if(!bfs(r, c, grid[r][c])) break;
        }
        
        System.out.println((r+1)+" "+(c+1));
    }

    private static boolean bfs(int x, int y, int value){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        visited=new boolean[n][n];
        visited[x][y]=true;
        pq=new PriorityQueue<>();

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                if(nx <0 || nx>=n) continue;

                int ny = cur[1]+dy[i];
                if(ny<0 || ny>=n) continue;
                
                if(visited[nx][ny]) continue;
                if(grid[nx][ny] >= value) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny]=true;
                pq.add(new MaxNum(grid[nx][ny], nx, ny));
            }
        }

        if(pq.isEmpty()) return false;

        MaxNum curMax=pq.poll();
        r = curMax.x;
        c = curMax.y;
        return true;
    }
}