import java.util.*;
import java.io.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        char[] numC = number.toCharArray();
        int size = numC.length;
        int len = number.length()-k;
        
        PriorityQueue<int[]> pq =new PriorityQueue<>((a1, a2)-> {
            if(a2[1] == a1[1]) return a1[0]-a2[0];
            return a2[1]-a1[1];
        });
        
        for(int i=0;i<=k; i++){
            int num = numC[i]-'0';
            pq.add(new int[]{i, num});
        }
        int cur=1;
        int last=-1;
        int next = k+1;
        
        while(!pq.isEmpty() && cur <= len){
            int[] most=new int[2];
            int max=-1;
            
            most=pq.poll();
            while(!pq.isEmpty() && most[0] < last){
                most=pq.poll();
            }
            
            sb.append(most[1]);
            last=most[0];
            cur++;
            
            if(next>=size) continue;
            
            pq.add(new int[]{next, numC[next]-'0'});
            next++;
        }
        
        return sb.toString();
    }
}