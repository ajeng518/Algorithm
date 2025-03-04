import java.util.*;
import java.io.*;

public class Main {
  static StringBuilder sb;
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    sb=new StringBuilder();
    
    int n=Integer.parseInt(br.readLine());
    
    re(n-1, 2);
    re(n-1, 3);
    re(n-1, 5);
    re(n-1, 7);

    System.out.println(sb);
    
  }

  private static void re(int n, int num){
    if(n==0){
      sb.append(num).append("\n");
      return;
    }

    for(int i=1;i <= 9; i+=2){
      if(chk(num*10+i))
        re(n-1, num*10+i);
    }
  }

  private static boolean chk(int num){
    for(int i=(int)Math.sqrt(num); i> 1; i--){
      if(num % i==0) return false;
    }
    return true;
  }
}