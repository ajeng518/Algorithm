import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] turn, map;
	static long[][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		turn = new int[][] { { 0, 1 }, { 1, 0 } };


		map = new int[n][n];
		result=new long[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result[0][0]=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int temp=map[i][j];
				if(temp==0)	break;
				for(int k=0;k<2;k++) {
					int x=i+turn[k][0]*temp;
					int y=j+turn[k][1]*temp;
                    
					if(!checking(x, y)) continue;
                    
					result[x][y]+=result[i][j];
				}
			}
		}
		System.out.println(result[n-1][n-1]);
		
	}

	private static boolean checking(int x, int y) {
		return (x >= 0 && y >= 0 && x < n && y < n );
	}

}
