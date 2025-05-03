import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int n =Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2)-> o2-o1);
        PriorityQueue<Integer> minQ = new PriorityQueue<>((o1, o2)-> o1-o2);

        for(int i =0;i<n;i++){
            int cur = Integer.parseInt(br.readLine());

            if(maxQ.size()==minQ.size())
                maxQ.add(cur);
            else minQ.add(cur);

            if(!maxQ.isEmpty() && !minQ.isEmpty()){
                if(maxQ.peek() > minQ.peek()){
                    int temp=maxQ.poll();
                    maxQ.add(minQ.poll());
                    minQ.add(temp);
                }
            }
            sb.append(maxQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}