import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static boolean map[][], chk[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		map = new boolean[N][M];
		chk = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = true;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!chk[i][j] && map[i][j])
					max = Math.max(max, bfs(i, j));
			}
		}
		System.out.println(max);
	}

	private static int bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		chk[x][y] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] now = q.poll();
				cnt++;

				for (int i = 0; i < 4; i++) {
					int nextX = now[0] + dx[i];
                    if (nextX < 0 || nextX >= N ) continue;
                    
					int nextY = now[1] + dy[i];
					if(nextY < 0 || nextY >= M)	continue;
                    
					if (chk[nextX][nextY] || !map[nextX][nextY])
						continue;
                    
					q.offer(new int[] { nextX, nextY });
					chk[nextX][nextY] = true;
				}
			}
		}
		return cnt;
	}
}