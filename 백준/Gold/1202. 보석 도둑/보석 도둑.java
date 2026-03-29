import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n, k;//보석 개수
        long ans = 0;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] bag = new int[k];
        Jewel[] jewelList = new Jewel[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewelList[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewelList);

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        for (int i = 0, j=0; i < k; i++) {
            while(j<n){
                if (jewelList[j].m > bag[i])
                    break;
                pq.offer(jewelList[j++].v);
            }
            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);

    }

    static class Jewel implements Comparable<Jewel> {
        int m; //무게
        int v;//가치

        Jewel() {
        }

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o) {
            if (this.m == o.m) {
                return o.v - this.v;
            }
            return this.m - o.m;

        }
    }
}