import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] input,result;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 서로다른 L개의 알파벳 소문자들로 구성됨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 최소 한 개의 모음(a,e,i,o,u)과 최소 두 개의 자음으로 구성 되어 있다.
		input=br.readLine().replace(" ", "").toCharArray();

		// 오름차순으로 정렬된다.
		Arrays.sort(input);
		result = new char[L];

		re(0, 0);
		System.out.println(sb.toString());
	}

	private static void re(int now, int cnt) {
		if (cnt == L) {
			canans();
			return;
		}
		for (int i = now; i < C; i++) {
			result[cnt] = input[i];
			re(i + 1, cnt + 1);
		}
	}
    
	private static void canans() {
		int c = 0;
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < L; i++) {
			if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u')
				c++;
			temp.append(result[i]);
		}
		temp.append("\n");

		if (c > 0 && c <= L - 2) {
			sb.append(temp);
		}
	}

}
