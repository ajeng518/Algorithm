import java.io.*;
import java.util.*;

public class Main {
    static int n, m, c, max;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        max=0;
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
            max=Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left=0;
        int right=(int)1e9;

        int ans=(int)1e9;

        while(left<= right){
            int mid=(left + right)/2;

            if(isPossible(mid)){
                right=mid - 1;
                ans=Math.min(mid, ans);
            }else left=mid+1;
        }

        return ans;
    }

    private static boolean isPossible(int mid){
        int busCnt=1;
        int curBus=arr[0];
        int curIdx=0;


        for(int i=1; i<n; i++){
            if(arr[i]-curBus > mid || i - curIdx + 1 > c){
                busCnt++;
                curBus=arr[i];
                curIdx=i;
            }
        }

        return busCnt <=m;
    }
}