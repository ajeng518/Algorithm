import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int N, M, min;
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		int now=bfs();
		if (now == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(now);
		}

	}

	private static int bfs() {
		Deque<int[]> q = new ArrayDeque<int[]>();
		boolean[][][] chk = new boolean[N][M][2];

		q.offer(new int[] { 0, 0, 0 });
		chk[0][0][0] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			if (cnt > min)
				return -1;
			cnt++;

			while (--size >= 0) {
				int[] now = q.poll();

				if (now[0] == N - 1 && now[1] == M - 1) {
					return cnt;
				}

				for (int i = 0; i < 4; i++) {
					int nX = now[0] + dX[i];
					int nY = now[1] + dY[i];

					if (nX < 0 || nY < 0 || nX > N - 1 || nY > M - 1)
						continue;
					if (chk[nX][nY][now[2]])
						continue;
					if (map[nX][nY] == '1') {
						if (now[2] == 1)
							continue;
						q.offer(new int[] { nX, nY, 1 });
						chk[nX][nY][1] = true;
					}else {
						q.offer(new int[] { nX, nY, now[2] });
						chk[nX][nY][now[2]] = true;
					}
				}
			}
		}
		return -1;
	}
}
