import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[]in=new String[n];
		String[]out=new String[n];
		int[] chk=new int[n];
		
		for(int i=0;i<n;i++) {
			in[i]=br.readLine();
		}
		for(int i=0;i<n;i++) {
			out[i]=br.readLine();
		}
		
		int badcar=0;
		
		for(int i=0;i<out.length;i++) {
			boolean badbe=false;
			for(int j=0;j<in.length;j++) {
				if(out[i].equals(in[j])) {
					for(int k=0;k<j;k++) {
						if(chk[k]!=1) {
							badcar++;
							badbe=true;
							break;
						}
					}
					chk[j]=1;
				}
				if(badbe==true) {
					break;
				}
			}
		}
		System.out.println(badcar);
		
	}

}
