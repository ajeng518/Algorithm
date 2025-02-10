import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] value = new int[n + 1];
        int[] road = new int[n];
        long answer = 0L;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        value[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            if (value[i - 1] < value[i]) value[i] = value[i - 1];
        }

        for (int i = 1; i < n; i++) {
            answer+=road[i]*value[i];
        }
        System.out.println(answer);
    }
}