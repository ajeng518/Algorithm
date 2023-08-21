import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<int[]> stk1 = new Stack<>();
		Stack<int[]> stk2 = new Stack<>();
		Stack<int[]> stk3 = new Stack<>();
		Stack<int[]> stk4 = new Stack<>();
		Stack<int[]> stk5 = new Stack<>();
		Stack<int[]> stk6 = new Stack<>();

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());


		int[][] play = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			play[i][0] = Integer.parseInt(st.nextToken());
			play[i][1] = Integer.parseInt(st.nextToken());
		}

		int move = 0;

		for (int i = 0; i < N; i++) {
			int nowx = play[i][0];
			int nowy = play[i][1];


			if (nowx == 1) {
				move += gitt(nowx, nowy, stk1);
			} else if (nowx == 2) {
				move += gitt(nowx, nowy, stk2);
			} else if (nowx == 3) {
				move += gitt(nowx, nowy, stk3);
			} else if (nowx == 4) {
				move += gitt(nowx, nowy, stk4);
			} else if (nowx == 5) {
				move += gitt(nowx, nowy, stk5);
			} else if (nowx == 6) {
				move += gitt(nowx, nowy, stk6);
			}
		}

		System.out.println(move);

	}

	private static int gitt(int nowx, int nowy, Stack<int[]> stk) {
		int cnt = 0;
		
	while (!stk.isEmpty()) {
				
		int[] tmp = stk.peek();
		
		if (tmp[1] < nowy) {
			stk.push(new int[] { nowx, nowy });
			cnt++;
			break;
		} else if (tmp[1] > nowy) {
			stk.pop();
			cnt++;
		} else if (tmp[1] == nowy)
			break;
	}if (stk.isEmpty()) {
		stk.push(new int[] { nowx, nowy });
		cnt++;
		
	}
		
		return cnt;
	}

}
