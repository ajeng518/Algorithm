import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final long INF = Long.MAX_VALUE - 1;

    public static class Node {
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
    static Long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());//도시수
        int m = Integer.parseInt(st.nextToken());//버스 수

        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dist = new Long[n + 1];
        Arrays.fill(dist, INF);
        if (!BellmanFord(n, m, 1)) sb.append(-1);
        else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static boolean BellmanFord(int n, int m, int start) {

        dist[start] = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node cur = list.get(j);

                if (dist[cur.start] == INF) continue;
                if (dist[cur.end] <= dist[cur.start] + cur.cost) continue;

                dist[cur.end] = dist[cur.start] + cur.cost;

                if (i + 1 == n) return false;
            }
        }

        return true;
    }
}