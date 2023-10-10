import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static int D, W, K, map[][],min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			min=-1;
			
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(K==1) {
				sb.append("#").append(test).append(" ").append("0").append("\n");
			}
			else{
				if(chkTest()) {
					sb.append("#").append(test).append(" ").append("0").append("\n");
				}else{
					for(int i=0;i<=K;i++) {
						subset(i,0,0);
						if(min!=-1) {
							break;
						}
					}
					sb.append("#").append(test).append(" ").append(min).append("\n");
				}
				
			}	
		}
		System.out.println(sb);
	}

	private static void subset(int n, int idx, int cnt) {

		if(cnt==n) {
			if(chkTest()) {
				min=n;
			}
			return;
		}if(idx>=D) {return;}
		
		int[] temp=new int[W];
		temp=map[idx].clone();
		
		Arrays.fill(map[idx], 0);
		subset(n,idx+1,cnt+1);
		
		Arrays.fill(map[idx], 1);
		subset(n,idx+1,cnt+1);
		
		map[idx]=temp.clone();
		subset(n,idx+1,cnt);
	}

	private static boolean chkTest() {

		for (int i = 0; i < W; i++) {
			int cnt = 1;
			for (int j = 1; j < D; j++) {
				if (map[j-1][i] == map[j][i])
					cnt++;
				else {
					cnt = 1;
				}
				if (cnt == K) {
					break;
				}
			}
			if(cnt<K) return false;
		}
		return true;
	}
}
