import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		List<Integer>list=new ArrayList<>();
		
		int N=Integer.parseInt(st.nextToken());//다리를 건너려는 트럭의 수
		int W=Integer.parseInt(st.nextToken());//다리길이
		int L=Integer.parseInt(st.nextToken());//다리 최대 하중
		
		int[]truck=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			truck[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<W;i++) {
			list.add(0);
		}
		
		int cnt=0;
		for(int i=0;i<N;) {
			if(list.isEmpty()) {//리스트가 비었을 경우
				list.add(truck[i]);
				cnt++;
				i++;
			}else {//리스트에 트럭이 있을 경우
				if(list.size()==W) {//트럭의 개수가 다리 길이랑 같을 경우
					list.remove(0);
				}else {
					int sum=0;
					for(int j=0;j<list.size();j++) {
						sum+=list.get(j);
					}
					
					if(sum>=L) {
						list.add(0);
						cnt++;
					}else {
						if(sum+truck[i]<=L) {
							list.add(truck[i]);
							cnt++;
							i++;
						}else {
							list.add(0);
							cnt++;
						}
					}
				}
			}
		}
		if(!list.isEmpty()) {
			cnt+=list.size();
		}
		System.out.println(cnt);
	}

}
