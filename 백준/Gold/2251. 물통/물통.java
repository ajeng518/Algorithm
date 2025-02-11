import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] size = new int[3];
        int max = 0;

        for (int i = 0; i < 3; i++) {
            size[i] = Integer.parseInt(st.nextToken());
            if (max < size[i]) max = size[i];
        }

        Set<Integer> can = new HashSet<>();

        bfs(size, can);

        List<Integer> list = new ArrayList<>(can);
        Collections.sort(list);
        for (int high : list) {
            sb.append(high).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int[] size, Set<Integer> can) {
        boolean[][][] chk = new boolean[size[0] + 1][size[1] + 1][size[2] + 1];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, size[2]});
        chk[0][0][size[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == 0) can.add(cur[2]);

            if (cur[0] > 0) {
                if (cur[0] + cur[1] > size[1]) {
                    if (!chk[cur[0] - (size[1] - cur[1])][size[1]][cur[2]]) {
                        q.add(new int[]{cur[0] - (size[1] - cur[1]), size[1], cur[2]});
                        chk[cur[0] - (size[1] - cur[1])][size[1]][cur[2]] = true;
                    }
                } else {
                    if (!chk[0][cur[0] + cur[1]][cur[2]]) {
                        q.add(new int[]{0, cur[0] + cur[1], cur[2]});
                        chk[0][cur[0] + cur[1]][cur[2]] = true;
                    }
                }

                if (cur[0] + cur[2] > size[2]) {
                    if (!chk[cur[0] - (size[2] - cur[2])][cur[1]][size[2]]) {
                        q.add(new int[]{cur[0] - (size[2] - cur[2]), cur[1], size[2]});
                        chk[cur[0] - (size[2] - cur[2])][cur[1]][size[2]] = true;
                    }
                } else {
                    if (!chk[0][cur[1]][cur[0] + cur[2]]) {
                        q.add(new int[]{0, cur[1], cur[0] + cur[2]});
                        chk[0][cur[1]][cur[0] + cur[2]] = true;
                    }
                }
            }
            if (cur[1] > 0) {
                if (cur[1] + cur[0] > size[0]) {
                    if (!chk[size[0]][cur[1] - (size[0] - cur[0])][cur[2]]) {
                        q.add(new int[]{size[0], cur[1] - (size[0] - cur[0]), cur[2]});
                        chk[size[0]][cur[1] - (size[0] - cur[0])][cur[2]] = true;
                    }
                } else {
                    if (!chk[cur[0] + cur[1]][0][cur[2]]) {
                        q.add(new int[]{cur[0] + cur[1], 0, cur[2]});
                        chk[cur[0] + cur[1]][0][cur[2]] = true;
                    }
                }

                if (cur[1] + cur[2] > size[2]) {
                    if (!chk[cur[0]][cur[1] - (size[2] - cur[2])][size[2]]) {
                        q.add(new int[]{cur[0], cur[1] - (size[2] - cur[2]), size[2]});
                        chk[cur[0]][cur[1] - (size[2] - cur[2])][size[2]] = true;
                    }
                } else {
                    if (!chk[cur[0]][0][cur[1] + cur[2]]) {
                        q.add(new int[]{cur[0], 0, cur[1] + cur[2]});
                        chk[cur[0]][0][cur[1] + cur[2]] = true;
                    }
                }

            }
            if (cur[2] > 0) {
                if (cur[2] + cur[0] > size[0]) {
                    if (!chk[size[0]][cur[1]][cur[2] - (size[0] - cur[0])]) {
                        q.add(new int[]{size[0], cur[1], cur[2] - (size[0] - cur[0])});
                        chk[size[0]][cur[1]][cur[2] - (size[0] - cur[0])] = true;
                    }
                } else {
                    if (!chk[cur[0] + cur[2]][cur[1]][0]) {
                        q.add(new int[]{cur[0] + cur[2], cur[1], 0});
                        chk[cur[0] + cur[2]][cur[1]][0] = true;
                    }
                }


                if (cur[2] + cur[1] > size[1]) {
                    if (!chk[cur[0]][size[1]][cur[2] - (size[1] - cur[1])]) {
                        q.add(new int[]{cur[0], size[1], cur[2] - (size[1] - cur[1])});
                        chk[cur[0]][size[1]][cur[2] - (size[1] - cur[1])] = true;
                    }
                } else {
                    if (!chk[cur[0]][cur[1] + cur[2]][0]) {
                        q.add(new int[]{cur[0], cur[1] + cur[2], 0});
                        chk[cur[0]][cur[1] + cur[2]][0] = true;
                    }
                }
            }
        }
    }
}