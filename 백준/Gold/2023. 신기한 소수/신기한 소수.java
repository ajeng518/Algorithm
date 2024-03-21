import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int n,ans;
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		ans=0;

		permu(0,0);

		System.out.print(sb.toString());
	}

	private static void permu(int cnt, int num){
		if(cnt>0 && !checking(cnt, num))	return;

		if(cnt==n){
			sb.append(num+"\n");
			return;
		}

		for(int i=1;i<=9;i++){
			if(cnt==0 && i==1||i==4||i==6||i==8)	continue;
			if(cnt>0 && i%2==0)	continue;
			permu(cnt+1,num*10+i);
		}
	}

	private static boolean checking(int cnt, int num) {
		if (cnt > 1) {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) return false;
			}
			return true;
		} else if (cnt == 1) {
			if (num == 2 || num == 3 || num == 5 || num == 7) return true;
			else return false;
		}
		return true;
	}


}
