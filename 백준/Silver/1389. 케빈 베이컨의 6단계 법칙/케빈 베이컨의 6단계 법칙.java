import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<List<Integer>> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(list.get(x).contains(y) ||list.get(y).contains(x))continue;
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		int[] result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (list.get(i) == null)
				continue;
			Deque<Integer> q = new ArrayDeque<Integer>();
			boolean[] chk = new boolean[N + 1];
			q.add(i);
			chk[i] = true;
			
			int cnt = 0;

			while (!q.isEmpty()) {
				int size = q.size();

				while (size-- > 0) {
					int now = q.poll();

					result[i] += cnt;

					for (int k = 0; k < list.get(now).size(); k++) {
						if (chk[list.get(now).get(k)])
							continue;
						q.add(list.get(now).get(k));
						chk[list.get(now).get(k)] = true;
					}
				}
				cnt++;
			}
		}
		
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 1; i <= N; i++) {
			if (result[i] == 0)
				continue;
			if (min > result[i]) {
				min = result[i];
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}
}