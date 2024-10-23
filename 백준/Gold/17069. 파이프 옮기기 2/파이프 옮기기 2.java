import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long  now[], min, dx[], dy[], dp[][][], shape[][], map[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new long[N + 1][N + 1];
		dp = new long[N + 1][N + 1][3];// 가로,세로,대각선 확인
		now = new long[4];

		min = Integer.MAX_VALUE;

		shape = new long[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } };// 가로, 대각선, 세로
		dx = new long[] { 0, 1, 1 };
		dy = new long[] { 1, 1, 0 };

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		goDP();
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);

	}

	private static void goDP() {
		for (int i = 2; i <= N; i++) {
			if (map[1][i] == 1)
				break;
			dp[1][i][0] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {

				if (map[i][j] == 1)
					continue;
				else {
					checking(i, j);
				}
			}
		}
	}

	private static void checking(int x, int y) {
		dp[x][y][0] = dp[x][y - 1][0] + dp[x][y - 1][1];// 가로 카운트=이전의 가로+대각선
		dp[x][y][2] = dp[x - 1][y][1] + dp[x - 1][y][2];// 세로 카운트=이전의 세로+대각선

		if (map[x - 1][y] == 0 && map[x][y - 1] == 0) {
			dp[x][y][1] = dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2];
		}
	}

}