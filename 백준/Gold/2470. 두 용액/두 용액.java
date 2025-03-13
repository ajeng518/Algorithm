import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb= new StringBuilder();

    int n=Integer.parseInt(br.readLine());

    int[] num=new int[n];
    st=new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      num[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(num);//정렬

    int[] ans=binarySearch(n, num);

    sb.append(ans[0]).append(" ").append(ans[1]);
    System.out.println(sb);
    
  }

  private static int[] binarySearch(int n, int[] num){
    int left=0;
    int right=n-1;
    int min=Integer.MAX_VALUE;

    int ansL=0;
    int ansR=0;

    while(left<right){
      int sum=num[left]+num[right];

      if(min > Math.abs(sum)){
        ansL=num[left];
        ansR=num[right];
        min=Math.abs(sum);
      }

      if(sum>0) right--;
      else left ++;
    }

    return new int[]{ansL, ansR};
  }
}