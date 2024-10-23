import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class WordInfo implements Comparable<WordInfo> {
        String word;
        int cnt;

        public WordInfo(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(WordInfo o) {
            if (this.cnt != o.cnt) {
                return o.cnt - this.cnt;
            }
            if (o.word.length() != this.word.length()) {
                return o.word.length() - this.word.length();
            }

            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//단어 수
        int m = Integer.parseInt(st.nextToken());//단어 길이 기준

        Map<String, Integer> wordCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }


        PriorityQueue<WordInfo> pq = new PriorityQueue<>();

        for (String word : wordCnt.keySet()) {
            if (word.length() < m) continue;

            pq.add(new WordInfo(word, wordCnt.get(word)));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().word).append("\n");
        }

        System.out.println(sb);
    }
}