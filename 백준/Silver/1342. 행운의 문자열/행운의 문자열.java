import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] in;
	static int[] result, chk,alpha;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		in = br.readLine().toCharArray();
		result = new int[in.length];
		chk = new int[in.length];
		alpha=new int[26];
		for(char c:in) {
			alpha[c-'a']++;
		}
		ans = 0;

		permu(0);
		System.out.println(ans);
	}

	private static void permu(int cnt) {

		if (cnt == in.length) {
			
			ans++;
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (alpha[i]<1||(cnt>0 && i == result[cnt - 1]))
				continue;
			alpha[i]--;
			result[cnt] = i;
			permu(cnt + 1);
			alpha[i]++;
		}
	}

}
