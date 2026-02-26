import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left=0;
        int right = people.length-1;
        boolean[] visited = new boolean[people.length];
        int cnt=0;
        
        while(left < right){
            if(visited[right]) {
                right--;
                continue;
            }
            
            if(people[left] + people[right] > limit){
                right--;
                continue;
            }
            
            if(people[left] + people[right] <= limit){
                visited[left]=true;
                visited[right]=true;
                answer++;
                cnt+=2;
                
                left++;
                right--;
                continue;
            }
        }
        
        if(cnt < people.length){
            answer+=people.length-cnt;
        }
        
        return answer;
    }
}