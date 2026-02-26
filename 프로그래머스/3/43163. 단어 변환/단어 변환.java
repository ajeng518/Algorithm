import java.io.*;
import java.util.*;

class Solution {
    static char[] start, end;
    static char[][] wordList;
    static int len;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        start=begin.toCharArray();
        end=target.toCharArray();
        
        len = begin.length();
        wordList = new char[words.length][len];
        boolean canSearch=false;
        
        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])) canSearch = true;
            
            wordList[i]=words[i].toCharArray();
        }
        
        if(!canSearch) return 0;
        
        answer=bfs();
        return answer;
    }
    
    private static int bfs(){
        Deque<char[]> q = new ArrayDeque<>();
        boolean[] visited =new boolean[wordList.length];
        int cnt=0;
        
        q.add(start);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                char[] cur = q.poll();
                
                if(isSameWord(cur, end) == len) return cnt;
                
                for(int i=0;i<wordList.length;i++){
                    if(visited[i]) continue;
                    if(isSameWord(cur, wordList[i]) != len-1) continue;
                    
                    q.add(wordList[i]);
                    visited[i]=true;
                }
            }
            
            cnt++;
        }
        
        return 0;
    }
    
    private static int isSameWord(char[] a, char[]b){
        int cnt=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]) continue;
            
            cnt++;
        }
        
        return cnt;
    }
}