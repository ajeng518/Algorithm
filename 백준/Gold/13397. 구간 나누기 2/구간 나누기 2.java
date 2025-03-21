import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());

        System.out.println(binarySearch(n, m, num));
    }

    private static int binarySearch(int n, int m, int[] num) {
        int left = 0;
        int right = 10_000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (chkGroupCnt(mid, num) <= m) {
                right=mid-1;
            }else left=mid+1;
        }

        return left;
    }

    private static int chkGroupCnt(int mid, int[] num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int cnt = 1;
        for (int i = 0; i < num.length; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);

            if (max - min > mid) {
                cnt++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;
            }
        }

        return cnt;
    }

}
