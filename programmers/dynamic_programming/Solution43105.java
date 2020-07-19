package dynamic_programming;

// 정수삼각형
public class Solution43105 {

  public int solution(int[][] triangle) {
    int answer = 0;
    int length = triangle.length;

    int[][] calTriangle = new int[length][];
    int leftSum = 0;
    int rightSum = 0;
    for (int i = 0; i < length; i++) {
      int len = triangle[i].length;
      calTriangle[i] = new int[len];
      calTriangle[i][0] = triangle[i][0] + leftSum;
      calTriangle[i][len-1] = triangle[i][len-1] + rightSum;
      leftSum += triangle[i][0];
      rightSum += triangle[i][len-1];
    }

    for (int i = 2; i < length; i++) {
      for (int j = 1; j < triangle[i].length-1; j++) {
        int preFlourMax = Math.max(calTriangle[i-1][j-1], calTriangle[i-1][j]);
        calTriangle[i][j] = triangle[i][j] + preFlourMax;

        if (i == length - 1) {
          answer = Math.max(answer, calTriangle[i][j]);
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution43105 solution = new Solution43105();
    int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    System.out.println(solution.solution(triangle));  // 30
  }
}
