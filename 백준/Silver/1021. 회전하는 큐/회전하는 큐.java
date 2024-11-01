import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int cnt = 0;

        for (int idx : num) {
            while (true) {
                if (q.peek() == idx) {
                    q.poll();
                    break;
                } else {
                    if (q.indexOf(idx) < (double) q.size() / 2) {
                        while (q.peek() != idx) {
                            q.offerLast(q.pollFirst());

                            cnt++;
                        }
                    } else {
                        while (q.peek() != idx) {
                            q.offerFirst(q.pollLast());

                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}