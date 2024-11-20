import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX_TEAM = 6;
    static int MATCH_CNT = 15;
    static int[][] match;
    static boolean canGame = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test = 4;
        boolean cantAble = false;

        match = new int[MATCH_CNT][2];
        int idx = 0;
        for (int i = 0; i < MAX_TEAM; i++) {
            for (int j = i + 1; j < MAX_TEAM; j++) {
                match[idx][0] = i;
                match[idx++][1] = j;
            }
        }

        while (test-- > 0) {
            int[][] score = new int[3][MAX_TEAM];

            cantAble = false;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 6; j++) {
                int all = 0;
                for (int k = 0; k < 3; k++) {
                    score[k][j] = Integer.parseInt(st.nextToken());
                    all += score[k][j];
                }
                if (all != 5) {
                    sb.append(0).append(" ");
                    cantAble = true;
                }

                if (cantAble) break;
            }
            if (cantAble) continue;

            canGame = false;
            matchGame(score, 0);

            if (canGame) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }

    private static void matchGame(int[][] score, int matchNum) {
        if (canGame) return;

        if (matchNum == MATCH_CNT) {
            canGame = true;
            return;
        }

        int my = match[matchNum][0];
        int enemy = match[matchNum][1];

        if (score[0][my] > 0 && score[2][enemy] > 0) {
            score[0][my]--;
            score[2][enemy]--;
            matchGame(score, matchNum + 1);
            score[0][my]++;
            score[2][enemy]++;
        }
        if (score[1][my] > 0 && score[1][enemy] > 0) {
            score[1][my]--;
            score[1][enemy]--;
            matchGame(score, matchNum + 1);
            score[1][my]++;
            score[1][enemy]++;
        }
        if (score[2][my] > 0 && score[0][enemy] > 0) {
            score[2][my]--;
            score[0][enemy]--;
            matchGame(score, matchNum + 1);
            score[2][my]++;
            score[0][enemy]++;
        }
    }
}