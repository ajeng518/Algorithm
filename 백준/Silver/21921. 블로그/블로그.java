import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] cnt = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        int all = 0;
        int s = 0;
        int e = 0;
        int maxCnt = 0;
        int maxhow = 0;

        while (e < n) {
            while (e < n && e - s + 1 <= x) {
                all += cnt[e];
                e++;
            }
            if (e - s  == x) {
                if (maxCnt < all) {
                    maxCnt = all;
                    maxhow = 1;
                } else if (maxCnt == all) maxhow++;
                all -= cnt[s];
                s++;
            }
        }

        if(maxCnt!=0) {
            System.out.println(maxCnt);
            System.out.println(maxhow);
        }else System.out.println("SAD");
    }
}