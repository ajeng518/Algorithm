import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String a = " "+br.readLine();
        String b = " "+br.readLine();

        int aLen = a.length()-1;
        int bLen = b.length()-1;

        boolean[][]isPos = new boolean[aLen+1][bLen+1];
        isPos[0][0]=true; 

        for(int j=0; j<bLen; j++){
            for(int i=0; i<=aLen; i++){
                if(!isPos[i][j]) continue;

                if(j != bLen-1 && b.charAt(j+2) == '*'){
                    isPos[i][j+2]=true;

                    for(int curi = i+1; curi <= aLen; curi++){
                        if(b.charAt(j+1) != '.' && a.charAt(curi) !=b.charAt(j+1)) break;
                        isPos[curi][j+2]=true;
                    }
                }else if(b.charAt(j+1) == '.'){
                    isPos[i + 1][j + 1]=true;
                }else{
                    if(i!=aLen && a.charAt(i+1) == b.charAt(j+1))
                        isPos[i+1][j+1]=true;
                }
            }
        }

        System.out.println(isPos[aLen][bLen]? "true": "false");

    }
}