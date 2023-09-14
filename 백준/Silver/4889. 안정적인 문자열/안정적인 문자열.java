import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		// 안정적인 문자열 만들기=>최소 연산
		String input = null;

		int idx = 0;
		while (true) {
			stack = new Stack<>();
			idx++;
			int cnt = 0;
			int len = 0;
			input = br.readLine();
			if (input.charAt(0) == '-') {
				break;
			}

			char[] stable = input.toCharArray();
			len = stable.length;
			for (int i = 0; i < len; i++) {
				if (stable[i] == '{') {// {일 경우
					stack.push('{');
				} else {// }일 겨우
					if (!stack.isEmpty()) {
						stack.pop();
					} else {// stack이 비어있다
						stack.push('{');
						cnt++;
					}
				}
			}
			if (!stack.isEmpty()) {
				cnt += stack.size() / 2;
			}
			sb.append(idx + ". " + cnt).append("\n");
		}
		System.out.println(sb.toString());

	}

}