import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution
{
	static Deque<Integer> q = new ArrayDeque<Integer>();
	static boolean chk[];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			chk = new boolean[N];

			int cnt = 0;
			int[][] map = new int[N][N];
			int[] hand = new int[2];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				hand[0] = Integer.parseInt(st.nextToken());
				hand[1] = Integer.parseInt(st.nextToken());

				map[hand[0] - 1][hand[1] - 1] = 1;
				map[hand[1] - 1][hand[0] - 1] = 1;
			}

			for (int i = 0; i < N; i++) {
				if (chk[i] == false) {
					bfs(map, i);
					cnt++;
				}
			}
			sb.append("#" + test_case + " " + cnt);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int[][] map, int i) {
		chk[i] = true;
		q.offer(i);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int x = 0; x < map.length; x++) {
				if (map[now][x] == 1 && chk[x] == false) {
					q.offer(x);
					chk[x] = true;
				}
			}
		}
	}
}