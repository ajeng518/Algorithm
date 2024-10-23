import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static Map<Integer, List<Node>> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodeList = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            nodeList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList.get(s).add(new Node(e, cost));
            nodeList.get(e).add(new Node(s, cost));
        }

        int ans = dijkstra(n);
        System.out.println(ans);
    }

    private static int dijkstra(int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int[] dp = new int[end + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dp[cur.node]) continue;
            if (cur.node == end) break;

            for (Node next : nodeList.get(cur.node)) {
                if (dp[next.node] <= cur.cost + next.cost) continue;
                dp[next.node] = cur.cost + next.cost;

                pq.add(new Node(next.node, dp[next.node]));
            }
        }

        return dp[end];
    }
}