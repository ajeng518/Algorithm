import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt, max, dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[100001][4];
				
		dp[1][1] =1;
		dp[2][1] =1;
		dp[2][2] =1;
		dp[3][1] =1;
		dp[3][2] =1;
		dp[3][3] =1;
		
		for(int i=4; i<=10000; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1]+ dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][1] + dp[num][2] + dp[num][3]).append("\n");
		}System.out.println(sb.toString());
	}

}
