import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> multi = new ArrayList<Integer>();
		int[] arr = new int[k];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (n >= k) {
			System.out.println(0);
		} else {
			int use = 0;
			int del = 0;

			for (int i = 0; i < k; i++) {
				if (multi.contains(arr[i]))
					continue;
				else if (use < n) {
					multi.add(arr[i]);
					use++;
				} else if (use == n) {
					Deque<int[]> stack = new ArrayDeque<>();
					boolean[] chk = new boolean[k + 1];
					boolean[] multiChk = new boolean[n];

					for (int j = i + 1; j < k; j++) {
						if (multi.contains(arr[j]) && !chk[arr[j]]) {
							chk[arr[j]] = true;
							int multiIdx = multi.indexOf(arr[j]);
							stack.push(new int[] { arr[j], multiIdx });
							multiChk[multiIdx] = true;
						}
						if (stack.size() == n) {
							break;
						}
					}
					if (stack.size() == n) {
						int[] cur = stack.pop();
						multi.remove(cur[1]);
						multi.add(arr[i]);
						del++;
					} else {
						for (int j = 0; j < n; j++) {
							if (multiChk[j])
								continue;
							multi.remove(j);
							multi.add(arr[i]);
							del++;
							break;
						}
					}
				}
			}
			System.out.println(del);
		}

	}
}