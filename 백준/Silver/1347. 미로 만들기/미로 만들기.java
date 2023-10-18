import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String n = br.readLine();
		char[] input = br.readLine().toCharArray();
		// 남-서-북-동
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		
		char[][] map = new char[101][101];
		int x = 50, y = 50;
		map[x][y] = '.';
		int see = 0;
		int minX = 50, minY = 50;
		int maxX = 50, maxY = 50;

		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'F') {
				x += dx[see];
				y += dy[see];
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				map[x][y] = '.';
			} else if (input[i] == 'R') {
				if (see + 1 >= 4)
					see = 0;
				else
					see++;
			} else if (input[i] == 'L') {
				if (see - 1 < 0)
					see = 3;
				else
					see--;
			}
		}

		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (map[i][j] == 0)
					sb.append("#");
				else
					sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
