import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static char[] operList = { '+', '-', '*', '/' };
	static int num[], n, max, min;
	static char ans[], cntOper[];
	static boolean chk[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		num = new int[n];
		cntOper = new char[n];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int now = Integer.parseInt(st.nextToken());
			for (int j = cnt; j < cnt + now; j++) {
				cntOper[j] = operList[i];
			}
			cnt += now;
		}

		chk = new boolean[n - 1];
		ans = new char[n - 1];
		re(0);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	private static void re(int idx) {
		if (idx == n - 1) {
			int nowans = makeCal();
			max = Math.max(max, nowans);
			min = Math.min(min, nowans);

			return;
		}

		char op = '0';
		for (int i = 0; i < n - 1; i++) {
			if (chk[i] || op == cntOper[i])
				continue;
			ans[idx] = cntOper[i];
			op = cntOper[i];
			chk[i] = true;
			re(idx + 1);
			chk[i] = false;
		}
	}

	private static int makeCal() {
		int sum = num[0];
		for (int i = 0; i < n - 1; i++) {
			if (ans[i] == '+') {
				sum += num[i + 1];
			} else if (ans[i] == '-') {
				sum -= num[i + 1];
			} else if (ans[i] == '*') {
				sum *= num[i + 1];
			} else if (ans[i] == '/') {
				sum /= num[i + 1];
			}
		}

		return sum;
	}
}
