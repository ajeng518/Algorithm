import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int s;
		int e;
		int cost;

		public Node() {
			super();
		}

		public Node(int s, int e, int cost) {
			super();
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);// 오름차순
		}

	}

	static int V, E;
	static int parent[], rank[];
	static PriorityQueue<Node>pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		pq=new PriorityQueue<>();
		parent = new int[V + 1];
		rank = new int[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Node(s, e, cost));
		}
		initial();

		int sum=0;
		int cnt=0;
		while(cnt!=V-1) {
			Node n=pq.poll();
			if(union(n.s, n.e)) {
				cnt++;
				sum+=n.cost;
			}
		}System.out.println(sum);
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		if (rank[x] < rank[y]) {
			rank[y] += rank[x];
			parent[x] = y;
		} else {
			rank[x] += rank[y];
			parent[y] = x;
		}
		return true;

	}

	private static int find(int x) {
		if (x == parent[x])
			return parent[x];
		else
			return parent[x] = find(parent[x]);
	}

	private static void initial() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

}
