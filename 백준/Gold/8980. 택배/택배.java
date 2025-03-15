import java.util.*;
import java.io.*;

public class Main {
  static class Box implements Comparable<Box>{
    int send;
    int receive;
    int cnt;

    Box(int send, int receive, int cnt){
      this.send=send;
      this.receive=receive;
      this.cnt=cnt;
    }

    @Override
    public int compareTo(Box o){
      if(this.receive == o.receive){
        return this.send- o.send;
      }
      return this.receive-o.receive;
      
      
    }

   @Override
    public String toString(){
      return String.format("send: %d, reiceve: %d, cnt: %d", this.send, this.receive, this.cnt);
    }
    
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());//마을 수
    int c=Integer.parseInt(st.nextToken());//트럭 용량

    int m =Integer.parseInt(br.readLine());//택배 수

    Box[] boxList=new Box[m];
    for(int i=0;i<m;i++){
      st=new StringTokenizer(br.readLine());

       int sender=Integer.parseInt(st.nextToken());
       int receiver=Integer.parseInt(st.nextToken());
       int boxCnt=Integer.parseInt(st.nextToken());
      boxList[i]=new Box(sender, receiver, boxCnt);
    }
    
    Arrays.sort(boxList);
    int allCnt=0;
    
    int[] weight=new int[n+1];
    for(int i=1;i<n;i++) weight[i]=c;
    
    for(int i =0; i<m; i++){
      Box cur = boxList[i];

      int maxSize = Integer.MAX_VALUE;

      for(int j=cur.send; j<cur.receive; j++)
        maxSize=Math.min(maxSize, weight[j]);

      if(maxSize>= cur.cnt){
        for(int j =cur.send; j<cur.receive; j++)
          weight[j]-=cur.cnt;
        allCnt+=cur.cnt;
      }else {
        for(int j =cur.send; j<cur.receive; j++)
          weight[j]-=maxSize;
        allCnt+=maxSize;
      }
    }

    System.out.println(allCnt);
  }
}