import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str=br.readLine();
    String bomb=br.readLine();

    int strLen=str.length();
    int bombLen=bomb.length();

    StringBuilder sb=new StringBuilder();
    for(int i=0;i<strLen; i++){
      char cur=str.charAt(i);
      sb.append(cur);

      if(bombLen>sb.length()) continue;
      
      String newStr= sb.substring(sb.length()-bombLen).toString();
      if(newStr.equals(bomb)){
        sb.delete(sb.length()-bombLen, sb.length());
      }
      
    }
    if(sb.length()==0) System.out.println("FRULA");
    else System.out.println(sb);
  }
}