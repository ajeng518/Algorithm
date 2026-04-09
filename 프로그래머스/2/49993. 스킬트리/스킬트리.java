import java.util.*;
class Solution{
    public int solution(String skill, String[] skill_trees){
        int ans = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            char[] cur = skill_trees[i].toCharArray();
            
            if(!chkSkills(skill, cur)) continue;
            
            ans++;
        }
        
        return ans;
    }
    
    private static boolean chkSkills(String skill, char[] cur){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<cur.length; i++){
            if(skill.contains(String.valueOf(cur[i])))
                sb.append(cur[i]);
        }
        
        if(skill.indexOf(sb.toString()) == 0) return true;
        return false;
    }
}

// class Solution {
//     public int solution(String skill, String[] skill_trees) {
//         int answer = 0;
        
//         for(int i=0;i<skill_trees.length; i++){
//             char[] cur=skill_trees[i].toCharArray();
            
//             if(chkSkillPossible(skill, cur)) answer++;
           
//         }
//         return answer;
//     }
    
//     private static boolean chkSkillPossible(String skill, char[] cur){
//         StringBuilder sb=new StringBuilder();
        
//         for(int i=0;i<cur.length; i++){
//             if(skill.contains(String.valueOf(cur[i]))){
//                 sb.append(cur[i]);
//             }
//         }
        
//         if(skill.indexOf(sb.toString())==0) return true;
//         else return false;
//     }
// }