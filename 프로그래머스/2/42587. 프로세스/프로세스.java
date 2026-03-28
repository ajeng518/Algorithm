import java.io.*;
import java.util.*;

class Solution {
    static class Process implements Comparable<Process>{
        int idx;
        int priority;
        
        Process(int idx, int priority){
            this.idx=idx;
            this.priority=priority;
        }
        
        @Override
        public int compareTo(Process o){
            return o.priority - this.priority;
        }
    }
    
    public int solution(int[] priorities, int location) {        
        List<Integer> pq = new ArrayList<>();
        Deque<Process> q = new ArrayDeque<>();
        
        for(int i=0;i<priorities.length; i++){
            q.offer(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        Collections.sort(pq, Collections.reverseOrder());
        int pqCnt=0;
        int cnt=0;
        
        while(!q.isEmpty()){
            Process cur = q.poll();
            
            if(cur.priority == pq.get(pqCnt)){
                cnt++;
                if(cur.idx ==location){
                    return cnt;
                }
                
                pqCnt++;
            }else q.add(cur);
        }
        
        return cnt;
    }
}