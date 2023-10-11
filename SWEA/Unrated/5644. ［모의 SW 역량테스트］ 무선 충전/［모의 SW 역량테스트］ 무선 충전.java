import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int M, A, goA[], goB[], charge[][], startA[], startB[], max;
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			goA = new int[M + 1];
			goB = new int[M + 1];
			charge = new int[A][4];
			startA = new int[] { 0, 0 };
			startB = new int[] { 9, 9 };
			max = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				goA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				goB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				charge[i][1] = Integer.parseInt(st.nextToken()) - 1;
				charge[i][0] = Integer.parseInt(st.nextToken()) - 1;
				charge[i][2] = Integer.parseInt(st.nextToken());
				charge[i][3] = Integer.parseInt(st.nextToken());

			}

			sb.append("#").append(test).append(" ").append(gogo()).append("\n");

		}System.out.println(sb);
	}

	private static int gogo() {
		for (int i = 0; i <= M; i++) {
			startA[0] += dx[goA[i]];
			startA[1] += dy[goA[i]];
			startB[0] += dx[goB[i]];
			startB[1] += dy[goB[i]];

			max += checkCharge();

		}
		return max;
	}

	private static int checkCharge() {
		int m = 0;

		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = 0;
				int lenA = Math.abs(startA[0] - charge[i][0]) + Math.abs(startA[1] - charge[i][1]) <= charge[i][2]
						? charge[i][3]
						: 0;
				int lenB = Math.abs(startB[0] - charge[j][0]) + Math.abs(startB[1] - charge[j][1]) <= charge[j][2]
						? charge[j][3]
						: 0;

				if (i != j) {
					sum = lenA + lenB;
				} else {
					sum = Math.max(lenA, lenB);
				}
				if(m<sum)
					m=sum;
			}
		}
		return m;
	}

}
