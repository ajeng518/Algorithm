import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int N, M, map[][], max;
	static int[] dx = { -1, 0, 1, 0 };// 상-우-하-좌
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] block = { {}, { -1, -1, 1, 0 }, { 1, -1, -1, 2 }, { 3, 2, -1, -1 }, { -1, 0, 3, -1 },
			{ -1, -1, -1, -1 } };
	static List<int[]>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 세로
			map = new int[N][N];
			max=Integer.MIN_VALUE;
			
			list = new ArrayList[11];
			for (int i = 6; i < 11; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if ((map[i][j] = Integer.parseInt(st.nextToken())) > 5) {
						list[map[i][j]].add(new int[] { i, j });
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0)
						continue;
					for (int k = 0; k < 4; k++)
						max = Math.max(max, goGame(i, j, k));
				}
			}
			sb.append("#").append(test).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static int goGame(int x, int y, int way) {
		int nx = x;
		int ny = y;
		int cnt = 0;

		while (true) {
			nx += dx[way];
			ny += dy[way];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				cnt = cnt * 2 + 1;
				break;
			}
			if (map[nx][ny] == -1)
				break;
			if (nx == x && ny == y)
				break;
			if (map[nx][ny] > 5) {
				int idx = map[nx][ny];
				if (list[idx].get(0)[0] == nx && list[idx].get(0)[1] == ny) {
					nx = list[idx].get(1)[0];
					ny = list[idx].get(1)[1];
				} else {
					nx = list[idx].get(0)[0];
					ny = list[idx].get(0)[1];
				}
			} else if (map[nx][ny] > 0) {
				int idx = map[nx][ny];
				way = block[idx][way];
				if (way == -1) {
					cnt = cnt * 2 + 1;
					break;
				}
				cnt++;
			}
		}
		return cnt;
	}
}