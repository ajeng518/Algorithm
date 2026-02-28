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
        
    }
    
    private static int bfs(int[][] matrix){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        int max = 0;

        while(!q.isEmpty()){
            while()
        }


    }
}