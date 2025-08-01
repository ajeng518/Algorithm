import java.util.*;

class Solution {
    static int[] num;
    static int tar,cnt, size;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        size=numbers.length;
        num = numbers.clone();
        tar = target;
        cnt=0;
        
        re(0, 0);
        
        return cnt;
    }
    
    private static void re(int sum, int idx){
        if(idx ==size){
            if(sum == tar) cnt++;
            
            return;
        }
        
        re(sum+num[idx], idx+1);
        re(sum-num[idx], idx+1);
    }
}