import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long ans = binarySearch(n, m, tree);
        System.out.println(ans);
    }

    public static long binarySearch(int n, int m, int[] tree) {
        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = chkTreeLong(mid, tree);

            if (sum < m) end = mid - 1;
            else {
                start = mid + 1;
            }
        }

        return end;
    }

    public static long chkTreeLong(long mid, int[] tree) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long diff = tree[i] - mid;
            if (diff <= 0) continue;

            sum += diff;
        }

        return sum;
    }
}