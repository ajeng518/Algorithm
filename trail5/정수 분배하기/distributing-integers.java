import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        System.out.println(binarySearch(n, m, arr));
    }

    private static int binarySearch(int n, int m, int[] arr){
        int left =1;
        int right=100000;

        int max=0;

        while(left <= right){
            int mid = (left+right)/2;
            int cnt =0;
            for(int i=0;i<n;i++){
                cnt+=(arr[i]/mid);
            }

            if(cnt >= m){
                left=mid+1;
                max=Math.max(max, mid);
            }else right=mid-1;
        }

        return max;

    }
}