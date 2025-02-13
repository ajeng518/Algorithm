import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) input[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(input[0]);

        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) < input[i])
                list.add(input[i]);

            else {
                int idx = binarySearch(list, input[i]);
                list.set(idx, input[i]);
            }
        }
        System.out.println(list.size());
    }

    private static int binarySearch(List<Integer> list, int root) {
        int left = 0;
        int right = list.size() - 1;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (list.get(mid) < root) left = mid + 1;
            else if (list.get(mid) >= root) right = mid - 1;

        }

        return left;
    }
}