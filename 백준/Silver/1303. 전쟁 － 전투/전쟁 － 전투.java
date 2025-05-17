import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] chk;
	static int flag, n, m;
	static int[][] go;
	static char[][] map;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();	

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] color = new int[2];
		go = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		chk = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				if (chk[i][j])
					continue;
				
				int count=bfs(i, j, 0, map[i][j]);
				
				if(map[i][j]=='B') {
					color[1]+=count*count;
				}else {
					color[0]+=count*count;
				}
				
			}
		}
		sb.append(color[0]+" ");
		sb.append(color[1]);
		System.out.println(sb.toString());

	}

	private static int bfs(int i, int j, int cnt, char flag) {
		q.offer(new int[] {i,j});
		chk[i][j]=true;
		
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			cnt++;
			
			for (int w = 0; w < 4; w++) {
				int x = temp[0] + go[w][0];
				int y = temp[1] + go[w][1];
				if (checking(x, y, flag)) {
					q.offer(new int[] {x,y});
					chk[x][y]=true;
				}
			}
		}
		return cnt;
	}

	private static boolean checking(int x, int y, char flag) {
		return (x >= 0 && y >= 0 && x < m && y < n && chk[x][y] == false && map[x][y] == flag );
		
	}

}
