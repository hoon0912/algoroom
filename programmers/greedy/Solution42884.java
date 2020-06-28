package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 단속카메라
public class Solution42884 {
  static class Route implements Comparable<Route> {
    private final int start;
    private final int end;

    public Route(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    @Override
    public int compareTo(Route o) {
      return this.end - o.end;
    }
  }

  public int solution(int[][] routes) {
    int answer = 0;
    int camera = -30001;

    List<Route> routeList = new ArrayList<>();
    for (int[] route : routes) {
      routeList.add(new Route(route[0], route[1]));
    }
    routeList.sort(Comparator.naturalOrder());

    for (Route route : routeList) {
      if (camera < route.getStart()) {
        camera = route.getEnd();
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42884 solution = new Solution42884();
    int[][] routes = new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
    int result = solution.solution(routes); // w
    System.out.println("result : " + result);
  }
}
