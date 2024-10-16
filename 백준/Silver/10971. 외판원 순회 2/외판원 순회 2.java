import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], min, start;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<N;i++) {
			visited[i] = true;
			start=i;
			dp(i, 0, 0);
			visited[i]=false;
		}
		
		System.out.println(min);

	}

	private static void dp(int now, int sum, int cnt) {
		if (cnt == N - 1 ) {
			if(map[now][start]>0) {
				sum+=map[now][start];
				min = Math.min(min, sum);
			}
			
			return;
		}


		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[now][i] > 0 && map[now][i]+sum<=min) {
				visited[i] = true;
				dp(i, sum + map[now][i], cnt + 1);
				visited[i] = false;
			}
		}
	}

}
