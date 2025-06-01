import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<int[]>q=new ArrayDeque<>();
        int all = progresses.length;
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<progresses.length;i++){
            q.add(new int[]{progresses[i], speeds[i], i});
        }
        
        int day=0;
        while(!q.isEmpty()){
            day++;
            int cnt=0;
            int size = q.size();
           int[] value =q.poll();
            
            if(value[0]+(value[1]*day)<100) {
                q.push(value);
                continue;
            }
            cnt++;

            for(int i=1;i<size;i++){
               int[] values = q.poll();
                if(values[0]+(values[1]*day)<100){
                    q.push(values);
                    break;
                }
                cnt++;
            }
            if(cnt==0)continue;
            ans.add(cnt);
        }
        
        int[] answer= ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}//