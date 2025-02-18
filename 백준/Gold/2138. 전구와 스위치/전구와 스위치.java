import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    int n=Integer.parseInt(br.readLine());
    
    boolean[] light=new boolean[n];
    boolean[] answer=new boolean[n];
    
    makeArr(br.readLine(), light);
    makeArr(br.readLine(), answer);

    boolean[] case1=new boolean[n];
    boolean[] case2=new boolean[n];
    
    int cnt1=1;
    int cnt2=0;
    int ans=-1;

    for(int i=0; i<n; i++){
      if(i <= 1){
        case1[i] = !light[i];
        case2[i] = light[i];
      }else{
        case1[i] = light[i];
        case2[i] = light[i];
      }
    }

    for(int i=1; i<n; i++){
      if(case1[i-1]!=answer[i-1]){
        switchOn(i, case1);
        cnt1++;
      }
      if(case2[i-1]!=answer[i-1]){
        switchOn(i, case2);
        cnt2++;
      }

      if(Arrays.equals(case1, answer)){
        if(Arrays.equals(case1, case2)){
          ans=Math.min(cnt1, cnt2);
        }else ans=cnt1;
        break;
      }else if(Arrays.equals(case2, answer)){
        ans=cnt2;
        break;
      }
    }
    
    System.out.println(ans);
    
  }

  private static void makeArr(String input, boolean[] arr){
    for(int i=0;i<arr.length;i++){
      char cur = input.charAt(i);

      if(cur=='0') arr[i]=false;
      else arr[i]=true;
    }
  }

  private static void switchOn(int idx, boolean[] arr){
    arr[idx-1]=!arr[idx-1];
    arr[idx]=!arr[idx];

    if(idx<arr.length-1)
      arr[idx+1]=!arr[idx+1];
  }
  
}