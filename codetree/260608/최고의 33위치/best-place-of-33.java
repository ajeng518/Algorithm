import java.util.*;
import java.io.*;
public class Main {
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int cnt =0;
        int max=-1;

        for(int i=0; i <= n-3; i++){

            cnt=downStep(i, 0);
            max=Math.max(max, cnt);

            for(int j=1; j <= n-3; j++){
                cnt = rightStep(i, j, cnt);
                max=Math.max(max, cnt);
            }
        }

        System.out.println(max);
    }
    
    private static int rightStep(int x, int y, int total){
        for(int i = x; i<x+3; i++){
            total -= grid[i][y-1];
            total += grid[i][y+2];
        }

        return total;
    }

    private static int downStep(int x, int y){
        int sum = 0;

        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                sum += grid[i][j];
            }
        }

        return sum;
    }
}