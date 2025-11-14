import java.util.*;
public class Main {
    static Map<Integer, List<Integer>> vertex;
    static int n, m;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cnt=0;
        vertex = new HashMap<>();
        for(int i = 0; i<=n;i++){
            vertex.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a= sc.nextInt();
            int b = sc.nextInt();

            vertex.get(a).add(b);
            vertex.get(b).add(a);
        }
        // Please write your code here.

        visited = new boolean[n+1];
        int answer = dfs(1);

        System.out.println(answer);
    }

    private static int dfs(int now){
        if(now !=1){
            cnt++;
        }
        for(int next : vertex.get(now)){
            if(visited[next]) continue;

            visited[next]=true;
            dfs(next);

        }

        return cnt;
    }
}