import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge>[] nodeList = new List[n + 1];
        for(int i=1;i<=n;i++) nodeList[i]=new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Edge(end, len));
            nodeList[end].add(new Edge(start, len));
        }

        System.out.println(prim(n, m, nodeList));

    }

    private static long prim(int n, int m, List<Edge>[] list){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        boolean[] visited=new boolean[n+1];
        long all=0;
        int cnt=0;

        while(!pq.isEmpty()){
            if(cnt==n)break;

            Edge cur=pq.poll();

            if(visited[cur.node]) continue;

            visited[cur.node]=true;
            all+=cur.cost;
            cnt++;
            for(Edge next: list[cur.node]){
                pq.add(next);
            }
        }

        return all;
    }

}
