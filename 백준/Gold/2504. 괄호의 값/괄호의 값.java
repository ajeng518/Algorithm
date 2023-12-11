import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String N = br.readLine();
		Deque<Character> stack = new ArrayDeque<Character>();

		int value = 1;
		int result = 0;

		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) == '(') {
				stack.push(N.charAt(i));
				value *= 2;
			} else if (N.charAt(i) == '[') {
				stack.push(N.charAt(i));
				value *= 3;
			} else if (N.charAt(i) == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				} else if (N.charAt(i - 1) == '(') {
					result += value;
				}
				stack.pop();
				value /= 2;
			} else if (N.charAt(i) == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				} else if (N.charAt(i - 1) == '[') {
					result += value;
				}
				stack.pop();
				value /= 3;
			}
		}

		if (!stack.isEmpty())
			sb.append(0).append("\n");
		else
			sb.append(result).append("\n");
		System.out.println(sb);
	}
}