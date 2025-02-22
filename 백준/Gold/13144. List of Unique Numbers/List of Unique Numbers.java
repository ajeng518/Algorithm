import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int[] cnt = new int[100001];
        long ans = 0L;

        while (left < n) {
            while (right < n && cnt[num[right]] == 0) {
                cnt[num[right]]++;
                right++;
            }

            ans += right - left;
            cnt[num[left]]--;
            left++;
        }

        System.out.println(ans);
    }
}