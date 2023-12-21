import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static class Bus implements  Comparable<Bus>{
        int idx;
        int cost;

        public Bus() {
        }

        public Bus(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Bus>pq=new PriorityQueue<>();
        List<Bus>[]busList;
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        busList=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            busList[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(st.nextToken());
            busList[idx].add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        int MAX=Integer.MAX_VALUE;

        int[] canGo=new int[n+1];//1부터 시작할거임
        Arrays.fill(canGo,MAX);
        boolean[] chk=new boolean[n+1];

        canGo[start]=0;
        pq.add(new Bus(start, 0));

        while(!pq.isEmpty()){
            Bus cur=pq.poll();

            if(chk[cur.idx])continue;
            chk[cur.idx]=true;

            for(Bus next:busList[cur.idx]){
                if(!chk[next.idx] && canGo[next.idx]>canGo[cur.idx]+next.cost){
                    canGo[next.idx]=canGo[cur.idx]+next.cost;
                    pq.add(new Bus(next.idx, canGo[next.idx]));
                }
            }
        }

        System.out.println(canGo[end]);
    }
}
