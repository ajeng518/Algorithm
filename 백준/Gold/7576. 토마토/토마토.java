import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, tomato[][];
	static int[] dx = { -1, 0, 1, 0 };// 위-오-아래-왼
	static int[] dy = { 0, 1, 0, -1 };
	static List<int[]> welldone;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());// 상자 가로
		n = Integer.parseInt(st.nextToken());// 상자 세로

		tomato = new int[n][m];
		welldone = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				if ((tomato[i][j] = Integer.parseInt(st.nextToken())) > 0) {
					welldone.add(new int[] { i, j, 0 });
				}
			}
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		Deque<int[]> q = new ArrayDeque<int[]>(welldone);
		int day = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			day = cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				if (nx < 0 || nx >= n) {
					continue;
				}
				int ny = cur[1] + dy[i];
				if (ny < 0 || ny >= m) {
					continue;
				}

				if (tomato[nx][ny] == -1)
					continue;
				if (tomato[nx][ny] == 1)
					continue;
				tomato[nx][ny] = 1;
				q.add(new int[] { nx, ny, day + 1 });
			}
		}
		if (!chkTomato()) {
			return day = -1;
		} else
			return day;
	}

	private static boolean chkTomato() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tomato[i][j]==0)
					return false;
			}
		}return true;
	}
}