import java.util.*;
import java.util.stream.IntStream;
class Solution {
    int[] union = new int[100];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        IntStream.range(0,n).forEach(x->union[x]=x);
        Arrays.sort(costs, Comparator.comparingInt(x -> x[2]));
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {//아직 다른 노드와 연결이 되지 않는 노드
                union[find(Math.max(cost[0], cost[1]))] = find(Math.min(cost[0], cost[1]));
                answer += cost[2];
            }
        }
        return answer;
    }
    private int find(int child){
        return union[child] == child ? child : find(union[child]);
    }
}