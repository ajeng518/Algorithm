import java.util.*;
import java.io.*;

public class Main {
    static int n, k, l;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        l = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left =1;
        int right=n;
        int ans=0;

        while(left <= right){
            int mid = (left+right)/2;

            if(isPossible(mid)){
                left=mid+1;
                ans=Math.max(ans, mid);
            }else right=mid-1;
        }

        return ans;
    }

    private static boolean isPossible(int h){
        long cnt = 0;

        for(int i = n-h; i < n; i++){
            if(arr[i] < h)
            cnt += h - arr[i];
        }

        return cnt <= (long) k*l && arr[n-h] + k >= h;
    }
}