import java.util.*;

public class graph_49189 {
    public static HashMap<Integer, Set<Integer>> nodes_per_depth = new HashMap<>();

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        //int[][] vertex = {{1,2},{1,3},{2,4},{3,4},{4,5},{4,6}};
        System.out.println(solution(n, vertex));
    }

    public static int solution(int n, int[][] edge) {
        boolean[][] connection = new boolean[n+1][n+1];
        for(int[] a_edge : edge) {
            int from = a_edge[0];
            int to = a_edge[1];
            connection[from][to] = true;
            connection[to][from] = true;
        }

        boolean[] visited = new boolean[n+1];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int current_distance = p.getDistance();
            int current_nodeId = p.getNode_id();

            if (visited[current_nodeId]) continue;

            nodes_per_depth.computeIfAbsent(current_distance, x -> new HashSet<>()).add(current_nodeId);
            visited[current_nodeId] = true;
            for(int next_nodeId=1; next_nodeId<=n; next_nodeId++) {
                if (!visited[next_nodeId] && connection[current_nodeId][next_nodeId]) {
                    q.add(new Pair(current_distance + 1, next_nodeId));
                }
            }
        }
        int max_depth = Collections.max(nodes_per_depth.keySet());
        return nodes_per_depth.get(max_depth).size();
    }

    public static void dfs(boolean[][] connection, boolean[] visited, int current_nodeId, int depth, int n) {
        if (visited[current_nodeId]) return;

        nodes_per_depth.computeIfAbsent(depth, x -> new HashSet<>()).add(current_nodeId);
        visited[current_nodeId] = true;
        for(int next_nodeId=1; next_nodeId<=n; next_nodeId++) {
            if (!visited[next_nodeId] && connection[current_nodeId][next_nodeId]) {
                dfs(connection, visited, next_nodeId, depth+1, n);
            }
        }
        visited[current_nodeId] = false;
    }

    public static class Pair {
        private final int distance;
        private final int node_id;

        public Pair(int distance, int node_id) {
            this.distance = distance;
            this.node_id = node_id;
        }

        public int getDistance() {
            return distance;
        }

        public int getNode_id() {
            return node_id;
        }
    }
}
