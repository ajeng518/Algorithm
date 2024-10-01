import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int nowIdx;
    static HashSet<String> wearList = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Trie color = new Trie();
//        Trie wear = new Trie();

        int colorCnt = Integer.parseInt(st.nextToken());
        int wearCnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < colorCnt; i++) {
            String input = br.readLine();

            insertTrie(color, input);
        }

        for (int i = 0; i < wearCnt; i++) {
            String input = br.readLine();

            wearList.add(input);
        }

        int testCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCnt; i++) {
            String testWord = br.readLine();
            nowIdx = 0;
            if (!findTrie(color, testWord, 0)) {
                sb.append("No").append("\n");
                continue;
            }
            sb.append("Yes").append("\n");
        }

        System.out.println(sb);
    }

    public static class Trie {
        Trie[] child;
        int childCnt;
        boolean isLeaf;

        public Trie() {
            this.child = new Trie[26];
            this.childCnt = 0;
            this.isLeaf = false;
        }
    }

    public static void insertTrie(Trie root, String word) {
        Trie cur = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (cur.child[idx] == null) {
                cur.childCnt++;
                cur.child[idx] = new Trie();
            }

            cur = cur.child[idx];
        }

        cur.isLeaf = true;
    }

    public static boolean findTrie(Trie root, String word, int idx) {

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';

            if(root.isLeaf && wearList.contains(word.substring(i))) return true;
            if(root.child[index]==null) return false;

            root=root.child[index];
        }
        return false;
    }
}