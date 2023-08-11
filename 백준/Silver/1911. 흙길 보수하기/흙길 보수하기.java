import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean isremove = false;
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] uoung = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			uoung[i][0] = Integer.parseInt(st.nextToken());
			uoung[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(uoung, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		int cover=0;
		int result=0;
		for(int i=0;i<n;i++) {
			if(uoung[i][0]>cover) {
				cover=uoung[i][0];
			}if(uoung[i][1]>cover) {
				while(uoung[i][1]>cover) {
					cover+=l;
					result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
