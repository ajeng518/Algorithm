import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0 빈칸, 1은 집, 2는 치킨 집
public class Main {
	static int N, M, map[][], chik, home[][], chk[][], chick[][], house, chikLen, min;
	static int result[][];
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chik = 0;
		house = 0;
		chikLen = 0;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					house++;
				else if (map[i][j] == 2)
					chik++;
			}
		}
		home = new int[house][2];
		chick = new int[chik][2];
		process();
		System.out.println(min);
	}

	private static void process() {
		checkHouseChick();

		deleteChicken();
	}

	private static void checkHouseChick() {
		int idx_h = 0;
		int idx_c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					home[idx_h][0] = i;
					home[idx_h++][1] = j;
				} else if (map[i][j] == 2) {
					chick[idx_c][0] = i;
					chick[idx_c++][1] = j;
				}
			}
		}
	}

	private static void deleteChicken() {
		for (int i = M; i > 0; i--) {
			result = new int[i][2];
			subset(i, 0, 0);
		}
	}

	private static void subset(int n, int idx, int cnt) {
		if (cnt == n) {
			min = Math.min(min, far(home, result));
			return;
		}
		if (idx >= chick.length)
			return;

		result[cnt][0] = chick[idx][0];
		result[cnt][1] = chick[idx][1];
		subset(n, idx + 1, cnt + 1);
		subset(n, idx + 1, cnt);
	}

	private static int far(int[][] h, int[][] c) {
		chikLen = 0;
		for (int i = 0; i < h.length; i++) {
			int near = Integer.MAX_VALUE;
			for (int j = 0; j < c.length; j++) {
				int road = Math.abs(h[i][0] - c[j][0]) + Math.abs(h[i][1] - c[j][1]);
				near = Math.min(near, road);
			}
			chikLen += near;
		}
		return chikLen;
	}
}
