import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long[] tree, input;

    static long initTree(int idx, int start, int end) {
        if (start == end) return tree[idx] = input[start];

        int m = (start + end) / 2;
        long a = initTree(idx * 2, start, m);
        long b = initTree(idx * 2 + 1, m + 1, end);

        return tree[idx] = a + b;
    }

    static long updateTree(int idx, int start, int end, int targetIdx, long targetValue) {
        if (start > targetIdx || end < targetIdx) return tree[idx];

        if (start == end) return tree[idx] = targetValue;

        int m = (start + end) / 2;
        long a = updateTree(idx * 2, start, m, targetIdx, targetValue);
        long b = updateTree(idx * 2 + 1, m + 1, end, targetIdx, targetValue);

        return tree[idx] = a + b;
    }

    static long query(int idx, int start, int end, int testS, long testE) {
        if (start >= testS && testE >= end) return tree[idx];

        if (testS > end || testE < start) return 0;

        int m = (start + end) / 2;
        long a = query(idx * 2, start, m, testS, testE);
        long b = query(idx * 2 + 1, m + 1, end, testS, testE);

        return a + b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tree = new long[n * 4];

        input = new long[n];
        for (int i = 0; i < n; i++) {
            input[i] = Long.parseLong(br.readLine());
        }

        initTree(1, 0, n - 1);

        while (m != 0 || k != 0) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            if (flag == 1) {//수 변경

                updateTree(1, 0, n - 1, start-1, end);
                input[start - 1] = end;
                m--;
            } else {//구간합 구하기

                long ans = query(1, 0, n - 1, start-1, end-1);
                sb.append(ans).append("\n");
                k--;
            }
        }

        System.out.print(sb);
    }
}