import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX =Integer.MAX_VALUE;
    static int MIN=Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int right = Integer.MIN_VALUE;
        int[] arr = new int[n];
        int[] sub = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }


        System.out.println(BSearch(0, right, m, arr));
    }

    static int BSearch(int left, int right, int m, int[] arr) {
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (chkGroup(mid, arr) <= m) {
                right = mid;
            } else left = mid + 1;
        }
        return right;
    }

    static int chkGroup(int mid, int[] arr) {
        int cnt =1;
        int max =MIN;
        int min=MAX;

        for(int i=0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(max- min>mid){
                cnt++;
                max=MIN;
                min=MAX;
                i--;
            }
        }

        return cnt;
    }

}