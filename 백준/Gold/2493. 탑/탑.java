import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Stack<int[]>top=new Stack<>();
	static int n, input[],cnt[];
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n=Integer.parseInt(br.readLine());
		input=new int[n];
		cnt=new int[n];

		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			input[i]=Integer.parseInt(st.nextToken());
		}

		topnum();
		System.out.println(sb.toString());
	}

	private static void topnum(){
		int now=0;

		for(int i=0;i<n;i++){
			if(top.isEmpty()){
				cnt[i]=0;
				sb.append("0 ");
				top.push(new int[]{input[i],i+1});
			}else{//탑에 이전 값들이 있는 경우
				while(!top.isEmpty()) {
					int[] temp = top.peek();

					if (temp[0] >= input[i]) {
						cnt[i] =temp[1];
						sb.append(cnt[i]+" ");
						top.push(new int[]{input[i],i+1});
						break;
					}else{
						top.pop();

					}if(top.isEmpty()){//탑이 비었다면
						sb.append("0 ");
						top.push(new int[]{input[i],i+1});
						break;
					}
				}
			}
		}
	}
}
