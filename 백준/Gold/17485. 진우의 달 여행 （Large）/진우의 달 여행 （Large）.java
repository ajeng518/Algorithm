import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int INF = 100000000;
    static int[][] dXY = {{-1, -1}, {-1, 0}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[3][n][m];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < m; j++)
                dp[i][0][j] = map[0][j];

            for (int j = 1; j < n; j++)
                Arrays.fill(dp[i][j], INF);

        }

        int min = INF;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int q = 0; q < 3; q++) {
                        if (q == k) continue;

                        if ((i + dXY[q][0] >= 0 && j + dXY[q][1] >= 0) && (i + dXY[q][0] < n && j + dXY[q][1] < m)) {//범위 안임
                            if (dp[q][i + dXY[q][0]][j + dXY[q][1]] == INF) continue;

                            dp[k][i][j] = Math.min(dp[q][i + dXY[q][0]][j + dXY[q][1]] + map[i][j], dp[k][i][j]);
                        }
                        if(i==n-1)
                            min = Math.min(dp[k][n - 1][j], min);
                    }
                }
            }
        }

        System.out.println(min);
    }
}