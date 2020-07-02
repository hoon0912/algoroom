import java.util.Arrays;
import java.util.Comparator;

public class greedy_42861 {
    public static void main(String[] args) {
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int n = 4;
        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, Comparator.comparingInt(cost -> cost[2]));
        int[] group = new int[n];  // groupId = 0 (default)
        int groupId = 1;
        for(int i=0; i<costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int price = costs[i][2];

            boolean initial_connection = (group[from] + group[to]) == 0;
            if (initial_connection || group[from] != group[to]) { // 최초 연결 또는 두 노드가 서로 다른 그룹에 속해있는 경우에만 연결
                // 두 노드와 같은 그룹에 속한 다른 노드들의 그룹 아이디 갱신
                for(int node=0; node<n; node++) {
                    if (node == from || node == to) continue;
                    if ((group[node] == group[from] || group[node] == group[to]) && group[node] != 0)
                        group[node] = groupId;
                }
                group[from] = groupId;
                group[to] = groupId;

                answer += price;
                groupId++;
            }

        }
        return answer;
    }
}
