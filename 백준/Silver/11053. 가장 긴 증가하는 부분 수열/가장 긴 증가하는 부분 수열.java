import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) input[i] = Integer.parseInt(st.nextToken());

        int[] maxLen = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            maxLen[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[j] >= input[i]) continue;

                maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
            }
            max = max < maxLen[i] ? maxLen[i] : max;
        }

        System.out.println(max);
    }
}