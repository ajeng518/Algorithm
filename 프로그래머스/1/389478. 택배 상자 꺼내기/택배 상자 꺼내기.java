class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h=(n/w)+1;
        int[][] box=new int[h][w];
        
        int idx=1;
        boolean rightFirst=false;
        
        for(int i=0;i<h;i++){
            if(rightFirst){//오른쪽부터 쌓기
                for(int j=w-1;j>=0;j--){
                    if(idx==n+1) break;
                    box[i][j]=idx++;
                }
                rightFirst=false;
            }else{//왼쪽부터 쌓기
                for(int j=0;j<w;j++){
                    if(idx==n+1) break;
                    box[i][j]=idx++;
                }
                rightFirst=true;
            }
        }
        
        //박스 뽑기
        int x=num/w;
        int y=num%w;
        if(y==0){
            x--;
            if(x%2==0) y=w-1;
            // else y=w-1;
        }else{
            if(x%2==0){//짝수 줄
                y-=1;
            }else{//홀수 줄
                y=w-y;
            }
        }

        for(int i=h-1;i>=x;i--){
            if(box[i][y]!=0){
                answer++;
            } 
        }
        
        return answer;
    }
}