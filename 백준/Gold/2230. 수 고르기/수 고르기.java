import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);
        int left = 0;
        int right =1;
        int min = 2_000_000_001;

        while(right < n){
            int diff = num[right]-num[left];
            if(diff < m) right++;
            else{
                if(diff < min) min =diff;
                if(left+1==right) right++;
                left++;
            }
        }

        System.out.println(min);
  }
}