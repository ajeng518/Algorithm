import java.util.*;
import java.io.*;
/*
*리스트 배열 사용시 컴파일 경고 발생시 사용
*@SuppressWarnings("unchecked")
*/
public class Main{
    static class Jewel implements Comparable<Jewel> {
        int m;
        int v;

        Jewel(int m, int v){
            this.m = m;
            this.v=v;
        }
        
        @Override
        public int compareTo(Jewel o){
            if(this.m == o.m)
                return o.v - this.v;
            return this.m-o.m;
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        int[] bag = new int[k];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            jewels[i]=new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewels);
        
        for(int i=0; i<k; i++){
            bag[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int j =0;
        long ans=0;
        
        for(int i=0; i<k; i++){
            while(j < n){
                if(jewels[j].m > bag[i]) break;
                
                pq.add(jewels[j++].v);
            }

            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }
}
