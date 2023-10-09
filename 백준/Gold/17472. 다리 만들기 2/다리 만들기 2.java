import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class MST_Node implements Comparable<MST_Node> {
		int n1, n2;
		int len;

		public MST_Node(int n1, int n2, int len) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.len = len;
		}

		@Override
		public int compareTo(MST_Node o) {
			return this.len - o.len;
		}

	}

	static int N, M, map[][],parent[], idx;
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { 0, 1, 0, -1 };
	static boolean chk[][];
	static PriorityQueue<MST_Node> pq;
	static List<int[]>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		idx = 0;
		list = new ArrayList[7];// 섬 최대 6개임
		chk = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				if (chk[i][j])
					continue;
				list[++idx] = new ArrayList<>();
				bfs(i, j, idx);
			}
		}
		
		parent=new int[idx+1];
		for(int i=1;i<=idx;i++) {
			parent[i]=i;			
		}
		
		pq=new PriorityQueue<>();
		
		for (int i = 1; i <= idx; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				int[] now = list[i].get(j);
				for (int k = 0; k < 4; k++) {// 상하좌우
					makeLine(now[0], now[1], i, k, -1);// x,y,현재섬 번호, 진행방향, count
				}
			}
		}
		
		System.out.println(prim());

	}

	private static int prim() {
		int result = 0;
		int bridge=0;
		
		while(!pq.isEmpty()) {
			MST_Node node=pq.poll();
//			System.out.println(node.n1+", ");
			int p1=find(node.n1);
			int p2=find(node.n2);
			
//			System.out.println(p1+", "+p2);
			
			if(p1!=p2) {
				union(p1,p2);
				result+=node.len;
//				System.out.println(node.len);
				bridge++;	
			}
		}
		if(result==0)return -1;
		if(bridge!=idx-1)return -1;
		
		return result;

	}

	private static void union(int p1, int p2) {
		parent[p1]=p2;
	}

	private static int find(int node) {
		if(parent[node]==node)return parent[node];
		else return parent[node]=find(parent[node]);
	}

	private static void makeLine(int x, int y, int num, int way, int cnt) {
		if (map[x][y] != num && map[x][y] != 0) {
			if (cnt >= 2) {
				pq.offer(new MST_Node(num, map[x][y], cnt));
			}
			return;
		}

		int nX = x + dX[way];
		int nY = y + dY[way];

		if (nX < 0 || nX >= N)
			return;
		if (nY < 0 || nY >= M)
			return;
		if (map[nX][nY] == num)
			return;
		makeLine(nX, nY, num, way, cnt + 1);

	}

	private static void bfs(int x, int y, int index) {
		Deque<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { x, y });
		chk[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			map[now[0]][now[1]]=index;
			list[index].add(new int[] { now[0], now[1] });

			for (int i = 0; i < 4; i++) {
				int nX = now[0] + dX[i];
				int nY = now[1] + dY[i];

				if (nX < 0 || nX >= N)
					continue;
				if (nY < 0 || nY >= M)
					continue;

				if (chk[nX][nY])
					continue;
				if (map[nX][nY] == 0)
					continue;

				q.offer(new int[] { nX, nY });
				chk[nX][nY] = true;
			}
		}

	}

}
