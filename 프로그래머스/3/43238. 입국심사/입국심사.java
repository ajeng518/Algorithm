class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max=0;
        for(int i=0;i<times.length;i++){
            max=Math.max(max, times[i]);
        }
        
        long left =1;
        long right =n*max;
        
        while(left <= right){
            long mid = (left + right)/2;
            
            long cnt=0;
            for(int i=0;i<times.length;i++){
                cnt+=mid/times[i];
            }
            
            if(cnt < n)
                left = mid+1;
            else right = mid-1;
        }
        
        return left;
    }
}