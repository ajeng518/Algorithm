import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int map[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		dfs(0, 0);
	}

	private static void dfs(int x, int y) {
		if (y == 9) {
			dfs(x + 1, 0);
			return;
		}

		if (x == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}

		if (map[x][y] == 0) {
			for (int i = 1; i < 10; i++) {

				if (checkMathch(x, y, i)) {
					map[x][y] = i;
					dfs(x, y + 1);
				}
			}

			map[x][y] = 0;
			return;

		}
		dfs(x, y + 1);

	}

	private static boolean checkMathch(int x, int y, int n) {
		int nowX = x - (x % 3);
		int nowY = y - (y % 3);

		for (int i = 0; i < 9; i++) {
			if (map[i][y] == n)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == n)
				return false;
		}

		for (int i = nowX; i < nowX + 3; i++) {
			for (int j = nowY; j < nowY + 3; j++) {
				if (map[i][j] == n)
					return false;
			}
		}
		return true;

	}

}
