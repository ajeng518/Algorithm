import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int node;
        int cost;
    
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] lineList = new int[N + 1][N + 1];
        boolean[] chk = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (lineList[start][end] > 0) {
                int last = lineList[start][end];
                lineList[start][end] = Math.min(last, cost);
                lineList[end][start] = lineList[start][end];

                continue;
            }

            lineList[start][end] = cost;
            lineList[end][start] = cost;
        }

        for (int i = 1; i <= N; i++) {
            if (lineList[1][i] <= 0) continue;
            pq.add(new Node(i, lineList[1][i]));
        }

        Long sum = 0L;
        chk[1] = true;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (chk[now.node]) continue;

            sum += now.cost;
            chk[now.node] = true;

            for (int i = 1; i <= N; i++) {
                if (lineList[now.node][i] <= 0) continue;
                if (chk[i]) continue;
                
                pq.add(new Node(i, lineList[now.node][i]));
            }
        }

        System.out.println(sum);

    }


}