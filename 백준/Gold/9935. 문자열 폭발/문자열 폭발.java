import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String chk = br.readLine();
        int chkSize = chk.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (chkSize <= stack.size()) {
                boolean flag = true;

                for (int j = 0; j < chkSize; j++) {
                    if (stack.get(stack.size() - chkSize + j) != chk.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < chkSize; j++) stack.pop();
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            System.out.println(sb.reverse());
        }


    }
}