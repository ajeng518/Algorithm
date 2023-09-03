import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, max, people[], input[][], lu[];
    static boolean chk[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[N + 1][10];

        people = new int[10];
        chk = new boolean[10];
        max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        re(1);
        System.out.println(max);
    }

    private static void re(int idx) {
        if (idx == 10) {
            max = Math.max(max, checkScore());
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (chk[i] || idx == 4 && i != 1) continue;
            chk[i] = true;
            people[idx] = i;
            re(idx + 1);
            chk[i] = false;
        }
    }

    private static int checkScore() {
        int out = 0;//한 이닝의 아웃 카운트
        int nowN = 1;//현재 이닝
        int idx = 1;//현재 선수의 실력
        int score = 0;

        while (nowN <= N) {
            lu = new int[4];
            out=0;
            while (out < 3) {
                if (idx > 9) {
                    idx = 1;
                }
                int nowPer = input[nowN][people[idx]];
                if (nowPer == 0) {
                    out++;
                } else {
                    lu[0] = 1;
                    score += swap(nowPer, 0);
                }
                idx++;
            }
            nowN++;
        }

        return score;
    }

    private static int swap(int cnt, int score) {
        for (int i = 1; i <= cnt; i++) {
            for (int j = lu.length - 1; j >= 0; j--) {
                if (j == lu.length - 1 && lu[j] == 1) {
                    score++;
                    lu[j] = 0;
                } else if (j < lu.length - 1) {
                    lu[j + 1] = lu[j];
                    lu[j] = 0;
                }
            }
        }
        return score;
    }
}
