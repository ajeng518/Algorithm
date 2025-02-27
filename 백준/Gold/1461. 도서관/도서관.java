import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int maxV=Integer.MIN_VALUE;

        PriorityQueue<Integer> pq1=new PriorityQueue<>((a1, a2)-> a2-a1);
        PriorityQueue<Integer> pq2=new PriorityQueue<>((a1, a2)-> a2-a1);

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int cur=Integer.parseInt(st.nextToken());

            if(cur<0){//음수값
                pq1.add(Math.abs(cur));
                maxV=Math.max(Math.abs(cur), maxV);
            }else{//양수수
                pq2.add(cur);
                maxV=Math.max(cur, maxV);
            }
        }

        int sum=0;

        while(!pq1.isEmpty()){
            int cur=pq1.poll();

            for(int i=0;i<m-1;i++){
                pq1.poll();
                if(pq1.isEmpty()) break;
            }

            sum+=cur*2;
        }

        while(!pq2.isEmpty()){
            int cur=pq2.poll();

            for(int i=0;i<m-1;i++){
                pq2.poll();
                if(pq2.isEmpty()) break;
            }

            sum+=cur*2;
        }
        
        sum-=maxV;

        System.out.println(sum);
    }
}