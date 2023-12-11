import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int score=Integer.parseInt(br.readLine());
		
		String result=score>=90?"A":score>=80?"B":score>=70?"C":score>=60?"D":"F";
		System.out.println(result);
		
	}
}