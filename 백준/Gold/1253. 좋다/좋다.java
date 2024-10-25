import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = n - 1;

            int target = num[i];

            while (true) {
                if (s == i) s++;
                else if (e == i) e--;

                if (s>=e) break;

                int sum = num[s] + num[e];

                if (target == sum) {
                    cnt++;
                    break;

                } else if (sum < target) s++;
                else if (sum > target) e--; //
            }

        }

        System.out.println(cnt);

    }
}