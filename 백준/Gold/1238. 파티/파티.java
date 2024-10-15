import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int position;
        int value;

        public Node(int position, int value) {
            this.position = position;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//노드
        int m = Integer.parseInt(st.nextToken());//길
        int x = Integer.parseInt(st.nextToken());//도착위치

        Map<Integer, List<Node>> goParty;
        Map<Integer, List<Node>> goHome;

        goParty = new HashMap<>();
        goHome = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            goParty.put(i, new ArrayList<>());
            goHome.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            goHome.get(start).add(new Node(end, value));
            goParty.get(end).add(new Node(start, value));
        }

        int[] homeDP = dijkstra(goHome, x, n);
//        System.out.println(Arrays.toString(homeDP));
        int[] partyDP = dijkstra(goParty, x, n);
//        System.out.println(Arrays.toString(partyDP));

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(homeDP[i] + partyDP[i], ans);
        }

        System.out.println(ans);
    }

    private static int[] dijkstra(Map<Integer, List<Node>> list, int start, int n) {
        int[] dp = new int[n + 1];
        boolean[] chk = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (chk[cur.position]) continue;
            chk[cur.position] = true;

            for (Node next : list.get(cur.position)) {
                if (chk[next.position]) continue;
                int newValue = cur.value + next.value;
                if (dp[next.position] <= newValue) continue;

                dp[next.position] = newValue;

                pq.add(new Node(next.position, dp[next.position]));
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp;
    }
}