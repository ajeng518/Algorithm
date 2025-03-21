import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

    }

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Edge>[] nodeList = new List[n + 1];
        for(int i=1;i<=n;i++) nodeList[i]=new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Edge(end, len));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        System.out.println(dijkstra(n, m, start, end, nodeList));

    }

    private static int dijkstra(int n, int m, int start, int end, List<Edge>[] list){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        boolean[] visited=new boolean[n+1];
        dp[start]=0;

        while(!pq.isEmpty()){
            Edge cur=pq.poll();

            if(visited[cur.node]) continue;
            visited[cur.node]=true;

            if(cur.node == end) return  dp[end];

            for(Edge next: list[cur.node]){
                if(visited[next.node])continue;
                if(dp[next.node]<=dp[cur.node]+next.cost) continue;

                dp[next.node]=dp[cur.node]+next.cost;
                pq.add(new Edge(next.node, dp[next.node]));
            }
        }

        return dp[end];
    }

}
