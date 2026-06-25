import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());

        Map<Long, Integer> count = new HashMap<>();

        int ans =0;

        for(int i=0;i<n;i++){
            long diff = k-arr[i];

            if(count.containsKey(diff)){
                ans += count.get(diff);
            }

            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(ans);

    }
}