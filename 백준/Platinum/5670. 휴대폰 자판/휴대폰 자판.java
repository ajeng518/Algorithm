import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> wordList;
        String num=null;

        while ((num = br.readLine()) != null) {

            double ans = 0;

            int n = Integer.parseInt(num);
            wordList = new ArrayList<>();
            Trie root = new Trie();

            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                wordList.add(input);
                inputTrie(root, input);
            }

            for (int i = 0; i < n; i++) {
                count = 1;
                findTrie(root, wordList.get(i));
                ans += count;

            }
            ans /= n;
            System.out.println(String.format("%.2f", ans));
//            sb.append(String.format("%.2f", ans)).append("\n");

        }

//        System.out.println(sb);
    }

    public static class Trie {
        Map<Character, Trie> child;
        int childCnt;
        boolean isLeaf;

        public Trie() {
            this.child = new HashMap<>();
            this.childCnt = 0;
            this.isLeaf = false;
        }
    }

    public static void inputTrie(Trie root, String word) {
        Trie cur = root;

        for (int i = 0; i < word.length(); i++) {
            char idx = word.charAt(i);

            if (!cur.child.containsKey(idx))
                cur.childCnt++;

            cur = cur.child.computeIfAbsent(idx, c -> new Trie());
        }

        cur.isLeaf = true;
    }

    public static void findTrie(Trie root, String word) {
        Trie cur = root;
        cur = cur.child.get(word.charAt(0));

        for (int i = 1; i < word.length(); i++) {
            char wordIdx = word.charAt(i);

            if (cur.childCnt > 1) {
                count++;
            } else if (cur.childCnt == 1 && cur.isLeaf) {
                count++;
            }

            cur = cur.child.get(wordIdx);
        }

    }
}