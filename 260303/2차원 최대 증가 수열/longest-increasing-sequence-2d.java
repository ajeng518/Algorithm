import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] dp=new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        dp[0][0]=1;

        
        for(int i=0; i < n; i++){
            for(int j = 0; j<m; j++){
                for(int k=0; k < i; k++){
                    for(int l=0; l<j; l++){
                        if(dp[k][l]==-1) continue;
                        if(grid[k][l] >= grid[i][j]) continue;

                        dp[i][j]=Math.max(dp[i][j], dp[k][l] + 1);
                    }
                }
            }
        }

        int ans=-1;
        for(int i=0; i < n; i++){
            for(int j = 0; j<m; j++){
                ans=Math.max(dp[i][j], ans);
            }
        }
        System.out.println(ans);
    }
}