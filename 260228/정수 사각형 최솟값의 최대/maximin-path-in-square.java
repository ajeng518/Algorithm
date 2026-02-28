import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int answer = bfs(n, matrix);
        System.out.println(answer);
    }
    
    static int[] dx={0, 1};
    static int[] dy={1, 0};

    private static int bfs(int n, int[][] matrix){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, matrix[0][0]});
        int max = 0;

        while(!q.isEmpty()){

            int[] cur = q.poll();

            if(cur[0]==n-1 && cur[1]==n-1){
                max = Math.max(max, cur[2]);
                continue;
            }

            for(int i=0; i<2;i++){
                int nx = cur[0]+dx[i];
                if(nx < 0 || nx>= n) continue;

                int ny = cur[1]+dy[i];
                if(ny < 0 || ny>= n) continue;

                q.add(new int[]{nx, ny, Math.min(cur[2], matrix[nx][ny])});
            }
        }

        return max;
    }
}