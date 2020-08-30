package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// 순위
public class Solution49191 {
  static class Player {
    Set<Integer> win = new HashSet<>();
    Set<Integer> lose = new HashSet<>();

    public Set<Integer> getWin() {
      return win;
    }

    public Set<Integer> getLose() {
      return lose;
    }
  }

  public static int solution(int n, int[][] results) {
    int answer=0;

    ArrayList<Player> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(new Player());
    }

    for (int[] result : results) {
      int winner = result[0] - 1;
      int loser = result[1] - 1;

      list.get(winner).getWin().add(loser);
      list.get(loser).getLose().add(winner);
    }

    for (int depth = 0; depth < n; depth++) {

      for (int i = 0; i < n; i++) {
        Player player = list.get(i);

        Set<Integer> win = player.getWin();
        Set<Integer> lose = player.getLose();
        Set<Integer> addWin = new HashSet<>();
        Set<Integer> addLose = new HashSet<>();

        for (Integer winner : win) {
          addWin.addAll(list.get(winner).getWin());
        }
        win.addAll(addWin);

        for (Integer loser : lose) {
          addLose.addAll(list.get(loser).getLose());
        }
        lose.addAll(addLose);
      }

    }

    for (Player player : list) {
      if (player.getWin().size() + player.getLose().size() == n-1) {
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution49191 solution = new Solution49191();
    int n = 5;
    int[][] results = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

    System.out.println(solution.solution(n, results)); // 2
  }
}
