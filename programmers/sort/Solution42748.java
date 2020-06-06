package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// K번째수
public class Solution42748 {
  public int[] solution(int[] array, int[][] commands) {
    List<Integer> answer = new ArrayList<>();

    for (int[] cmd : commands) {
      int[] tempArray = Arrays.copyOfRange(array, cmd[0]-1, cmd[1]);
      Arrays.sort(tempArray);
      answer.add(tempArray[cmd[2]-1]);
    }

    return answer.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    Solution42748 solution42748 = new Solution42748();

    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    int[] answer = solution42748.solution(array, commands);
    System.out.println("### result : " + Arrays.toString(answer));
  }
}
