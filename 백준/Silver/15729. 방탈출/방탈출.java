import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] button = new int[N];
		int[] result = new int[N];
		int ans = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			button[i] = Integer.parseInt(st.nextToken());

		}
		for (int i = 0; i < N; i++) {
			if (result[i] != button[i]) {
				for (int j = i; j < i + 3 && j < N; j++) {
					result[j] = result[j] > 0 ? 0 : 1;
				}
				ans++;
			}
//			System.out.println(Arrays.toString(result));

		}
		System.out.println(ans);
	}

}
