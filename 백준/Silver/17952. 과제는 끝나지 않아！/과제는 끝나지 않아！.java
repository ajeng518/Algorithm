import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int score = 0;
		Stack<int[]> stack = new Stack<>();// 스택 선언
		StringTokenizer st;

		int[][] work = new int[N][3];// 업무 입력 받을 배열

		// input 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken());

			if (work[i][0] == 0)
				continue;
			work[i][1] = Integer.parseInt(st.nextToken());
			work[i][2] = Integer.parseInt(st.nextToken());
		}

		// N분 동안 반복문 실행
		for (int i = 0; i < N; i++) {// N의 분 동안
			if (work[i][0] != 0 && work[i][2] > 0) {// 해당 분에 업무가 있을 때(최신의 일을 우선으로 한다)
				work[i][2]--;//업무 할때 마다 업무 시간을 1 감소시켜준다
				if (work[i][2] == 0) {//업무를 다 했을 경우 
					score += work[i][1];//점수에 추가해준다
					continue;
				}
				stack.push(work[i]);// 아직 업무가 남았다면 stack에 넣어준다
			} else {// 해당 분에 업무가 있을 때
				if (!stack.isEmpty()) {// 아직 하던 업무가 남아있일경우
					int[] temp = stack.pop();
					temp[2]--;//업무 할때 마다 업무 시간을 1 감소시켜준다
					if (temp[2] == 0) {
						score += temp[1];
						continue;
					}
					stack.push(temp);//남았을 경우 다시 stack에 넣어준다
				}
			}
		}
		System.out.println(score);//최종 점수를 출력한다

	}

}
