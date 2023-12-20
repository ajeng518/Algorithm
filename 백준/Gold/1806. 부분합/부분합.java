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

        int[] num = new int[n+1];
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
                while (start <= n &&end<=n) {
                    if(sub>=s && answer>end-start)
                        answer=end-start;
                    else if (sub < s) {
                        sub += num[end++];

                    } else{
                        sub -= num[start++];
                    }


                }
            }
        }
        System.out.println(answer);
    }
}
