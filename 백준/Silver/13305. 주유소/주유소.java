import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] value = new long[n + 1];
        long[] road = new long[n];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0L;
        long min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            value[i] = Long.parseLong(st.nextToken());

        }

       for(int i=1;i<n;i++){
           if (min > value[i]) min = value[i];
           answer += min * road[i];
       }

        System.out.println(answer);
    }
}