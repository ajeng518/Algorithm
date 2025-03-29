import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int node;
        int cost;

        Node(int node, int cost){
            this.node=node;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static int max;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        List<Node>[] tree = new List[n+1];
        for(int i=1;i<=n;i++) tree[i]=new ArrayList<>();

        for(int i =0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(end, cost));
            tree[end].add(new Node(start, cost));
        }

        List<Integer> result = dijkstra(n, tree, 1);
        int ans = dijkstra(n, tree, result.get(1)).get(0);

        System.out.println(ans);
    }

    private static List<Integer> dijkstra(int n, List<Node>[] tree, int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, 1_000_000_000);

        pq.add(new Node(start, 0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Node cur =pq.poll();

            for(Node next: tree[cur.node]){
                if(dist[next.node]<=dist[cur.node]+next.cost) continue;
                dist[next.node]=dist[cur.node]+next.cost;
                pq.add(new Node(next.node, dist[next.node]));
            }
        }
        
        int max=0;
        int idx =start;
        
        for(int i=1;i<=n;i++){
            if(i==start) continue;
            if(max>=dist[i]) continue;

            max=dist[i];
            idx =i;
        }
        return Arrays.asList(max, idx);
        
    }
}