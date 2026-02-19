import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int size = commands[i][1] - commands[i][0] + 1;
            int[] filter=new int[size];
            
            int idx =0;
            for(int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++){
                filter[idx++]=array[j];
            }

            Arrays.sort(filter);
            answer[i]=filter[commands[i][2]-1];
        }
        
        return answer;
    }
}