import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int[] length = new int[n];
        Arrays.fill(length, 1);
        int max=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i])
                    length[i] = Math.max(length[i], length[j] + 1);
            }
            if(max<length[i])max=length[i];
        }

        System.out.println(max);

    }
}