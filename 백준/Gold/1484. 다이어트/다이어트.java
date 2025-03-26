import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb=new StringBuilder();

    int g= Integer.parseInt(br.readLine());

    long left =1;
    long right =2;
    Set<Long> ans=new HashSet<>();

    while(right< 100_000){
      long cur = (right - left)*(right + left);

      if(cur > g) left ++;
      else if(cur < g) right++;
      else{
        sb.append(right).append("\n");
        right++;
      }
    }

    if(sb.length()==0) sb.append(-1);

    System.out.println(sb);
    
  }
}