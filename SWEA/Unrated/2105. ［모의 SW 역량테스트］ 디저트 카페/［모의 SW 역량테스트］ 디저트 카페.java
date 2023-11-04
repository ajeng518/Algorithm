import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, map[][], max;
	//시계방향으로 생각하기러기러기러기
	static int[] dx = { 1, 1, -1, -1 };// 우하, 좌하, 좌상, 우상
	static int[] dy = { 1, -1, -1, 1 };
	static boolean type[], chk[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					chk = new boolean[N][N];
					type = new boolean[101];
					chk[i][j] = true;
					type[map[i][j]] = true;
					dfs(1, i, j, i, j, 0);
				}
			}
			if(max==0) {
				max=-1;
			}
			sb.append("#").append(test).append(" ").append(max).append('\n');

		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int x, int y, int initX, int initY, int preWay) {
		for (int i = preWay; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];

			if (nX < 0 || nX >= N)
				continue;
			if (nY < 0 || nY >= N)
				continue;
			
			if (nX == initX && nY == initY && cnt > 2) {
				max = Math.max(max, cnt);
				return;
			}
			
			if (!chk[nX][nY] && !type[map[nX][nY]]) {
				chk[nX][nY] = true;
				type[map[nX][nY]] = true;
				dfs(cnt + 1, nX, nY, initX, initY, i);
				chk[nX][nY] = false;
				type[map[nX][nY]] = false;
			}
		}
	}
}
