import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Trie {
        Trie[] child;
        boolean isLeaf;
        int childCnt;

        public Trie() {
            this.child = new Trie[10];
            this.isLeaf = false;
            this.childCnt = 0;
        }
    }

    public static void input(Trie root, String word) {
        Trie cur = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - '0';

            if (cur.child[idx] == null) {
                cur.child[idx] = new Trie();
                cur.childCnt++;
            }

            cur = cur.child[idx];
        }

        cur.isLeaf = true;
    }

    public static boolean search(Trie root, String word) {
        Trie cur = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - '0';

            if (cur.child[idx] == null) return false;

            cur = cur.child[idx];

        }

        if (cur.isLeaf) {
            int cnt = 0;

            if (cur.childCnt == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCase; test++) {
            Trie root = new Trie();
            int n = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String input = br.readLine();

                input(root, input);
                list.add(input);
            }

            boolean sameStr = false;
            for (String str : list) {
                if (search(root, str)) {
                    sameStr = true;
                    break;
                }
            }

            sb.append(sameStr ? "NO" : "YES").append("\n");
        }
        System.out.println(sb);
    }
}