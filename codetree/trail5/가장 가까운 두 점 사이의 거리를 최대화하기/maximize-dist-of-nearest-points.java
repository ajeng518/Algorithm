import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2)-> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left=1;
        int right=1_000_000_000;

        int max=0;

        while(left<=right){
            int mid=(left+right)/2;

            if(isPossible(mid)){
                left=mid+1;
                max=Math.max(max, mid);
            }else right=mid-1;
        }

        return max;
    }

    private static boolean isPossible(int mid){
        int last=arr[0][0];
        int diff=1_000_000_000;
        boolean change=false;

        for(int i=1;i<n;i++){
            int start=arr[i][0];
            int end = arr[i][1];

            if(last+mid > end) return false;
            last=Math.max(last+mid, start);
        }

        return true;
    }
}