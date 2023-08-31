import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> temp;
    static int N, people[], team[], min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());//총 구역 개수
        people = new int[N+1];//구역마다의 인구수
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());//구역 인구 맵핑
        }
        list.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {//연결리스트 확인
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            temp = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            List<Integer> tmp = new ArrayList<>(temp);
            list.add(tmp);
        }

        List<Integer> A = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) {
            cancheck(A, 1, N, i);
        }
        if(min==Integer.MAX_VALUE){
            min=-1;
        }

        System.out.println(min);

    }

    private static void cancheck(List<Integer> A, int start, int n, int r) {
        if (r == 0) {
            makeCanTeam(A);
            return;
        }

        for (int i = start; i <= n; i++) {
            A.add(i);
            cancheck(A, i + 1, n, r - 1);
            A.remove(A.size() - 1);
        }
    }

    private static void makeCanTeam(List<Integer> A) {
        if (!CanConnect(A.get(0), A, A.size())) {
            return;
        }

        List<Integer> B = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (A.contains(i)) continue;
            B.add(i);
        }

        if (!CanConnect(B.get(0), B, B.size())) {
            return;
        }

        min = Math.min(min, plusPeo(A, B));
    }

    private static boolean CanConnect(int x, List<Integer> arr, int size) {
        boolean[] visited = new boolean[N + 1];
        visited[x] = true;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(x);

        int count = 1;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                if (!visited[list.get(now).get(i)] && arr.contains(list.get(now).get(i))) {
                    visited[list.get(now).get(i)] = true;
                    count++;
                    q.offer(list.get(now).get(i));
                }
            }
        }
        if (count == size) {
            return true;
        }
        return false;
    }

    private static int plusPeo(List<Integer> A, List<Integer> B) {
        int aSum = 0;
        int bSum = 0;

        for (int i = 0; i < A.size(); i++) {
            aSum += people[A.get(i)];
        }
        for (int i = 0; i < B.size(); i++) {
            bSum += people[B.get(i)];
        }
        return aSum > bSum ? aSum - bSum : bSum - aSum;
    }
}
