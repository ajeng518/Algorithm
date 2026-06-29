import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long a=Long.parseLong(st.nextToken());
        long b =Long.parseLong(st.nextToken());
        long min=n;
        long max=1;
        for(long i=a; i<=b; i++){
            long cur=customBound(i, n);
            min=Math.min(min, cur);
            max=Math.max(max, cur);
        }

        sb.append(min).append(" ").append(max).append("\n");

        System.out.print(sb);
    }


    private static long customBound(long target, long n){
        long left =1;
        long right = n;

        long cnt=0;

        while(left <= right){
            long mid = (left+right)/2;
            cnt++;

            if(mid == target) break;

            if(mid < target){
                left = mid+1;
            }else right = mid-1;
        }

        return cnt;
    }


}