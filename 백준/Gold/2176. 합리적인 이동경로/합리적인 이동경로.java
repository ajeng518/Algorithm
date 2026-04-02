import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int next;
        int cost;

        Node(int next, int cost){
            this.next=next;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static List<Node>[] list;
    static int n, m;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list= new List[n+1];
        for(int i=0;i<=n;i++) list[i]=new ArrayList<>();
        
        for(int i = 0;i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        int[] dist = new int[n+1];
        dist = dijkstra();

        System.out.println(dp(dist));
    }

    private static int dp(int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1; i<=n;i++) pq.add(new Node(i, dist[i]));
        pq.poll();

        int[] dp= new int[n+1];
        dp[2]=1;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(Node next: list[cur.next]){
                if(dist[next.next] >=  dist[cur.next]) continue;
                
                dp[cur.next] += dp[next.next];
            }

            if(cur.next == 1) break;
        }

        return dp[1];
    }

    private static int[] dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(2, 0));
        
        boolean[] visited = new boolean[n+1];
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[2]=0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.next]) continue;
            visited[cur.next]=true;

            for(Node next: list[cur.next]){
                if(visited[next.next]) continue;

                if(dist[next.next] <= dist[cur.next] + next.cost) continue;

                dist[next.next] = dist[cur.next] + next.cost;
                pq.add(new Node(next.next, dist[next.next]));
            }
        }

        return dist;
    }
}
