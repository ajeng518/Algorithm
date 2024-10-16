import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= s) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            } else if (end == n) break;
            else sum += arr[end++];
        }

        if(min==Integer.MAX_VALUE) min=0;
        System.out.println(min);
    }
}