import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr =new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());

            int cnt = upperBound(b, n, arr) - lowerBound(a,n, arr);
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static int lowerBound(int target, int n, int[] arr){
        int left =0;
        int right = n-1;

        int minIdx = n;

        while(left <= right){
            int mid = (left+right)/2;

            if(arr[mid] >= target){
                right = mid-1;
                minIdx=Math.min(minIdx, mid);
            }else left = mid+1;
        }
        return minIdx;
    }

    private static int upperBound(int target, int n, int[] arr){
        int left =0;
        int right = n-1;

        int minIdx = n;

        while(left <= right){
            int mid = (left+right)/2;

            if(arr[mid] > target){
                right = mid-1;
                minIdx=Math.min(minIdx, mid);
            }else left = mid+1;
        }

        return minIdx;
    }


}