import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min;
	static int[] result;
	static int[][]taste;
	static boolean[] used;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		taste=new int[n][2];
		used=new boolean[n];
		min=Integer.MAX_VALUE;
        
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			taste[i][0]=Integer.parseInt(st.nextToken());
			taste[i][1]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
        
		System.out.println(min);
	}
	
	public static void dfs(int now, int cnt) {
		if(now==n) {
			if(cnt>0) {
				result= new int[]{1, 0};
				for(int i=0;i<used.length;i++) {
					if(used[i]) {
						result[0]*=taste[i][0];
						result[1]+=taste[i][1];
					}
				}
                min=Math.min(min, Math.abs(result[0] - result[1]));
			}
            return;
		}
		
		used[now]=true;
		dfs(now+1,cnt+1);
		used[now]=false;
		dfs(now+1,cnt);
	}
}
