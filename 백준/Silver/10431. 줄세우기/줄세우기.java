import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb=new StringBuilder();
    
    int size=20;

    int test=Integer.parseInt(br.readLine());
    
    while(test-->0){
      st = new StringTokenizer(br.readLine());
      
      int t = Integer.parseInt(st.nextToken());
      List<Integer> tall=new LinkedList<>();
      
      for(int i=0;i<size;i++) tall.add(Integer.parseInt(st.nextToken()));

      int left =size-2;
      int right=size-1;
      int cnt=0;
      boolean flag=false;
      
      while(right >0){
        int rightValue=tall.get(right);
        left=right-1;
        
        while(left>= 0 && tall.get(left) >= tall.get(right)){
          left--;
          flag=true;
        }
  
        if(flag){
          cnt += right-left-1;
          tall.remove(right);
          tall.add(left+1, rightValue);
          flag=false;
          right=size-1;
          left=right;
          continue;
        }
        right --;
      }
  
      sb.append(t).append(" ").append(cnt).append("\n");
    }

   System.out.println(sb);
  }
}