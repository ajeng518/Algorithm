import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;

public class Main {
	static String[] num = new String[10];
	static char[][] number = new char[10][15];
	static char[][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		arr = new char[5][N / 5];
		initial();

		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = input[idx++];
			}
		}

		for (int i = 0; i < N / 5;) {
			if (arr[0][i] == '#') {
				int flag = isItNumber(i);
				if (flag > -1) {// 유효한 숫자라면
					sb.append(flag);
					if (flag == 1) {
						i += 2;
					} else {
						i += 3;
					}
				} else {
					i++;
				}
			} else {
				i++;
			}
		}
		System.out.println(sb.toString());
	}

	private static void initial() {
		num[0] = "####.##.##.####";
		num[2] = "###..#####..###";
		num[3] = "###..####..####";
		num[4] = "#.##.####..#..#";
		num[5] = "####..###..####";
		num[6] = "####..####.####";
		num[7] = "###..#..#..#..#";
		num[8] = "####.#####.####";
		num[9] = "####.####..####";

		for (int i = 0; i < 10; i++) {
			if (i == 1)
				continue;
			number[i] = num[i].toCharArray();
		}
	}

	private static int isItNumber(int start) {
		int Flag = isOne(start);// 먼저 1 혹은 4 인지 판단
		if (Flag > -1) {
			return Flag;
		}
		int idx = 0;
		boolean nextGo = false;

		for (int i = 0; i < 10; i++) {
			if (i == 1)
				continue;
			idx = 0;
			nextGo = false;
			for (int j = 0; j < 5; j++) {
				for (int k = start; k < start + 3; k++) {
					if (arr[j][k] != number[i][idx]) {
						nextGo = true;// 해당 숫자가 아니므로 다음 숫자 탐색을 하라는 flag
						break;
					}
					idx++;
				}
				if (nextGo == true) {// 숫자가 다른게 있다
					break;
				}
			}
			if (nextGo == false) {
				return i;
			}
		}
		return -1;
	}

	private static int isOne(int start) {
		int cnt = 1;
		for (int i = start + 1; i < start + 3 && i < N / 5; i++) {
			if (arr[0][i] == '#') {
				cnt++;
			}
		}
		if (cnt == 2 || cnt == 1) {
			int zero = 0;
			for (int i = 0; i < 5; i++) {
				if (arr[i][start] == '#')
					zero++;
			}
			if (zero == 5) {
				return 1;
			}
		}
		return -1;

	}

}
