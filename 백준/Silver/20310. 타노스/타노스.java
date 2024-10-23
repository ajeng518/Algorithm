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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zero; i++) sb.append('0');
        for (int i = 0; i < one; i++) sb.append('1');

        System.out.println(sb);
    }
}