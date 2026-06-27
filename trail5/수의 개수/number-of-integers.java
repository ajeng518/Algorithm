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

        for(int i=0;i<m;i++){
            int target = Integer.parseInt(br.readLine());
            sb.append(upperBound(target, n, m, arr) - lowerBound(target, n, m, arr)).append("\n");
        }

        System.out.println(sb);
    }

    private static int lowerBound(int target, int n, int m, int[] arr){
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

    private static int upperBound(int target, int n, int m, int[] arr){
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