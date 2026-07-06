import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(n));
    }

    private static long binarySearch(int target){
        long left=1;
        long right=Integer.MAX_VALUE;;

        long ans=Integer.MAX_VALUE;

        while(left<= right){
            long mid = (left+right)/2;

            if(getCntOfNum(mid) >= target){
                right=mid-1;
                ans=Math.min(ans, mid);
            }
            else left=mid+1;
        }
        return ans;
    }

    private static long getCntOfNum(long mid){
        long mooCnt=mid/3+mid/5-mid/15;

        return mid-mooCnt;
    }

    
}