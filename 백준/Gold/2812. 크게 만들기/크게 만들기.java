import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());

    char[] num=br.readLine().toCharArray();

    Deque<Character> stackDelete= new ArrayDeque<>();
    
    for(int i=0; i<n; i++){
      while(k>0 && !stackDelete.isEmpty() && num[i] > stackDelete.peek()){
        stackDelete.pop();
        k--;
      }
      
      stackDelete.push(num[i]);
    }
    
    while(k -- >0) stackDelete.pop();

    StringBuilder sb=new StringBuilder();
    while(!stackDelete.isEmpty()){
     sb.append(stackDelete.pop());
    }

    System.out.println(sb.reverse());
  }
}