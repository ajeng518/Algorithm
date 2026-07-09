import java.io.*;
import java.util.*;

public class Main {
    static int n, tMax;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tMax = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left=1;
        int right=n;
        int ans=n;

        while(left<=right){
            int mid = (left+right)/2;

            if(isPossible(mid)){
                right=mid-1;
                ans=Math.min(ans, mid);
            }else left=mid+1;
        }

        return ans;
    }

    private static boolean isPossible(int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for(int i=0;i<k; i++){
            pq.add(arr[i]);
        }

        for(int i=k; i<n;i++){
            int curTime =pq.poll();

            pq.add(curTime+arr[i]);
        }

        int endTime=0;
        while(!pq.isEmpty()){
            endTime = Math.max(endTime, pq.poll());
        }

        return endTime <= tMax;
    }
}