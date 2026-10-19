import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int total=0;
        for(int i=0; i<works.length;i++) total+=works[i];
        int loop = (int)Math.min(total, n);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }        
        
        for(int i=0; i<loop; i++){
            int max =pq.poll();
            pq.add(max-1);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer+=cur*cur;
        }
        
        return answer;
    }
}