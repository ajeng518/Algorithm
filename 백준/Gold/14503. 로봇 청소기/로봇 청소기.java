import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, map[][], start[];
	static int[] dx = { -1, 0, 1, 0 };// 북-동-남-서
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		start = new int[3];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 3; i++) {
			start[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(doRobot());
	}

	private static int doRobot() {
		int curway = start[2];
		int curx = start[0];
		int cury = start[1];
		int cnt=1;
		map[curx][cury]=2;
		
		while (true) {
			int side = 4;
			int cant = 0;
			int way = curway;
			
			while (side-- > 0) {
				way = way > 0 ? way - 1 : 3;
				int nx = curx + dx[way];
				int ny = cury + dy[way];

				if (nx < 0 || nx >= n)
					continue;
				if (ny < 0 || ny >= m)
					continue;
				if (map[nx][ny] != 0) {
					cant++;
					continue;
				}
				
				curx = nx;
				cury = ny;
				map[curx][cury] = 2;
				curway = way;
				cnt++;
				
				break;
			}
			if (cant == 4) {
				int nx = curx - dx[curway];
				int ny = cury - dy[curway];
				
				if(map[nx][ny]==1) {
					break;
				}
				curx=nx;
				cury=ny;
			}
		}
		return cnt;
	}
}