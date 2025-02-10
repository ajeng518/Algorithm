import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] choice;
    static boolean[] visited, finished;
    static int n, visitedCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            n = Integer.parseInt(br.readLine());//학생수
            visitedCnt = 0;

            choice = new int[n + 1];//지목 배열
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (finished[i]) continue;

                dfs(i);
            }

            sb.append(n - visitedCnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int cur) {

        if (visited[cur]) {
            finished[cur] = true;
            visitedCnt++;
        } else {
            visited[cur] = true;
        }

        int next = choice[cur];
        if (!finished[next]) {
            dfs(next);
        }

        visited[cur] = false;
        finished[cur] = true;

    }
}