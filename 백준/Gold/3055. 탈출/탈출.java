import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int R, C, start[], end[];
	static Deque<int[]> wq = new ArrayDeque<int[]>();
	static char map[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		start = new int[2];
		end = new int[2];

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					wq.offer(new int[] { i, j });
				} else if (map[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
				} else if (map[i][j] == 'D') {
					end[0] = i;
					end[1] = j;
				}
			}
		}

		int flag = bfs();
		if (flag > 0) {
			System.out.println(flag);
		} else {
			System.out.println("KAKTUS");
		}
	}

	private static int bfs() {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { start[0], start[1] });

		int time = 0;

		while (!q.isEmpty()) {

			int w_size = wq.size();
			while (w_size-- > 0) {
				int[] flow = wq.poll();

				for (int i = 0; i < 4; i++) {// 4 방향 탐색
					int nextX = flow[0] + dx[i];
					int nextY = flow[1] + dy[i];

					if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)// 범위 벗어나면 continue
						continue;
					if (map[nextX][nextY] != '.')
						continue;
					wq.offer(new int[] { nextX, nextY });// 그 제외하고는 q에 넣어줌
					map[nextX][nextY] = '*';
				}
			}
			int size = q.size();
			while (size-- > 0) {
				int[] now = q.poll();

				if (now[0] == end[0] && now[1] == end[1]) {
					return time;
				}

				for (int i = 0; i < 4; i++) {// 4 방향 탐색
					int nextX = now[0] + dx[i];
					int nextY = now[1] + dy[i];

					if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)// 범위 벗어나면 continue
						continue;
					if (map[nextX][nextY] == 'X' || map[nextX][nextY] == '*' || map[nextX][nextY] == 'S')
						continue;
					q.offer(new int[] { nextX, nextY });// 그 제외하고는 q에 넣어줌
					map[nextX][nextY] = 'S';
				}
			}

			time++;
		}
		return -1;
	}
}
