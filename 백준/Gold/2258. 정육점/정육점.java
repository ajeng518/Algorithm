import java.util.*;
import java.io.*;

public class Main {
  static class Meat implements Comparable<Meat>{
    int weight;
    int cost;

    Meat(int weight, int cost){
      this.weight=weight;
      this.cost=cost;
    }

    public int compareTo(Meat o){
      if(this.cost == o.cost){      
        return o.weight-this.weight;
      }
      
      return this.cost - o.cost;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());//덩어리 수
    int m=Integer.parseInt(st.nextToken());//필요한 양

    PriorityQueue<Meat> pq=new PriorityQueue<>();
    for(int i=0;i<n;i++){
      st=new StringTokenizer(br.readLine());
      
      int weight=Integer.parseInt(st.nextToken());
      int cost=Integer.parseInt(st.nextToken());

      pq.add(new Meat(weight, cost));
    }

    Meat first=pq.poll();
    int minCost=first.cost;
    int nowWeight=first.weight;
    
    int ansCost=minCost;
    int maxWeight=nowWeight;
    int ans=Integer.MAX_VALUE;
    boolean isPossible=false;
    
    while(!pq.isEmpty()){
      Meat cur = pq.poll();
      
      if(cur.cost == minCost)
       ansCost += cur.cost;
      else{
        ansCost = cur.cost;
        minCost=cur.cost;
      }
      
      maxWeight += cur.weight;
      
      if(maxWeight >= m){
        isPossible=true;
        ans=Math.min(ansCost, ans);
      }
    }
    
    System.out.println(ans=isPossible?ans:-1); 
  }
}