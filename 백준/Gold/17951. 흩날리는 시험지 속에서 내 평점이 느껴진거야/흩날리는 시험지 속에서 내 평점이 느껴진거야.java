import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());//시험지 수
    int k=Integer.parseInt(st.nextToken());//나눌 그룹 수
    
    int[] test=new int[n];
    st=new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) test[i]=Integer.parseInt(st.nextToken());

    int ans=binarySearch(n, k, test);

    System.out.println(ans);
    
  }

  private static int binarySearch(int n, int k, int[] test){
    int left= 0;
    int right=2000000;

    while(left <= right){
      int mid=(left+right)/2;

      int curGroupCnt=makeGroup(mid,n, k, test);

      if(curGroupCnt >= k){
        left=mid+1;
      }else{
        right=mid-1;
      }
    }

    return right;
  }

  private static int makeGroup(int mid, int n, int k, int[] test){
    int sum=0;
    int groupCnt=0;
    
    for(int i=0;i<n;i++){
      sum+=test[i];

      if(sum >= mid){
        groupCnt++;
        sum=0;
      }
    }

    return groupCnt;
    
  }
}