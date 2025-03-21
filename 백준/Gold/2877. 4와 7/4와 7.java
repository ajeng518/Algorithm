import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int k=Integer.parseInt(br.readLine());

    String ans = makeNum(k+1);
    System.out.println(ans);
  }

  private static String makeNum(int k){
    StringBuilder sb=new StringBuilder();

    int num=0;
    while(k != 0){
      num=k%2;
      sb.append(num);
      k/=2;
    }

    StringBuilder ans = new StringBuilder();
    for(int i=sb.length()-2;i>=0;i --){
      if(sb.charAt(i)=='0') ans.append(4);
      else ans.append(7);
    }

      
    return ans.toString();
  }
}