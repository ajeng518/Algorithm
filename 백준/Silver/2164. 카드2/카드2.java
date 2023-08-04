import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer>q=new LinkedList<>();
		int n=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		while(q.size()>1) {
			q.poll();
			int temp=q.poll();
			q.add(temp);
		}
		System.out.println(q.poll());
	}
}
