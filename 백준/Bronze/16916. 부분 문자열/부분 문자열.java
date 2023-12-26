import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] pi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        pi = new int[P.length()];

        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(j) != P.charAt(i)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                pi[i] = ++j;
            }
        }
        System.out.println(doKMP(S,P));
    }

    private static int doKMP(String S, String P) {
        int idx = 0;

        for (int i = 0; i < S.length(); i++) {
            while (idx > 0 && S.charAt(i) != P.charAt(idx)) {
                idx = pi[idx - 1];
            }

            if (S.charAt(i) == P.charAt(idx)) {
                if (idx == P.length() - 1) {
                    return 1;
                } else {
                    idx++;
                }
            }
        }
        return 0;
    }
}
