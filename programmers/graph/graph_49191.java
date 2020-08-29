import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class graph_49191 {
    public static HashMap<Integer, HashSet<Integer>> loser_list = new HashMap<>();
    public static HashMap<Integer, HashSet<Integer>> winner_list = new HashMap<>();

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n, results));
    }

    public static int solution (int n, int[][] results) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>(n+1);
        for(int i=0; i<=n+1; i++) {
            edge.add(new ArrayList<>());
        }

        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            edge.get(loser).add(winner);
        }

        for(int player=1; player<=n; player++) {
            boolean[] visited = new boolean[n+1];
            dfs(player, visited, edge, n, "" + player);

            for(int i=1; i<=n; i++) {
                if (i != player && visited[i]) {
                    winner_list.computeIfAbsent(player, x -> new HashSet<>()).add(i);
                }
            }
        }

        for(int player=1; player<=n; player++) {
            int loser_count = (loser_list.containsKey(player)) ? loser_list.get(player).size() : 0;
            int winner_count = (winner_list.containsKey(player)) ? winner_list.get(player).size() : 0;

            if (loser_count + winner_count == n-1) {
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int player, boolean[] visited, ArrayList<ArrayList<Integer>> edge, int n, String path) {
        visited[player] = true;

        for(int next : edge.get(player)) {
            if (!visited[next]) {
                loser_list.computeIfAbsent(next, x -> new HashSet<>()).addAll(Arrays.stream(path.split("_")).map(Integer::valueOf).collect(Collectors.toSet()));
                dfs(next, visited, edge, n, path + "_" +player);
            }
        }
    }
}
