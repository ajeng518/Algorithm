import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N, M, map[][], parent[], idx;
	static List<int[]>[] list;
	static boolean[][] chk;
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { 0, 1, 0, -1 };
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//
		M = Integer.parseInt(st.nextToken());//
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList[7];
		chk=new boolean[N][M];
		idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0 && !chk[i][j]) {
					list[++idx] = new ArrayList();
					bfs(i, j, idx);
				}
			}
		}

		pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		parent = new int[idx + 1];
		for (int i = 1; i <= idx; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= idx; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				int[]now=list[i].get(j);
				for (int k = 0; k < 4; k++) {
					makeBridge(now[0], now[1], i, k, -1);
				}
			}
		}
		
		System.out.println(kruskal());

	}

	private static int kruskal() {
		int bridge=0;
		int len=0;
		
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int p1 = find(cur[0]);
			int p2 = find(cur[1]);

			if (p1 != p2) {
				union(p1, p2);
				len+=cur[2];
				bridge++;
			}
		}
		
		if(len<2)return -1;
		if(bridge<idx-1)return -1;
		return len;
	}

	private static void union(int p1, int p2) {
		parent[p1] = p2;
	}

	private static int find(int node) {
		if (node == parent[node])
			return parent[node];
		return parent[node] = find(parent[node]);
	}

	private static void makeBridge(int x, int y, int idx, int way, int cnt) {

		if (map[x][y] > 0 && map[x][y] != idx) {
			if (cnt >= 2) {
				pq.add(new int[] { idx, map[x][y], cnt });
			}
			return;
		}

		int nX = x + dX[way];
		int nY = y + dY[way];

		if (nX < 0 || nX >= N)
			return;
		if (nY < 0 || nY >= M)
			return;
		if (map[nX][nY] == idx)
			return;

		makeBridge(nX, nY, idx, way, cnt + 1);

	}

	// 섬마다 숫자 매핑하기(BFS)
	private static void bfs(int x, int y, int idx) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { x, y });
		chk[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = idx;
			list[idx].add(cur);

			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + dX[i];
				int nY = cur[1] + dY[i];

				if (nX < 0 || nX >= N)
					continue;
				if (nY < 0 || nY >= M)
					continue;
				if (chk[nX][nY])
					continue;
				if (map[nX][nY] == 0)
					continue;

				q.add(new int[] { nX, nY });
				chk[nX][nY] = true;
			}

		}
	}

	// 섬에 다리 놓기(dfs)--> list에 다리 최소길이 정보 입력

	// 최소 스패닝 트리 연결(크루스칼)

}