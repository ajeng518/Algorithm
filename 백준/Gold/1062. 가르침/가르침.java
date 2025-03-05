import java.util.*;
import java.io.*;

public class Main {
  static int max, n, k;
  static int[] word;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n=Integer.parseInt(st.nextToken());
    k=Integer.parseInt(st.nextToken());
    max=0;

    if(k < 5){
      System.out.println(0);
      System.exit(0);
    }
    
    if(k == 26){
      System.out.println(n);
      System.exit(0);
    }

    int know = init();
    k -= 5;
    
    word=new int[n];
    int all = 0;
    
    for(int i = 0; i < n; i++){
      String input = br.readLine();

      word[i] = know;
      
      for(int j = 4; j < input.length() - 4; j++)
        word[i] |= 1 << input.charAt(j)-96;

      all |= word[i];
    }

    all ^= know;
    
    if(Integer.bitCount(all) < k)
      max = n;
    else
      re(all, 2, k, know);
    
    System.out.println(max);
  }

  private static void re(int all, int idx, int k, int know){
    if(k==0){
      //읽을 수 있는 단어 검사
      max=Math.max(chkReadWord(know), max);
      return;
    }
    
    for(int i = idx; i<=26; i++){
      if((all & (1<<i) ) == 0) continue;

      re(all, i+1, k-1, (know | (1 << i)));
    }
  }

  private static int init(){
    String base="acint";
    int know=0;
    
    for(int i=0; i < 5; i++){
      know = (know|(1<<(base.charAt(i)-96)));
    }

    return know;
  }

  private static int chkReadWord(int know){
    int cnt=0;
    
    for(int i = 0; i < n; i++){
      if(word[i] == (word[i] & know)) cnt++;
    }
    
    return cnt;
  }
}