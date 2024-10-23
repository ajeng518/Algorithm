import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int size = input.length();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < size; i++) {
            if (input.charAt(i) == '0') zero++;
        }

        one = size - zero;

        zero = zero / 2;
        one = one / 2;

        int i = 0;
        while (one > 0) {
            if (input.charAt(i) == '1') {
                input = input.substring(0, i) + input.substring(i + 1);
                one--;
                i--;
            }
            i++;
        }

        int j = input.length() - 1;
        while (zero > 0) {
            if (input.charAt(j) == '0') {
                input = input.substring(0, j) + input.substring(j + 1);
                zero--;
                j=input.length();
            }
            j--;
        }

        System.out.println(input);
    }
}