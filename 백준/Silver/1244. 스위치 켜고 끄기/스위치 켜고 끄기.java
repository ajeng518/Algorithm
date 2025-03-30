import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());//스위치 수
		int[]swit=new int[n+1];
		
		StringTokenizer st=new StringTokenizer(bf.readLine()," ");//스위치 상태
		for(int i=1;i<swit.length;i++) {
			swit[i]=Integer.parseInt(st.nextToken());//매핑
		}
		
		//남-1, 여-2
		int person=Integer.parseInt(bf.readLine());//학생 수
		int[][]stu=new int[person][2];

		for(int i=0;i<stu.length;i++) {
			st=new StringTokenizer(bf.readLine()," ");
			stu[i][0]=Integer.parseInt(st.nextToken());
			stu[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<stu.length;i++) {
			if(stu[i][0]==1) {//남
				for(int j=1;j<swit.length;j++) {
					if((j)%stu[i][1]==0) {
						swit[j]=swit[j]>0?0:1;
					}
				}
			}else {//여
				int same=0;
				if(stu[i][1]<=swit.length/2) {
					for(int j=1;j<stu[i][1];j++) {
						if(swit[stu[i][1]+j]==swit[stu[i][1]-j]) {
							same++;
						}else {break;}
					}
				}else {
					for(int j=1;j<swit.length-stu[i][1];j++) {
						if(swit[stu[i][1]+j]==swit[stu[i][1]-j]) {
							same++;
						}else {break;}
					}
				}
				
				if(same==0) {
					swit[stu[i][1]]=swit[stu[i][1]]>0?0:1;
				}else {
					for(int j=1;j<=same;j++) {
						swit[stu[i][1]+j]=swit[stu[i][1]+j]>0?0:1;
//						System.out.println(stu[i][1]+j);
						swit[stu[i][1]-j]=swit[stu[i][1]-j]>0?0:1;
//						System.out.println(stu[i][1]+j);
					}
					swit[stu[i][1]]=swit[stu[i][1]]>0?0:1;
				}
			}
		}
		
		for(int i=1;i<swit.length;i++) {
			if(i>20 && i%20==1) {
				System.out.println();
			}
			System.out.print(swit[i]+" ");
		}
	}

}
