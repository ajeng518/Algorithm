import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k, map[][], max=0;
	static int word[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int know = init();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (k - 5 < 0) {

		} else if (k == 26) {
			max = n;
		} else {
			word = new int[n];
			int all = 0;

			for (int i = 0; i < n; i++) {
				String temp = br.readLine();

				word[i] = know;
				for (int j = 4; j < temp.length() - 4; j++) {
					word[i] |= 1 << temp.charAt(j) - 96;
				}
				all |= word[i];

			}
			all ^= know;
			if (Integer.bitCount(all) < k - 5) {
				max = n;
			} else
				re(k - 5, 2, know, all);
		}
		System.out.println(max);

	}

	private static void re(int cnt, int idx, int know, int all) {
		if (cnt == 0) {
			int now = checkWord(know);
			max = Math.max(max, now);

			return;
		}

		for (int i = idx; i <= 26; i++) {
			if ((all & (1 << i)) > 0) {
				re(cnt - 1, i + 1, (know | (1 << i)), all);
			}
		}
	}

	private static int checkWord(int know) {
		int cnt = 0;

		for (int i = 0; i < n; i++) {

			if (word[i] == (know & word[i]))
				cnt++;
		}

		return cnt;
	}

	private static int init() {
		String str = "antatica";
		int know = 0;
		for (int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i));
			know = (know | (1 << (str.charAt(i) - 96)));
		}

		return know;
	}
}