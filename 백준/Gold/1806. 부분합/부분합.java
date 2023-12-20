import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int answer = 1_000_001;

        for (int i = 0; i < n; i++) {
            if ((num[i] = Integer.parseInt(st.nextToken())) >= s) {
                answer = 1;
            }
            sum += num[i];
        }

        if (answer == 1_000_001) {
            if (sum < s) {
                answer = 0;
            } else {
                int sub = 0, start = 0, end = 0;

                while (true) {
                    if (sub < s) {//구간합이 s보다 작을 경우 end 값을 증가시킨다
                        if(end==n){
                            break;
                        }
                        sub += num[end++];

                    } else{//구간합이 s보다 크거나 같다면 start값을 그 다음 값으로 증가시킨다.
                        if(answer>end-start){
                            answer=end-start;
                        }
                        sub -= num[start++];
                    }
                }
            }
        }
        System.out.println(answer);//정답 출력해주새우
    }
}
