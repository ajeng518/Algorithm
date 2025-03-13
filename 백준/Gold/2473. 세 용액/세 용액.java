import java.util.*;
import java.io.*;

public class Main {
  static long min;
  static long[] ans;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb= new StringBuilder();

    int n=Integer.parseInt(br.readLine());

    long[] num=new long[n];
    
    st=new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      num[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(num);//정렬

    min=4000000000L;
    ans=new long[3];
    
    for(int i=0; i < n-2; i++){
      binarySearch(n, num, i);
    }

    Arrays.sort(ans);
    for(int i=0; i<3; i++) sb.append(ans[i]).append(" ");
    System.out.println(sb);
    
  }

  private static void binarySearch(int n, long[] num, int now){
    int left = now+1;
    int right = n-1;
    
    while(left < right){
      long sum=num[left]+num[right]+num[now];

      if(min > Math.abs(sum)){
        ans[0]=num[left];
        ans[1]=num[right];
        ans[2]=num[now];
        min=Math.abs(sum);
      }

      if(sum > 0) right--;
      else left++;
    }
  }
}