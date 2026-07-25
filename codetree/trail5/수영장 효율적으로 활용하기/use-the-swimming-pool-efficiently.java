import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] time;
    static final int MAX_TIME=1_000_000_000;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        time= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            time[i]=Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left = 1;
        int right = MAX_TIME;

        int ans = MAX_TIME;

        while(left <= right){
            int mid = (left + right) / 2;


            if(isPossible(mid)){
                right = mid - 1;
                ans = Math.min(ans, mid);
            }else left = mid + 1; 
        }

        return ans;
    }

    private static boolean isPossible(int mid){
        int t = 0;
        int idx=0;

        for(int i=0; i< n; i++){
            if(time[i]> mid) return false;

            if(t+time[i] > mid){
                idx++;
                t=0;
            }

            t += time[i];
        }

        return idx < m;
    }
}