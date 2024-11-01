import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][][] blocks = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            int n = Integer.parseInt(input.trim());
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken().trim());
                }
            }

            int max = Integer.MIN_VALUE;
            boolean cantBlock = false;
            int sum = 0;

            //4방향 돈다
            for (int q = 0; q < 4; q++) {
                //시작점 최대로 지정
                for (int i = 0; i <= n - 1; i++) {
                    for (int j = 0; j <= n - 2; j++) {

                        //시작점 기준 모든 블럭 다 합 돌려봄
                        for (int k = 0; k < blocks.length; k++) {
                            cantBlock = false;
                            sum = 0;

                            //블럭 칸 4개 좌표
                            for (int l = 0; l < 4; l++) {
                                int nx = i + blocks[k][l][0];
                                int ny = j + blocks[k][l][1];

                                if (nx >= n || ny >= n) {//맵 범위 넘어감
                                    //합 계산 불가
                                    cantBlock = true;
                                    break;
                                } else {
                                    sum += map[nx][ny];
                                }
                            }

                            if (!cantBlock) {
                                max = Math.max(sum, max);
                            }
                        }
                    }
                }

                int[][] temp=new int[n][n];
                //맵 방향 전환
                temp=turnMap(map, n);
                for(int i=0;i<n;i++) map[i]=temp[i].clone();

            }

            sb.append(idx++).append(". ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    public static int[][] turnMap(int[][]map, int n) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[n - 1 - j][i];
            }
        }


        return temp;
    }
}