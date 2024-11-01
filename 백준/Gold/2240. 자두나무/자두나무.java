import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] tree = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[t + 1][w + 1];
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                if (j == 0) {//1번 나무임
                    if (tree[i] != 1) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j]+1;
                    }
                } else if(j%2==0){
                    if (tree[i] == 1) {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]+1);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                    }
                }else{
                    if (tree[i] == 2) {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]+1);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= w; i++) {
            max = Math.max(max, dp[t][i]);
        }

        System.out.println(max);
    }
}