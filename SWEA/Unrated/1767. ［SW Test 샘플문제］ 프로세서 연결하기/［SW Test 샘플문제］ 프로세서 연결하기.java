import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, X, Y, maxCnt, minLen;
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, 1, 0, -1, 0 };
	static List<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			list = new ArrayList<>();
			maxCnt = Integer.MIN_VALUE;
			minLen = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if ((map[i][j] = Integer.parseInt(st.nextToken())) == 1) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
							continue;
						list.add(new int[] { i, j });
					}
				}
			}

			subset(0, 0, 0, map);
			sb.append("#").append(test).append(" ").append(minLen).append('\n');
		}
		System.out.println(sb);
	}

	private static void subset(int cnt, int way, int idx, int[][] map) {
		if (cnt + list.size() - idx < maxCnt)
			return;

		if (idx == list.size()) {
			int nowLen = getLen(map);

			if (cnt > maxCnt) {
				minLen = nowLen;
				maxCnt = cnt;
			} else if (cnt == maxCnt) {
				minLen = Math.min(minLen, nowLen);
			}
			return;
		}

		int[][] newmap = new int[N][N];

		cnt += 1;

		if (canLine(idx, 1, map)) {
			copymap(map, newmap);
			makeLine(idx, 1, newmap);
			subset(cnt, 1, idx + 1, newmap);
		}
		if (canLine(idx, 2, map)) {
			copymap(map, newmap);
			makeLine(idx, 2, newmap);
			subset(cnt, 2, idx + 1, newmap);
		}
		if (canLine(idx, 3, map)) {
			copymap(map, newmap);
			makeLine(idx, 3, newmap);
			subset(cnt, 3, idx + 1, newmap);
		}
		if (canLine(idx, 4, map)) {
			copymap(map, newmap);
			makeLine(idx, 4, newmap);
			subset(cnt, 4, idx + 1, newmap);
		}
		subset(cnt - 1, 0, idx + 1, map);

	}

	private static void makeLine(int idx, int way, int[][] map) {
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];

		for (int i = 0; i < N; i++) {
			x += dx[way];
			if (x < 0 || x >= N)
				break;
			y += dy[way];
			if (y < 0 || y >= N)
				break;
			map[x][y] = 2;
		}

	}

	private static int getLen(int[][] map) {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2)
					cnt++;
			}
		}
		return cnt;
	}

	private static void copymap(int[][] map, int[][] newmap) {
		for (int i = 0; i < N; i++) {
			newmap[i] = map[i].clone();
		}
	}

	private static boolean canLine(int idx, int way, int[][] map) {
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];

		for (int i = 0; i < N; i++) {
			x += dx[way];
			if (x < 0 || x >= N)
				break;
			y += dy[way];
			if (y < 0 || y >= N)
				break;

			if (map[x][y] == 1 || map[x][y] == 2)
				return false;
		}
		return true;
	}
}
