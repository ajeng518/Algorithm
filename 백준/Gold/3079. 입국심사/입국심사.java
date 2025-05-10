import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long max=0;
        
        int[] arr=new int[n];
        
        for(int i =0; i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            max=Math.max(max, arr[i]);
        }

        Arrays.sort(arr);
        
        System.out.println(bSearch(n, m, max, arr));
    }

    private static long bSearch(int n, long m, long max, int[] arr){
        long low = 0;
        long high = m*max;

        while(low <= high){
            long mid=(low+high)/2;

            long sum=0;
            for(int i =0;i<n;i++){
                long cnt=mid/arr[i];
                
                if(sum>=m){
                   break;
                }
                sum+=cnt;
            }

            if(sum>=m){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
}