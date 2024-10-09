import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String make, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        make = br.readLine();
        ans = br.readLine();

        int answer = makeAns(ans) ? 1 : 0;
        
        System.out.println(answer);
    }

    private static boolean makeAns(String answerString) {
        if (answerString.length() == make.length()) {
            if (!make.equals(answerString)) return false;

            return true;
        } else {
            if (answerString.endsWith("A")) {
                if (makeAns(answerString.substring(0, answerString.length() - 1))) return true;
            }
            if (answerString.startsWith("B")) {
                if (makeAns(new StringBuilder(answerString.substring(1)).reverse().toString())) return true;
            }

            return false;

        }

    }
}