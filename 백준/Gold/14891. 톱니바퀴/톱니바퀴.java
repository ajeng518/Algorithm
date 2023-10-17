import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static List<Character>[] list;
	static Deque<int[]> q;
	static int[][] result;
	static int[] score = { 0, 1, 2, 4, 8 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList[5];

		// N:0, S:1
		for (int i = 1; i < 5; i++) {
			list[i] = new ArrayList<>();
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++)
				list[i].add(line[j]);
		}

		int k = Integer.parseInt(br.readLine());
		int[][] turn = new int[k][2];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][1] = Integer.parseInt(st.nextToken());
		}

		gearCheck(turn, k);
		System.out.println(sumScore());
	}

	private static int sumScore() {
		int sum = 0;

		for (int i = 1; i < 5; i++) {
			if (list[i].get(0) == '1')
				sum += score[i];
		}
		return sum;
	}

	// 2번-6번
	// 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
	private static void gearCheck(int[][] turn, int k) {
		for (int i = 0; i < k; i++) {
			int gearIdx = turn[i][0];
			int way = turn[i][1];

			result = new int[4][2];
			gearBfs(gearIdx, way, 0);

			for (int j = 0; j < 4; j++) {
				if (result[j][0] < 1)
					continue;

				gearTurn(result[j][0], result[j][1]);
			}
		}

	}

	private static void gearBfs(int idx, int way, int cnt) {
		q = new ArrayDeque<int[]>();
		q.add(new int[] { idx, way });
		boolean[] chk = new boolean[5];
		int count = 0;
		chk[idx] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] now = q.poll();

				result[count][0] = now[0];
				result[count++][1] = now[1];
				int go = -2;

				if (now[0] == 1 && !chk[now[0] + 1]) {
					if (list[now[0]].get(2) != list[now[0] + 1].get(6)) {
						q.add(new int[] { now[0] + 1, go = now[1] == -1 ? 1 : -1 });
						chk[now[0] + 1] = true;
					}
				} else if (now[0] == 4 && !chk[now[0] - 1]) {
					if (list[now[0]].get(6) != list[now[0] - 1].get(2)) {
						q.add(new int[] { now[0] - 1, go = now[1] == -1 ? 1 : -1 });
						chk[now[0] - 1] = true;
					}
				} else if (now[0] > 1 && now[0] < 4) {
					if (!chk[now[0] + 1] && list[now[0]].get(2) != list[now[0] + 1].get(6)) {
						q.add(new int[] { now[0] + 1, go = now[1] == -1 ? 1 : -1 });
						chk[now[0] + 1] = true;
					}
					if (!chk[now[0] - 1] && list[now[0]].get(6) != list[now[0] - 1].get(2)) {
						q.add(new int[] { now[0] - 1, go = now[1] == -1 ? 1 : -1 });
						chk[now[0] - 1] = true;
					}
				}
			}
		}
	}

	private static void gearTurn(int idx, int way) {
		if (way == 1) {// 시계방향
			char now = list[idx].get(list[idx].size() - 1);

			for (int i = list[idx].size() - 1; i > 0; i--) {
				list[idx].set(i, list[idx].get(i - 1));
			}
			list[idx].set(0, now);
		} else {// 반시계방향
			char now = list[idx].get(0);
			list[idx].remove(0);
			list[idx].add(now);
		}
	}

}
