import java.util.*;
import java.io.*;

public class Main {
    static class Road implements Comparable<Road>{
        int node;
        int cost;

        Road(int node, int cost){
            this.node=node;
            this.cost=cost;
        }

        @Override
        public int compareTo(Road o){
            return this.cost-o.cost;
        }
    }

    static List<Road>[] list;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        while(true){
            st=new StringTokenizer(br.readLine());
            int m =Integer.parseInt(st.nextToken());//집 수
            int n =Integer.parseInt(st.nextToken());// 길 수
            int max=0;

            if(m==0 && n==0) break;
    
            list=new List[m+1];
            for(int i=0;i<=m;i++){
                list[i]=new ArrayList<>();
            }
    
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                int a =Integer.parseInt(st.nextToken());
                int b =Integer.parseInt(st.nextToken());
                int cost =Integer.parseInt(st.nextToken());
    
                list[a].add(new Road(b, cost));
                list[b].add(new Road(a, cost));
                max+=cost;
            }
        
            sb.append(max-prim(m, n)).append("\n");
        }

        System.out.println(sb);
        
    }
    private static int prim(int m, int n){
        PriorityQueue<Road> pq=new PriorityQueue<>();
        boolean[] visited=new boolean[m+1];
        int allCost=0;

        pq.add(new Road(0, 0));

        while(!pq.isEmpty()){
            Road cur=pq.poll();

            if(visited[cur.node]) continue;
            
            visited[cur.node]=true;
            allCost+=cur.cost;

            for(Road next: list[cur.node]){
                if(visited[next.node]) continue;
                pq.add(next);
            }
        }

        return allCost;
    }
}