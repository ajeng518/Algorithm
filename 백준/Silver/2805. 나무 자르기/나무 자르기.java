import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[], N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N];
		max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, map[i]);
		}

		long result = biSearch();
		System.out.println(result);
	}

	private static long biSearch() {
		long low = 0;
		long high = max;
		long mid = (high + low) / 2;

		while (low <= high) {
			mid = (high + low) / 2;
			long now = 0;
			for (int i = 0; i < N; i++) {
				long diff = map[i] - mid;
				if (diff > 0)
					now += diff;
			}

			if (now < M)
				high = mid - 1;
			else if(now>=M)
				low = mid + 1;
		}
		return high;
	}

}
