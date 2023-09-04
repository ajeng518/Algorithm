import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int Test = 1; Test <= T; Test++) {

			int day = Integer.parseInt(br.readLine());
			long result = 0;
			long[] back=new long[day];

			long[] Do = new long[day];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < day; i++) {
				Do[i] = Integer.parseInt(st.nextToken());
			}
			
			long nowMoney=Do[day-1];
			int idx=day-1;
			
			for(int i=day-2;i>=0;i--) {
				if(nowMoney>Do[i]) {
					back[idx]+=nowMoney-Do[i];
				}else {
					nowMoney=Do[i];
					idx=i;
				}
			}
			
			for(int i=0;i<day;i++) {
				if(back[i]>0) {
					result+=back[i];
				}
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
