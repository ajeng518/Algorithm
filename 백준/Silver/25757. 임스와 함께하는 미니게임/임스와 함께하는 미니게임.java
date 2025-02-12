import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int size = 0;

        switch (game) {
            case 'Y':
                size = 1;
                break;
            case 'F':
                size = 2;
                break;
            case 'O':
                size = 3;
                break;
        }

        int ans = 0;
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            if (q.size() == size) {
                ans++;
                q.clear();
            }
            if (visited.contains(cur)) continue;

            q.add(cur);
            visited.add(cur);
        }

        if (q.size() == size) ans++;

        System.out.println(ans);
    }
}