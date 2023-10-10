import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int len;

		public Node(int x, int y, int len) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
		}

		@Override
		public int compareTo(Node o) {
			if (len == o.len)
				if (x == o.x)
					return y - o.y;
				else
					return x - o.x;
			return len - o.len;
		}
	}

	static int N, map[][];
	static Node cur;
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					cur = new Node(i, j, 0);
					map[i][j]=0;
				}
			}
		}

		System.out.println(FishHunt());

	}

	private static int FishHunt() {
		int size=2;
		int eat=0;
		int result=0;
		
		while (true) {
			Queue<Node> pq = new PriorityQueue<>();
			boolean[][] chk=new boolean[N][N];
			pq.add(new Node(cur.x, cur.y, 0));// x,y,cnt
			chk[cur.x][cur.y]=true;
			
			boolean eatFish=false;
			
			while (!pq.isEmpty()) {
				cur = pq.poll();
				
				if(map[cur.x][cur.y]>0 && map[cur.x][cur.y]<size) {
					eat++;
					eatFish=true;
					result+=cur.len;
					map[cur.x][cur.y]=0;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nX = cur.x + dX[i];
					int nY = cur.y + dY[i];

					if (nX < 0 || nX >= N)
						continue;
					if (nY < 0 || nY >= N)
						continue;
					if(chk[nX][nY])
						continue;
					if(map[nX][nY]>size)continue;
					pq.add(new Node(nX,nY,cur.len+1));
					chk[nX][nY]=true;

				}
			}
			if(!eatFish)
				break;
			if(eat==size) {
				eat=0;
				size++;
			}
		}
		return result;
	}

}
