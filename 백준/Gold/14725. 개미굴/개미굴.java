import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static class Trie {
        Map<String, Trie> child;
        int childCnt;
        boolean isLeaf;

        public Trie() {
            this.child = new HashMap<>();
            this.childCnt = 0;
            this.isLeaf = false;
        }
    }

    public static void inputTrie(Trie root, String[] word) {
        Trie cur = root;

        for (String s : word) {
            if (!cur.child.containsKey(s)) {
                cur.child.put(s, new Trie());
                cur.childCnt++;
            }

            cur = cur.child.get(s);
        }

        cur.isLeaf = true;
    }

    public static void search(Trie root, int cnt) {
        Trie cur = root;

        List<String> keyList = new ArrayList<>(cur.child.keySet());
        Collections.sort(keyList);

        for (String s : keyList) {
            for (int i = 0; i < cnt; i++) sb.append("--");
            sb.append(s).append("\n");

            search(cur.child.get(s), cnt+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        Trie root = new Trie();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String[] input = new String[len];

            for (int j = 0; j < len; j++) {
                input[j] = st.nextToken();
            }

            inputTrie(root, input);
        }

        search(root, 0);
        System.out.println(sb);
    }
}