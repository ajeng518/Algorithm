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

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            int target = Integer.parseInt(st.nextToken());
            int ans = LowerBound(target, n, m, arr);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static int LowerBound(int target, int n, int m, int[] arr){
        int left =0;
        int right = n-1;

        int minIdx = n-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(arr[mid] >= target){
                right = mid-1;
                minIdx=Math.min(minIdx, mid);
            }else left = mid+1;
        }
        if(target != arr[minIdx]) return -1;
        return minIdx+1;
    }
}