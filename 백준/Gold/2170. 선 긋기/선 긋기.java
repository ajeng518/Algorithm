import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Line implements Comparable<Line> {
		int a;
		int b;

		public Line() {
			super();
		}

		public Line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Line o) {
			if (a == o.a)
				return b - o.b;
			return a - o.a;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Line> list = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Line(a, b));
		}

		Collections.sort(list);

		int a = 0;
		int b = 0;
		int idx = 0;
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			Line now = list.get(i);
			if (i == 0) {
				a = now.a;
				b = now.b;
				idx = i;
			} else {
				if (b >= list.get(i).a) {
					b = Math.max(b, now.b);
				} else {
					result+=b-a;
					a = now.a;
					b = now.b;
					idx = i;
				}
			}
		}result+=b-a;


		System.out.println(result);
	}

}
