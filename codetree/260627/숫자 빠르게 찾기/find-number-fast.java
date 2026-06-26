import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(binarySearch(num, n, arr));
        }
    }

    private static int binarySearch(int num, int n, int[] arr){
        int left =0;
        int right=n-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(num == arr[mid]) return mid+1;

            if(num >arr[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return -1;
    }
}