import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
     static class NodeEdge implements Comparable<NodeEdge> {
        int point;
        int cost;

        public NodeEdge(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }

        @Override
        public int compareTo(NodeEdge o) {
            return this.cost - o.cost;
        }
    }

    static class Tour implements Comparable<Tour> {
        int tourId;//투어 아이디
        int revenue;//투어 매출
        int destNode;//도착지
        int dist;

        public Tour(int tourId, int revenue, int destNode, int dist) {
            this.tourId = tourId;
            this.revenue = revenue;
            this.destNode = destNode;
            this.dist = dist;
        }

        @Override
        public int compareTo(Tour o) {
            if (o.dist == this.dist) {
                return this.tourId - o.tourId;
            }
            return o.dist - this.dist;
        }
    }

    static int n, m, start;
    static Map<Integer, List<NodeEdge>> edgeList;
    static Map<Integer, Tour> tourList;
    static Map<Integer, int[]> distAll;
    static PriorityQueue<Tour> items;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine()); //명령의 수

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int choice = Integer.parseInt(st.nextToken());

            switch (choice) {
                //초기설정
                case 100:
                    n = Integer.parseInt(st.nextToken());
                    m = Integer.parseInt(st.nextToken());
                    edgeList = new HashMap<>();
                    distAll = new HashMap<>();
                    tourList = new HashMap<>();
                    items = new PriorityQueue<>();

                    for (int i = 0; i < m; i++) {
                        int s = Integer.parseInt(st.nextToken());
                        int e = Integer.parseInt(st.nextToken());
                        int cost = Integer.parseInt(st.nextToken());

                        if (s == e) continue;//사이클 제거

                        boolean sameRoot = false;
                        edgeList.put(s, edgeList.getOrDefault(s, new ArrayList<>()));
                        for (NodeEdge node : edgeList.get(s)) {
                            if (node.point == e) {
                                node.cost = Math.min(node.cost, cost);
                                sameRoot = true;
                                break;
                            }
                        }
                        if (!sameRoot)
                            edgeList.get(s).add(new NodeEdge(e, cost));

                        sameRoot = false;
                        edgeList.put(e, edgeList.getOrDefault(e, new ArrayList<>()));
                        for (NodeEdge node : edgeList.get(e)) {
                            if (node.point == s) {
                                node.cost = Math.min(node.cost, cost);
                                sameRoot = true;
                                break;
                            }
                        }
                        if (!sameRoot)
                            edgeList.get(e).add(new NodeEdge(s, cost));
                    }

                    //초기 시작점은 0번 도시에서 시작
                    start = 0;
                    makeStartPoint(start);

                    break;

                //여행상품 생성
                case 200:
                    int id = Integer.parseInt(st.nextToken());
                    int reve = Integer.parseInt(st.nextToken());
                    int dest = Integer.parseInt(st.nextToken());

                    int dist = reve - distAll.get(start)[dest];// 우선순위 계산

                    tourList.put(id, new Tour(id, reve, dest, dist));
                    items.add(tourList.get(id));

                    break;

                //여행상품취소
                case 300:
                    int deleteKey = Integer.parseInt(st.nextToken());

                    if (tourList.containsKey(deleteKey))
                        tourList.remove(deleteKey);

                    break;

                //최적상품판매
                case 400:
                    Tour bestPick = pickTour();

                    if (bestPick != null && bestPick.dist >= 0) {
                        sb.append(bestPick.tourId);
                        tourList.remove(bestPick.tourId);
                    } else sb.append(-1);

                    sb.append("\n");
                    break;

                //여행 상품 출발지 변경
                case 500:
                    int change = Integer.parseInt(st.nextToken());

                    start = change;
                    makeStartPoint(start);
                    break;

            }
        }

        System.out.println(sb);

    }

    private static void makeStartPoint(int start) {
        if (distAll == null) {
            distAll = new HashMap<>();
        }

        if (!distAll.containsKey(start)) {
            int[] dist = dijkstra(start);
            dist[start] = 0;//출발지 경로 0
            distAll.put(start, dist);
        }

        PriorityQueue<Tour> temp = new PriorityQueue<>();
        int[] dist=distAll.get(start);
        for (Tour tour : tourList.values()) {
            tour.dist = tour.revenue - dist[tour.destNode];
            temp.add(tour);
        }
        items = temp;
    }

    private static Tour pickTour() {
        if (items.isEmpty()) return null;

        Tour best = items.poll();

        while (!items.isEmpty() && tourList.get(best.tourId) == null) {
            best = items.poll();
        }

        if (tourList.get(best.tourId) == null) return null;

        return best;
    }

    private static int[] dijkstra(int start) {
        boolean[] chk = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 10);

        PriorityQueue<NodeEdge> pq = new PriorityQueue<>();
        pq.add(new NodeEdge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            NodeEdge cur = pq.poll();

            if (chk[cur.point]) continue;
            chk[cur.point] = true;

            if (!edgeList.containsKey(cur.point)) continue;

            for (NodeEdge next : edgeList.get(cur.point)) {
                if (chk[next.point]) continue;
                if (dist[next.point] <= cur.cost + next.cost) continue;

                dist[next.point] = cur.cost + next.cost;
                pq.add(new NodeEdge(next.point, dist[next.point]));
            }
        }

        return dist;
    }
}