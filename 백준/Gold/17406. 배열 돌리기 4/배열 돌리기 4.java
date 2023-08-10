import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] map, turn;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		turn = new int[k][3];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken()) - 1;
			turn[i][1] = Integer.parseInt(st.nextToken()) - 1;
			turn[i][2] = Integer.parseInt(st.nextToken());
		}
		int[] use = new int[k];
		boolean[] chk = new boolean[k];
		permu(0, use, chk);
		
		System.out.println(min);

	}

	public static void permu(int cnt, int[] arr, boolean[] chk) {
		if (cnt == k) {
			doturn(arr);
			return;
		}
		for (int i = 0; i < k; i++) {
			if (chk[i])	continue;
			chk[i] = true;
			arr[cnt]=i;
			permu(cnt + 1, arr, chk);
			chk[i] = false;
		}
	}

	public static int[][] copymap() {
		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	public static void doturn(int[] arr) {
		int[][] temp = copymap();

		for (int i = 0; i < k; i++) {
			int r = turn[arr[i]][0];
			int c = turn[arr[i]][1];
			int s = turn[arr[i]][2];

			for (int j = 1; j <= s; j++) {
				
				int up = temp[r - j][c + j];
				for (int q = c + j; q > c - j; q--) {
					temp[r - j][q] = temp[r - j][q - 1];
				}
				
				int right = temp[r + j][c + j];
				for (int q = r + j; q > r - j; q--) {
					temp[q][c + j] = temp[q - 1][c + j];
				}
				
				temp[r - j + 1][c + j] = up;
				
				int left = temp[r + j][c - j];
				for (int q = c - j; q < c + j; q++) {
					temp[r + j][q] = temp[r + j][q + 1];
				}
				
				temp[r + j][c + j - 1] = right;
				
				for (int q = r - j; q < r + j; q++) {
					temp[q][c - j] = temp[q + 1][c - j];
				}
				temp[r + j - 1][c - j] = left;
			}
		}
		sum(temp);
	}
	
	public static void sum(int[][]temp) {
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=0;j<m;j++) {
				sum+=temp[i][j];
			}
			min=Math.min(min, sum);
		}
	}
}
