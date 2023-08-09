import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[]input;
	static Queue<Integer>q;
	static boolean[] chk;
	static int n, cnt;
	static int[]len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		q=new ArrayDeque<>();
		input=new int[n];
		chk=new boolean[n];
		len=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		cnt=bfs();
		System.out.println(cnt);
		
	}
	
	public static int bfs() {
		chk[0]=true;
		cnt= 0;
		q.offer(0);
		
		
		while(!q.isEmpty()) {
			
			int size=q.size();
			
			while(--size>=0) {
				int now=q.poll();
				if(now==input.length-1) {
					return cnt;
				}
				for(int i=now+1;i<=input[now]+now && i<n; i++) {
					if(chk[i]==false) {
						chk[i]=true;
						q.offer(i);
					}
				}
			}
			cnt++;
			
		}
		
		return -1;
		
	}
}
