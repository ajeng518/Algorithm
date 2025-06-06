import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 5_000_000;

    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCase; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list.add(new Node(s, e, cost));
                list.add(new Node(e, s, cost));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = -Integer.parseInt(st.nextToken());

                list.add(new Node(s, e, cost));
            }

            String answer = "NO";

//            for (int i = 1; i <= n; i++) {
//                if (!BellmanFord(n, 2 * m + w, i)) {
//                    answer = "YES";
//                    break;
//                }
//            }

//            if (!BellmanFord(n, 2 * m + w, 1)) {
//                answer = "YES";
//            }

            sb.append(BellmanFord(n, 2 * m + w)).append("\n");

        }

        System.out.println(sb);
    }

    public static String BellmanFord(int n, int mw) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i < n; i++) {
            boolean isChange = false;
            for (int j = 0; j < mw; j++) {
                Node cur = list.get(j);
                int newCost = dist[cur.start] + cur.cost;
                if (dist[cur.end] <= newCost) continue;

                dist[cur.end] = newCost;
                isChange = true;
            }
            if (!isChange) break;
        }

        for (int j = 0; j < mw; j++) {
            Node cur = list.get(j);
            if (dist[cur.end] <= dist[cur.start] + cur.cost) continue;
            return "YES";
        }

        return "NO";
    }
}