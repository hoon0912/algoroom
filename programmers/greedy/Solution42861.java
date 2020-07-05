package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 섬 연결하기
public class Solution42861 {

  static class Island implements Comparable<Island> {

    private int a;
    private int b;
    private int cost;

    public Island(int a, int b, int cost) {
      this.a = a;
      this.b = b;
      this.cost = cost;
    }

    public int getA() {
      return a;
    }

    public int getB() {
      return b;
    }

    public int getCost() {
      return cost;
    }

    @Override
    public int compareTo(Island o) {
      return this.cost - o.cost;
    }
  }

  static int[] distIsland;

  public int solution(int n, int[][] costs) {
    int answer = 0;

    List<Island> islands = new ArrayList<>();
    for(int i = 0; i < costs.length; i++) {
      islands.add(new Island(costs[i][0], costs[i][1], costs[i][2]));
    }
    Collections.sort(islands);

    distIsland = new int[n];
    for (int i = 0; i < n; i++) {
      distIsland[i] = i;
    }

    for (int i = 0; i < costs.length; i++) {
      Island island = islands.get(i);
      int a = find(island.getA());
      int b = find(island.getB());
      int cost = island.getCost();

      if (a != b) {
        distIsland[a] = b;
        answer += cost;
      }
    }
    return answer;
  }

  private int find(int a) {
    if (a == distIsland[a]) return a;
    else return distIsland[a] = find(distIsland[a]);
  }

  public static void main(String[] args) {
    Solution42861 solution = new Solution42861();
    int n = 4;
    int[][] costs = new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
    System.out.println(solution.solution(n, costs)); // 4

  }
}
