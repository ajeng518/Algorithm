import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, input[], max, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		input = new int[N];
		m=Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			m=Math.max(m, input[i]);

		}
		max = Integer.parseInt(br.readLine());

		System.out.println(bi_search(0, m));

	}

	private static int bi_search(int low, int high) {
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (mid > input[i])
					sum += input[i];
				else
					sum += mid;
			}
			if (sum <= max)
				low = mid + 1;
			else if (sum > max)
				high = mid - 1;
		}mid = (low + high) / 2;
		return mid;
	}
}
