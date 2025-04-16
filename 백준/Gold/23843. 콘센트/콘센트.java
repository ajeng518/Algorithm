import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt (st.nextToken());

        Long[] time =new Long[n];

        st =new StringTokenizer(br.readLine());
        for(int i = 0; i < n;i++){
            time[i]=Long.parseLong(st.nextToken());
        }

        Arrays.sort(time, Collections.reverseOrder());

        if(n<=m){
            System.out.println(time[0]);
            System.exit(0);
        }

       PriorityQueue<Long> pq= new PriorityQueue<>(); 
        for(int i=0;i<m;i++){
            pq.add(time[i]);
        }

        for(int i=m; i<n; i++){
            long now =pq.poll();
            long next =now+time[i];
            pq.add(next);
        }

        long max=0;
        while(!pq.isEmpty()){
            if(pq.size()!=1) pq.poll();
            else max=pq.poll();
        }

        System.out.println(max);
    }
}