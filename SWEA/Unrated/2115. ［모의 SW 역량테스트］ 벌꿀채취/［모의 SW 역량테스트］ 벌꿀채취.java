import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2023.10.07.15:27
public class Solution {
	static int N, M, C, max;
	static int[] map[], profit[];
	static boolean chk[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 벌통 크기
			M = Integer.parseInt(st.nextToken());// 채취할 수 잇는 통 크기
			C = Integer.parseInt(st.nextToken());// 채취가능한 꿀 양

			map = new int[N][N];
			profit = new int[N][N];// 이익 가능한 꿀 이익 저장할꺼임..
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 미리 가능한 최대 이익 배열 생성(부분 집합)
			// 채취하기(A다음 B)
			process();
			sb.append("#").append(test).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}

	private static void process() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				subset(i, j, 0, 0, 0);
			}
		}
		combiBee();
	}

	private static void subset(int x, int y, int cnt, int sum, int total) {

		if (sum > C)
			return;

		if (cnt == M) {
			profit[x][y - M] = Math.max(profit[x][y - M], total);
			return;
		}

		subset(x, y + 1, cnt + 1, sum + map[x][y], total + (map[x][y] * map[x][y]));
		subset(x, y + 1, cnt + 1, sum, total);
	}

	private static void combiBee() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				combi(i, j + M, 0, profit[i][j]);
			}
		}
	}

	private static void combi(int x, int y, int cnt, int total) {
		if (cnt == 1) {
			max = Math.max(max, total);
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = y; j <= N - M; j++) {
				combi(i, j, cnt + 1, total + profit[i][j]);
			}
			y = 0;
		}
	}
}