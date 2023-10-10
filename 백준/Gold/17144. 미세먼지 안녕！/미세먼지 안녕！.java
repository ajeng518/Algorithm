import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
	static int R, C, T, map[][],airFresh[];
	static int[] dX = { -1, 0, 1, 0 };
	static int[] dY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		map=new int[R][C];
		airFresh=new int[2];
		int idx=0;
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					airFresh[idx++]=i;
				}
			}
		}
		
		for(int i=0;i<T;i++) {
			process();
		}
		System.out.println(chkSum());
	}

	private static void process() {
		bfs();
		wind();
	}
	
	private static void bfs() {
		Deque<int[]>q=new ArrayDeque();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					q.add(new int[] {i,j,map[i][j]});
					map[i][j]=0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now=q.poll();
			int cnt=0;
			
			for(int i=0;i<4;i++) {
				int nX=now[0]+dX[i];
				int nY=now[1]+dY[i];
				
				if(nX<0 ||nX>=R)continue;
				if(nY<0 ||nY>=C)continue;
				if(map[nX][nY]==-1)continue;//공기청정기 자리
				map[nX][nY]+=now[2]/5;
				cnt++;
			}
			
			if(cnt==0) 
				map[now[0]][now[1]]+=now[2];
			else	map[now[0]][now[1]]+=now[2]-(cnt*(now[2]/5));
		}
	}

	private static void wind() {
		for(int i=airFresh[0]-1;i>0;i--) {
			map[i][0]=map[i-1][0];
		}
		for(int i=0;i<C-1;i++) {
			map[0][i]=map[0][i+1];
		}
		for(int i=0;i<airFresh[0];i++) {
			map[i][C-1]=map[i+1][C-1];
		}
		for(int i=C-1;i>1;i--) {
			map[airFresh[0]][i]=map[airFresh[0]][i-1];
		}
		map[airFresh[0]][1]=0;
		////////////////////
		for(int i=airFresh[1]+1;i<R-1;i++) {
			map[i][0]=map[i+1][0];
		}
		for(int i=0;i<C-1;i++) {
			map[R-1][i]=map[R-1][i+1];
		}
		for(int i=R-1;i>airFresh[1];i--) {
			map[i][C-1]=map[i-1][C-1];
		}
		for(int i=C-1;i>1;i--) {
			map[airFresh[1]][i]=map[airFresh[1]][i-1];
		}map[airFresh[1]][1]=0;

	}
	private static int chkSum() {
		int result=0;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					result+=map[i][j];
				}
			}
		}
		return result;
	}
}
