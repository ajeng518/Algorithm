import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x, y; //가로 세로
        
        int brownSize = brown/2 + 2;
        
        for(int i=brownSize/2;i<brownSize; i++){
            System.out.println(i-1+", "+(brownSize-i-2));
            if((i-2)*(brownSize-i-2) != yellow) continue;
            if(i-2 < brownSize-i-2) continue;
            
            answer=new int[]{i, brownSize-i};
            break;
        }
        return answer;
    }

}