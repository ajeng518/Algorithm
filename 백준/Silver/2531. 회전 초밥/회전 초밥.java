import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int max=Integer.MIN_VALUE;
		
		Set<Integer>many;
		List<Integer>list=new ArrayList<>();
		ArrayDeque<Integer>q=new ArrayDeque<>();
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		
		for(int i=0;i<k;i++) {
			q.add(list.get(i));
		}
		many=new HashSet<>(q);
		many.add(c);
		max=Math.max(max,many.size());
		
		int now=k;
		for(int i=0;i<n;i++) {
			if(now==list.size()) {
				now=0;
			}
			q.poll();
			q.add(list.get(now));
			many=new HashSet<>(q);
			many.add(c);
//			System.out.println(many);
			max=Math.max(max,many.size());
			now++;
		}
		
		System.out.println(max);
	}

}
