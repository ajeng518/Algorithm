import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> name = new HashMap<>();
        for(int i=0;i<participant.length; i++){
            if(!name.containsKey(participant[i]))
                name.put(participant[i], 1);
            else name.put(participant[i], name.get(participant[i])+1);
        }
        
        for(int i=0;i<completion.length;i++){
            if(name.get(completion[i])==1)
                name.remove(completion[i]);
            else name.put(completion[i], name.get(completion[i])-1);
        }
        for(String n: name.keySet())
            answer=n;
        return answer;
    }
}