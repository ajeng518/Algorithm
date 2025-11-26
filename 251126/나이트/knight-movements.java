import java.util.*;
public class Main {
    static int[] dx={-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy={-2, -1, 1, 2, 2, 1, -1, -2};
    static int n, r1, c1, r2, c2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        // Please write your code here.

        System.out.println(bfs());
    }

    private static int bfs(){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited= new boolean[n][n];

        q.add(new int[]{r1-1, c1-1});
        visited[r1-1][c1-1]=true;
        int cnt =0;
        while(!q.isEmpty()){
            int size =q.size();

            while(size-- > 0){
                int[] cur = q.poll();
                if(cur[0]==r2-1 && cur[1]==c2-1) return cnt;

                for(int i=0;i<8; i++){
                    int nx = cur[0]+dx[i];
                    if(nx < 0 || nx>=n) continue;

                    int ny = cur[1]+dy[i];
                    if(ny < 0 || ny>=n) continue;

                    if(visited[nx][ny]) continue;

                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }

            cnt++;
        }

        return -1;
    }
}