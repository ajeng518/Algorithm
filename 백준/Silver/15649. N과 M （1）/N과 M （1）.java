import java.util.*;
import java.io.*;

public class Main {
   	static int n, m;
	static List<Integer>list;
	static int[] chk;
	
	static void re(int x) {
		
		if(x==m) {
			print_num();
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(chk[i]!=1) {
				list.add(i);
				chk[i]=1;

				re(x+1);
				
				chk[i]=0;
				list.remove(list.size()-1);
			}
		}
	}
	private static void print_num() {
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
        
        System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
        
		chk=new int[n+1];
        list=new ArrayList<>();
		
		re(0);
	}
}