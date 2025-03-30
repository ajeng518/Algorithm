import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    
        int[] num=new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(num[0]);

        for(int i=1; i<n;i++){
            if(list.get(list.size()-1) < num[i])
                list.add(num[i]);
            else{
                int idx = binarySearch(list, num[i]);
                list.set(idx, num[i]);
            }
        }

        System.out.println(list.size());
  }

    private static int binarySearch(List<Integer> list, int root){
        int left = 0;
        int right = list.size()-1;
        int mid=-1;

        while(left<=right){
            mid=(left+right)/2;

            if(list.get(mid)<root) left=mid+1;
            else right=mid-1;
        }

        return left;
    }
}