import java.io.*;
import java.util.*;

class Solution {
    static class Disk implements Comparable<Disk>{
        int idx;
        int requestSeq;
        int duringTime;
        
        Disk(int idx, int requestSeq, int duringTime){
            this.idx = idx;
            this.requestSeq = requestSeq;
            this.duringTime = duringTime;
        }
        
        @Override
        public int compareTo(Disk o){
            
            if(this.duringTime == o.duringTime){
                if(this.requestSeq == o.requestSeq)
                        return this.idx - o.idx;
                
                return this.requestSeq-o.requestSeq;
            }
            return this.duringTime-o.duringTime;
        }
    }
    
    static int[] returnTime;
    static PriorityQueue<Disk> pq;
    static int now, index;
    
    public int solution(int[][] jobs) {
        int answer = 0;
        now =0;
        index=0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        returnTime = new int[jobs.length];
        pq = new PriorityQueue<>();
        
        while(index < jobs.length || !pq.isEmpty()){
            inputWaitQ(jobs);
            
            if(!pq.isEmpty()){
                doJob();
            } else {
                now = jobs[index][0];
            }
        }
        
        
        for(int i=0;i<jobs.length;i++){
            answer+=returnTime[i];
        }
        
        return answer/jobs.length;
    }
    
    private static void inputWaitQ(int[][]jobs){
        int i=0;
        for(i =index; i<jobs.length; i++){
            if(now >= jobs[i][0]){
                pq.add(new Disk(i, jobs[i][0], jobs[i][1]));
            }else break;
        }
        
        index = i;
    }
    
    private static void doJob(){
        Disk cur =pq.poll();
            
        int curReturnTime = (cur.duringTime + now) - cur.requestSeq;
        returnTime[cur.idx]=curReturnTime;
        
        // System.out.println("idx: "+cur.idx+" / returnTime: "+curReturnTime);

        now += cur.duringTime;
    }
}