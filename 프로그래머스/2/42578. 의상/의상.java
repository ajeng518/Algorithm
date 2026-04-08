import java.io.*;
import java.util.*;

class Solution {
    static Map<String, Integer> itemMap;
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        itemMap = new HashMap<>();
        
        for(int i =0;i<clothes.length; i++){
            String wear = clothes[i][0];
            String category = clothes[i][1];
            
            itemMap.put(category, itemMap.getOrDefault(category, 1) + 1);
        }
        
        for(int item: itemMap.values()){
            answer*=item;
        }
        
        return answer-1;
    }
}