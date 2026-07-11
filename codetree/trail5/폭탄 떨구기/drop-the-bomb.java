import java.io.*;
import java.util.*;

public class Main {
    static int n, k, max;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        max=0;

        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(br.readLine());
            max=Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left = 1;
        int right = max*2;

        int ans = max*2;

        while(left <= right){
            int mid = (left+right)/2;


            if(dropBomb(mid)){
                right = mid-1;
                ans=Math.min(ans, mid);
            }else left=mid+1;
        }

        return ans;
    }

    private static boolean dropBomb(int mid){
        int cnt=0;
        int deleteCnt=0;
        int cur = arr[0] + mid;
        int idx=0;

        while(deleteCnt < n){
            int left=cur;
            int right = cur + mid;

            for(int i=idx; i<n;i++){
                if(arr[i] > right ) {
                    idx=i;
                    break;
                }
                
                deleteCnt++;
            }

            cnt++;
            cur=arr[idx] + mid;
        }

        return cnt <= k;
    }
}