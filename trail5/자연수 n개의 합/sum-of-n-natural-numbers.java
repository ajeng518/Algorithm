import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        
        System.out.println(binarySearch(n));
    }

    private static long binarySearch(long target){
        long left=1;
        long right=(long)Math.sqrt(target*2)+1;

        long maxNum=1;

        while(left<=right){
            long mid = (left+right)/2;

            if(mid*(mid+1)/2 <= target){
                left =mid+1;
                maxNum=Math.max(maxNum, mid);
            }else right = mid-1;
        }

        return maxNum;
    }
}