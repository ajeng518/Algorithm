import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] numCnt = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int cnt = 0;
        int max = Integer.MIN_VALUE;

        while (e < n) {
            while (e < n && numCnt[arr[e]] + 1 <= k) {
                numCnt[arr[e]]++;
                e++;
            }

            max = Math.max(max, e-s);
            numCnt[arr[s]]--;
            s++;
        }
        System.out.println(max);
    }
}