import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] num;
    static boolean[] chk;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        num = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        //깊이 탐색
        chk = new boolean[n + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            chk[i] = true;
            findSame(i, i);
            chk[i] = false;
        }


        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (int ans : list) {
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static void findSame(int start, int value) {
        if (!chk[num[start]]) {
            chk[num[start]] = true;
            findSame(num[start], value);
            chk[num[start]] = false;
        }

        if (num[start] == value) list.add(value);
    }
}