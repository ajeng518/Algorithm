import java.util.*;
import java.io.*;

class Solution {
    static class NumInfo{
        int idx;
        int num;
        
        NumInfo(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
    
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        int idx=1;
        PriorityQueue<NumInfo> increaseQ = new PriorityQueue<>((a1, a2) -> a1.num - a2.num);
        PriorityQueue<NumInfo> decreaseQ = new PriorityQueue<>((a1, a2)-> a2.num - a1.num);
        boolean[] dead = new boolean [operations.length+1];
        
        for(int i=0;i<operations.length;i++){
            String[] cur = operations[i].split(" ");
            
            if(cur[0].equals("I")){
                int num = Integer.parseInt(cur[1]);
                increaseQ.offer(new NumInfo(idx, num));
                decreaseQ.offer(new NumInfo(idx, num));
                idx++;
                
            }else{
                if(increaseQ.isEmpty() || decreaseQ.isEmpty()) continue;
                
                int num = Integer.parseInt(cur[1]);
                
                if(num == 1){//최댓값
                    NumInfo now = decreaseQ.poll();
                    while(!decreaseQ.isEmpty() && dead[now.idx]){
                        now = decreaseQ.poll();
                    }
                    dead[now.idx]=true;
                }else{//최솟값
                    NumInfo now = increaseQ.poll();
                    while(!increaseQ.isEmpty() && dead[now.idx]){
                        now = increaseQ.poll();
                    }
                    dead[now.idx]=true;
                }
            }
        }
        
        if(!decreaseQ.isEmpty()){
            NumInfo now = decreaseQ.poll();
            while((!decreaseQ.isEmpty()) && dead[now.idx]){
                now = decreaseQ.poll();
            } 
            decreaseQ.offer(now);
        }
        
        if(!increaseQ.isEmpty()){
            NumInfo now = increaseQ.poll();
            while(!increaseQ.isEmpty() && dead[now.idx]){
                now = increaseQ.poll();
            } 
            increaseQ.offer(now);
        }
        
        if(increaseQ.isEmpty() || decreaseQ.isEmpty()) return answer;
        else{
            answer[0]=decreaseQ.poll().num;
            answer[1]=increaseQ.poll().num;
        }
        
        return answer;
    }
}