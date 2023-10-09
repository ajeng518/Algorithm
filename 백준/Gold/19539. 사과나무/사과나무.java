import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int[]apple=new int[N];
		int odd=0;
		int even=0;
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			apple[i]=Integer.parseInt(st.nextToken());
			odd+=apple[i]%2;
			even+=apple[i]/2;
		}
		if(even>odd) {
			while(Math.abs(even-odd)>1) {
				even--;
				odd+=2;
			}
		}
		if(even==odd) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

}
