import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int D, W, K, band[][], A[], B[], min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			band = new int[D][W];
			min = 0;
			A = new int[W];
			B = new int[W];
			Arrays.fill(B, 1);

			for (int i = 0; i < D; i++) {// 0==A/1==B
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					band[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#" + test + " ");
			if (!search()) {// 모든 열이 pass가 아닌 경우
				for (int i = 1; i <= K; i++) {
					chemi(0, 0, i);
					if(min>0)	break;
				}
				sb.append(min);
			} else {// 모든 열이 pass인 경우
				sb.append("0");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean search() {
		int all = 0;
		
		for (int i = 0; i < W; i++) {
			int now = band[0][i];
			int cnt = 1;
			boolean nextGo=false;
			for (int j = 1; j < D; j++) {
				if (now != band[j][i]) {
					if (cnt < K) {
						now = band[j][i];
						cnt = 1;
						continue;
					} else {
						all++;
						nextGo=true;
						break;
					}
				}
				cnt++;
			}if(!nextGo) {
				if (cnt>=K) {
					all++;
				}
			}
		}
		return all == W;
	}

	private static void chemi(int cnt, int idx, int k) {
		if (cnt == k) {
			if (search())
				min = k;
			return;
		}
		if (idx == D)
			return;

		int[] temp = new int[W];
		System.arraycopy(band[idx], 0, temp, 0, W);
		System.arraycopy(A, 0, band[idx], 0, W);
		chemi(cnt + 1, idx + 1, k);
		System.arraycopy(B, 0, band[idx], 0, W);
		chemi(cnt + 1, idx + 1, k);
		System.arraycopy(temp, 0, band[idx], 0, W);
		chemi(cnt, idx + 1, k);
	}

}
