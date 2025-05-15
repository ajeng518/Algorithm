import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx=idx;
            this.cost=cost;
        }

        public int compareTo(Node o){
            return this.cost-o.cost;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Node>[] list=new List[v+1];
        for(int i=1;i<=v;i++) list[i]=new ArrayList<>();
        
        for(int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        System.out.println(prim(v, e, list));
        
    }
    
    private static int prim(int v, int e, List<Node>[] list){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        boolean[] visited=new boolean[v+1];

        int cnt=0;

        while(!pq.isEmpty()){
            Node cur=pq.poll();

            if(visited[cur.idx]) continue;
            visited[cur.idx]=true;
            cnt+=cur.cost;

            for(Node next: list[cur.idx]){
                if(visited[next.idx]) continue;

                pq.add(next);
            }
        }

        return cnt;
    }
}