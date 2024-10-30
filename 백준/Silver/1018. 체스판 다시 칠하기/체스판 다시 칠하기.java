import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        char[][] trueAns = {
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };

        for (int i = 0; i < n; i++) {

            map[i] = br.readLine().toCharArray();
        }

        int min = 22600;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int cntW = 64;
                int cntB = 64;

                for (int k = i; k < i + 8; k++) {

                    for (int q = j; q < j + 8; q++) {

                        cntW -= ((k - i) % 2 == 0) ? ((trueAns[0][q - j] != map[k][q]) ? 0 : 1) : ((trueAns[1][q - j] != map[k][q]) ? 0 : 1);
                        cntB -= ((k - i) % 2 == 0) ? ((trueAns[1][q - j] != map[k][q]) ? 0 : 1) : ((trueAns[0][q - j] != map[k][q]) ? 0 : 1);
                    }
                }

                min = Math.min(Math.min(cntW, cntB), min);
            }
        }

        System.out.println(min);
    }
}