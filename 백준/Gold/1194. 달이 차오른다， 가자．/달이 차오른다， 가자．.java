import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, start[];
	static char[][] map;
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N + 2][M + 2];
		start = new int[2];

		for (int i = 1; i <= N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				if ('0' == (map[i][j] = line[j - 1])) {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		System.out.println(bfs());

	}

	private static int bfs() {
		Deque<int[]> q = new ArrayDeque<int[]>();
		int flag = 0;
		q.offer(new int[] { start[0], start[1], flag });
		int cnt = 0;
		boolean chk[][][] = new boolean[N + 2][M + 2][65];// 열쇠가 총 6개유...
		chk[start[0]][start[1]][flag] = true;
		map[start[0]][start[1]] = '.';

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while (size-- > 0) {
				int[] now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nX = now[0] + dX[i];
					int nY = now[1] + dY[i];

					if (map[nX][nY] == 0)
						continue;
					if (chk[nX][nY][now[2]])
						continue;
					if (map[nX][nY] == '#')
						continue;
					else if (map[nX][nY] == '.') {
						chk[nX][nY][now[2]] = true;
						q.offer(new int[] { nX, nY, now[2] });
					} else if (map[nX][nY] >= 'a') {// 열쇠에 갔으요
						int newFlag = now[2];
						newFlag |= (1 << (map[nX][nY] - 'a'));// 열쇠를 챙겨요
						chk[nX][nY][newFlag] = true;// 여기를 지나갔슈
						q.offer(new int[] { nX, nY, newFlag });
					} else if (map[nX][nY] >= 'A') {// 문에 왔슈
						if ((now[2] & (1 << (map[nX][nY] - 'A'))) == 0)
							continue;// 열쇠가 잇수?
						chk[nX][nY][now[2]] = true;
						q.offer(new int[] { nX, nY, now[2] });
					} else if (map[nX][nY] == '1') {
						return cnt;
					}

				}
			}
		}
		return -1;
	}

}
