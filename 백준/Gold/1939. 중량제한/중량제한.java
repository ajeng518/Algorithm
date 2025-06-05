import java.util.*;
import java.io.*;

public class Main {
     static class Road implements Comparable<Road>{
        int idx;
        int weight;

        Road(int idx, int weight){
            this.idx=idx;
            this.weight=weight;
        }

        public int compareTo(Road o){
            return o.weight-this.weight;
        }
    }

    static int MAX=1000000001;
    static int[] dist;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Road>[] island = new List[n+1];
        for(int i =1;i<=n;i++) island[i]=new ArrayList<>();
        
        while(m-- > 0){
            st=new StringTokenizer(br.readLine());
            
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int cost= Integer.parseInt(st.nextToken());

            island[a].add(new Road(b, cost));
            island[b].add(new Road(a, cost));
        }

        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());

        dist=new int[n+1];
        Arrays.fill(dist, -1);
        
        bfs(start, end, island);
        System.out.println(dist[end]);
    }

    private static void bfs(int start, int end, List<Road>[] island){
        PriorityQueue<Road> pq = new PriorityQueue<>();        
        pq.add(new Road(start, MAX));
        dist[start]=MAX;
        
        while(!pq.isEmpty()){
            Road cur = pq.poll();

            if(dist[cur.idx] > cur.weight) continue;

            for(Road next: island[cur.idx]){
                if(dist[next.idx] > next.weight) continue;
                
                int nextWeight = Math.min(next.weight, dist[cur.idx]);
                if(nextWeight <= dist[next.idx]) continue;

                pq.add(new Road(next.idx, nextWeight));
                dist[next.idx]=nextWeight;
            }
        }
    }
}