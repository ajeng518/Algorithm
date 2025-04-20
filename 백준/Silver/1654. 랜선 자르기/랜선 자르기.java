import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int k =Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long max=0;

        int[] line =new int[k];
        for(int i=0;i<k;i++){
            if((line[i]=Integer.parseInt(br.readLine())) > max){
                max=line[i];
            }
        }

        System.out.println(binarySearch(k, n, max, line));
    }

    private static long binarySearch(int k, int n, long max, int[] line){
        long left= 0;
        long right=max+1;

        while(left < right){
            long mid=(left+right)/2;

            long cnt=0;
            for(int i = 0; i<k ;i++){
                cnt+=(line[i]/mid);
            }

            if(cnt<n) right=mid;
            else left=mid+1;
        }

        return left-1;
    }
}