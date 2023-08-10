import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static int[][] a, b;
	static boolean result = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String[][] in = new String[n][m];
		a = new int[n][m];
		b = new int[n][m];
		cnt = 0;

		for (int i = 0; i < n; i++) {
			in[i] = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(in[i][j]);
			}
		}

		for (int i = 0; i < n; i++) {
			in[i] = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				b[i][j] = Integer.parseInt(in[i][j]);
			}
		}

		int size=0;
		if(m==3) {
			size=m;
		}else	size=1;
		for (int i = 0; i <= n - 3; i++) {
			for (int j = 0; j <= m - 3; j++) {
				int notsame = 0;
				for (int k = i; k < i + 3; k++) {
					for (int p = j; p < j + 3; p++) {
						if (size<3 && a[i][j] != b[i][j]) {
							notsame++;
							break;
						}else if(size==3 && a[i][p]!=b[i][p]) {
							notsame++;
							break;
						}
					}
					if (notsame >0) {
						for (int p = j; p < j + 3; p++) {
							if (a[k][p] == 1)
								a[k][p] = 0;
							else
								a[k][p] = 1;
						}
						if (k == i + 2) {
							cnt++;
						}
					}
				}
				same(a, b);
				if (result == true) {
					break;
				}
			}
			if (result == true) {
				break;
			}
		}
		same(a, b);
		if (result == false) {
			System.out.println("-1");
		} else {
			System.out.println(cnt);
		}

	}

	public static void same(int[][] a, int[][] b) {
		int q = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == b[i][j]) {
					q++;
				}
			}
		}
		if (q == n * m) {
			result = true;
		}
	}
}
