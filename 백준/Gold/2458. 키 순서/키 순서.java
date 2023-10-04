import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> big, small;
	static boolean[] chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;

		big = new ArrayList<>();// 나보다 큰거 넣는 리스트
		small = new ArrayList<>();// 나보다 작은거 넣는 리스트

		for (int i = 0; i <= N; i++) {
			big.add(new ArrayList<Integer>());
			small.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			small.get(y).add(x);
			big.get(x).add(y);
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			Deque<Integer> qbig = new ArrayDeque<Integer>();
			Deque<Integer> qsmall = new ArrayDeque<Integer>();
			chk = new boolean[N + 1];

			for (int j = 0; j < big.get(i).size(); j++) {
				qbig.offer(big.get(i).get(j));
				chk[big.get(i).get(j)] = true;
			}
			for (int j = 0; j < small.get(i).size(); j++) {
				qsmall.offer(small.get(i).get(j));
				chk[small.get(i).get(j)] = true;
			}

			while (!qbig.isEmpty()) {
				int now = qbig.poll();
				cnt++;

				for (int j = 0; j < big.get(now).size(); j++) {
					if (chk[big.get(now).get(j)])
						continue;
					qbig.offer(big.get(now).get(j));
					chk[big.get(now).get(j)] = true;
				}
			}

			while (!qsmall.isEmpty()) {
				int now = qsmall.poll();
				cnt++;

				for (int j = 0; j < small.get(now).size(); j++) {
					if (chk[small.get(now).get(j)])
						continue;
					qsmall.offer(small.get(now).get(j));
					chk[small.get(now).get(j)] = true;
				}
			}

			if (cnt == N - 1) {
				result++;
			}

		}
		sb.append(result);
		System.out.println(sb.toString());
	}

}
