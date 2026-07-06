import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        System.out.println(binarySearch(n, k));
    }

    private static long binarySearch(long n, long k){
        long left=1;
        long right=n*n;
        long ans=n*n;

        while(left <= right){
            long mid=(left+right)/2;

            long cur=0;
            for(int i=1; i<=n; i++){
                cur+=Math.min(n, mid/i);
            }

            if(cur >= k){
                right=mid-1;
                ans=Math.min(ans, mid);
            }else{
                left=mid+1;
            }
        }

        return ans;
    }
}