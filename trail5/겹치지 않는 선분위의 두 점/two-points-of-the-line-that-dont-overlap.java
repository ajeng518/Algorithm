import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long[][] arr;
    static final long MAX_NUM = 1000000000000000000L;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[m][2];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            return Long.compare(o1[0], o2[0]);
        });

        System.out.println(binarySearch(n, m, arr));
    }

    private static long binarySearch(int n, int m, long[][] arr){
        long left=1;
        long right=MAX_NUM;
        long ans=0;

        while(left<=right){
            long mid = (left+right)/2;
            
            if(isPossible(mid)){
                left=mid+1;
                ans=mid;
            }else right=mid-1;
        }

        return ans;
    }

    private static boolean isPossible(long dist){
        long cnt=0;
        long last=-MAX_NUM;

        for(int i=0; i<m; i++){
            long start = arr[i][0];
            long end = arr[i][1];
            
            while(last +dist <= end){
                last=Math.max(start, last+dist);
                cnt++;
                
                if(cnt >=n) return true;
            }
        }
        
        return false;
    }
}