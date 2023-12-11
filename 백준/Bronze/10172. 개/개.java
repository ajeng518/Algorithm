import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		

		sb.append("|\\_/|").append("\n");
		sb.append("|q p|   /}").append("\n");
		sb.append("( 0 )\"\"\"\\").append("\n");
		sb.append("|\"^\"`    |").append("\n");
		sb.append("||_/=\\\\__|").append("\n");

		System.out.println(sb);
		
	}
}