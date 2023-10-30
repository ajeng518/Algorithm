import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> list=new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			if(list.contains(str))
				continue;
			list.add(str);
		}

		int first = 0;
		int second = 0;
		int maxLen = 0;

		for (int i = 0; i < N - 1; i++) {
			String str1 = list.get(i);
			for (int j = i + 1; j < N; j++) {
				String str2 = list.get(j);
				int len = str1.length() > str2.length() ? str2.length() : str1.length();
				int cnt = 0;
				for (int k = 0; k < len; k++) {
					if (str1.charAt(k) != str2.charAt(k))
						break;
					cnt++;
				}
				if (cnt > maxLen) {
					first = i;
					second = j;
					maxLen = cnt;
				}
			}
		}
		sb.append(list.get(first)).append("\n").append(list.get(second));
		System.out.println(sb);
	}
}
