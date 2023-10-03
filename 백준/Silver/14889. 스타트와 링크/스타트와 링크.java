import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], result[], power[], min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		min = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		team(0, 0);
		System.out.println(min);

	}

	private static void team(int cnt, int now) {
		if (cnt == N / 2) {
			power = new int[2];
			int sum = sumPower();
			if (min > sum) {
				min = sum;
			}

			return;
		}

		for (int i = now; i < N; i++) {
			result[i] = 1;
			team(cnt + 1, i + 1);
			result[i] = 0;

		}
	}

	private static int sumPower() {

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (result[i] == 1 && result[j] == 1) {
					power[1] += map[i][j];
					power[1] += map[j][i];
				} else if (result[i] == 0 && result[j] == 0) {
					power[0] += map[i][j];
					power[0] += map[j][i];
				}
			}
		}

		return power[0] > power[1] ? power[0] - power[1] : power[1] - power[0];
	}
}
