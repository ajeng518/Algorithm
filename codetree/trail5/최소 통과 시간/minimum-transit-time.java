import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(n, m, arr));
    }

    private static long binarySearch(int n, int m, int[] arr){
        long left=1;
        long right=(long)1e14;
        long ans=(long)1e14;

        while(left <= right){
            long mid = (left+right)/2;
            long cnt=0;
            int idx=0;

            for(int i=0; i<m; i++){
                cnt+=mid/arr[i];
            }

            if(cnt >= n){
                right=mid-1;
                ans=Math.min(ans, mid);

            }else{
                left=mid+1;
            }
        }

        return ans;
    }
}