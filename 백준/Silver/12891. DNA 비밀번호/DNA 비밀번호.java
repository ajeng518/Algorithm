import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		HashMap<Character, int[]>map=new HashMap<>();
		
		char[] can= {'A','C','G','T'};//문자열 구성 문자
		int n=Integer.parseInt(st.nextToken());//주어진 문자열 길이
		int k=Integer.parseInt(st.nextToken());//만들고자 하는 문자열 길이
		String input=br.readLine();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<can.length;i++) {
			map.put(can[i], new int[] {0, Integer.parseInt(st.nextToken())});
		}
		
		int pw=0;
		for(int i=0;i<k;i++) {
			map.get(input.charAt(i))[0]++;
		}
		
		int right=0;
		for(int i=0;i<can.length;i++) {
			if(map.get(can[i])[0]>=map.get(can[i])[1]) {
				right++;
			}
		}if(right==4) {
			pw++;
		}
		
		for(int i=0;i<n-k;i++) {
			map.get(input.charAt(i))[0]-=1;
			map.get(input.charAt(i+k))[0]+=1;
			int a=0;
			for(int j=0;j<can.length;j++) {
				if(map.get(can[j])[0]>=map.get(can[j])[1]) {
					a++;
				}
			}
			if(a==4) {
				pw++;
			}
		}System.out.println(pw);
	}
}
