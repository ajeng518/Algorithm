import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch(n, m, arr));
    }

    private static int binarySearch(int n, int m, int[] arr){
        int left = 1;
        int right = 1_000_000_001;
        int diff=0;

        while(left <= right){
            int mid= (left+right)/2;

            int cnt=1;
            int last=arr[0];
            int curDiff=1_000_000_001;
            
            for(int i =1 ;i<n;i++){
                if(arr[i]-last < mid) continue;

                cnt++;
                curDiff=Math.min(curDiff, arr[i]-last);
                last=arr[i];
            }

            if(cnt >= m){
                left=mid+1;
                diff=Math.max(diff, curDiff);
            }else{
                right=mid-1;
            }
        }

        return diff;
    }
}