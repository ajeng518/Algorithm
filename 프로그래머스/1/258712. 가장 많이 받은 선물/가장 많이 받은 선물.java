import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[] answer = new int[n+1];
        
        StringTokenizer st;
        
        Map<String, Integer> userMap = new HashMap<>();
        int[][] giftMap=new int[n+1][n+1];
        int[] giftNum = new int[n+1];
        
        for(int i=0;i<n;i++){
            userMap.put(friends[i], i+1);
        }
        
        for(int i=0;i<gifts.length;i++){
            st=new StringTokenizer(gifts[i]);
            int a = userMap.get(st.nextToken());
            int b = userMap.get(st.nextToken());
            
            giftMap[a][b]++;
            giftNum[a]++;
            giftNum[b]--;
        }

       for(int i=1;i<=n;i++){
           for(int j =i+1; j<=n; j++){
               if(giftMap[i][j] > 0 || giftMap[j][i] > 0){//주고받은 적이 있음
                   if(giftMap[i][j]>giftMap[j][i]){
                       answer[i]++;
                   }else if(giftMap[i][j] < giftMap[j][i]){
                       answer[j]++;
                   }else{
                       if(giftNum[i] < giftNum[j]){
                           answer[j]++;
                       }else if(giftNum[i] > giftNum[j]){
                           answer[i]++;
                       }
                   }
               }else{//주고 받은적이 없다.
                   if(giftNum[i] != giftNum[j]){
                       if(giftNum[i] < giftNum[j]){
                           answer[j]++;
                       }else if(giftNum[i] > giftNum[j]){
                           answer[i]++;
                       }
                   }
               }
           }
       } 
        
        int max = 0;
        for(int i=1;i<=n;i++){
            max=Math.max(answer[i], max);
        }
        
        
        return max;
    }
}