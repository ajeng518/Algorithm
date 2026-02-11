import java.util.*;
import java.io.*;

class Solution {
    static class Student implements Comparable<Student>{
        int score;
        int idx;
        
        @Override
        public int compareTo(Student o){
            if(this.score == o.score)
                return this.idx - o.idx;
            
            return o.score - this.score;
        }
        
        Student(int idx){
            this.score =0;
            this.idx = idx;
        }
        
    }
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        Student[] stu=new Student[3];
        stu[0]=new Student(1);
        stu[1]=new Student(2);
        stu[2]=new Student(3);
        
        for(int i = 0;i<answers.length; i++){
            int curAns = answers[i];
            
            //1번 학생
            if(i%5+1 == curAns){
                stu[0].score++;
            }
            //2번 학생
            if(i%2 == 0){//짝
                if(curAns == 2) stu[1].score++;
            }else{//홀
                if(arr2[i%8] == curAns) stu[1].score++;
            }
            
            //3번 학생
            if(arr3[i%10] == curAns) stu[2].score++;
        }
        
        Arrays.sort(stu);
        
        int max =stu[0].score;
        int cnt=1;
        
        int[] ans = new int[3];
        ans[0]=stu[0].idx;
        
        for(int i=1;i<3;i++){
            if(max != stu[i].score)
                break;
            cnt++;
            ans[i]=stu[i].idx;
        }
        
        answer = new int[cnt];
        for(int i =0; i< cnt;i++){
            answer[i]=ans[i];
        }
        
        return answer;
    }
}