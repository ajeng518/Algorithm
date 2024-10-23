import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = n - 1;
        int min = 2_000_000_001;
        int[] idx = new int[2];
        int sum = 0;

        while (s < e) {
            sum = list[s] + list[e];
            if(Math.abs(sum)<min){
                idx[0]=s;
                idx[1]=e;
                min=Math.abs(sum);
            }

            if(sum>0){
                e--;
            }else if(sum<0){
                s++;
            }else break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list[idx[0]]).append(" ").append(list[idx[1]]);

        System.out.println(sb);

    }
}