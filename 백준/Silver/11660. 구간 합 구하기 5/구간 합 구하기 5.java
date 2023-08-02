import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int result=0;
		
		int[][]map=new int[n+1][n+1];
		int[][]sum=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				sum[i][j]=sum[i][j-1]+map[i][j];
			}
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());//x1,y1
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());//x2,y2
			
			result=0;
			for(int j=x1;j<=x2;j++) {
				result+=sum[j][y2];
				result-=sum[j][y1-1];
			}
			sb.append(result+"\n");
		}System.out.println(sb);
	}

}
