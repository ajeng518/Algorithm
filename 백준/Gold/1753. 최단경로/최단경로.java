import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static class Node implements Comparable<Node> {
		int v;
		int cost;

		public Node() {
			super();
		}

		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost-o.cost;
		}

	}

	static int V, E, dist[];
	static List<Node>[] list;
	static boolean[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())]
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int num = 0;
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		
		dijkstra(start);
		while (num++ < V) {
			if (dist[num]== Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[num]).append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		chk=new boolean[V+1];
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.v] < cur.cost)
				continue;
			
//			if (chk[cur.v])
//				continue;
//			chk[cur.v] = true;

			for (Node next : list[cur.v]) {
				if (dist[next.v] > dist[cur.v] + next.cost) {
					dist[next.v] = dist[cur.v] + next.cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

}
