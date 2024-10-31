import java.util.*;
import java.io.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String s1=new_id.toLowerCase();
        
        char[] s1Arr=s1.toCharArray();
        StringBuilder sb2= new StringBuilder();
        
        for(char c: s1Arr){
            if((c>='a' && c<='z') ||(c>='0' && c<='9') || c=='-' || c=='_' || c=='.') sb2.append(c);
        }
        
        String s3=sb2.toString().replace("..", ".");
        while (s3.contains("..")) {
            s3 = s3.replace("..", ".");
        }
        
        String s4=s3;
        if(s4.length()>0){
            if(s4.charAt(0)=='.'){
                s4=s4.substring(1);
            }
        }
        if(s4.length()>0){
            if(s4.charAt(s4.length()-1)=='.'){
                s4=s4.substring(0,s4.length()-1);
            }
        }
        
        String s5=s4;
        if(s5.equals(""))
            s5="a";
        
        String s6=s5;
        
        if(s6.length()>15){
            s6=s6.substring(0,15);
            
            if(s6.charAt(s6.length()-1)=='.')
                s6=s6.substring(0,s6.length()-1);
        }
        
        StringBuilder s7=new StringBuilder(s6);
        if(s7.length()<=2){
            char lastC=s7.charAt(s7.length()-1);
            
            while(s7.length()<3)
                s7.append(lastC);
        }
        
        answer=s7.toString();
        
        return answer;
    }
}