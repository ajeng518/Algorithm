import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int[] alpha;

        for (int test = 1; test <= testCase; test++) {
            char[] input = br.readLine().toCharArray();
            int n = input.length;
            alpha = new int[26];

            int k = Integer.parseInt(br.readLine());
            if (k == 1) {
                sb.append("1 1").append("\n");
                continue;
            }

            for (int i = 0; i < n; i++) {
                char cIdx = input[i];
                alpha[cIdx - 'a']++;
            }

            int s = 0;
            int e = 0;
            int cnt = 0;
            char now = input[s];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while (true) {
                while (e < n && cnt <= k) {
                    if (input[e++] == now) cnt++;

                    if (cnt == k) {
                        min = Math.min(e - s, min);
                        max = Math.max(e - s, max);
                        break;
                    }
                }

                s++;
                if (s >= n) break;
                e = s;
                cnt = 0;
                now = input[s];
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) sb.append(-1).append(" ");
            else {
                sb.append(min).append(" ");
                sb.append(max).append("\n");
            }
        }

        System.out.println(sb);
    }
}