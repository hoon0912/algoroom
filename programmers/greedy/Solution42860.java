package greedy;

// 조이스틱
public class Solution42860 {
  public int solution2(String name) {
    int answer = 0;
    int minLeftRightMove = name.length() - 1;
    for (int i = 0; i < name.length(); i++) {
      char curChar = name.charAt(i);
      int moveFromA = curChar - 'A';
      int moveFromZ = 'Z' - curChar + 1;
      if (moveFromA < moveFromZ) {
        answer += moveFromA;
      } else {
        answer += moveFromZ;
      }

      if(curChar != 'A') {
        int nextIndex = i + 1;
        while(nextIndex < name.length() && name.charAt(nextIndex) == 'A') {
          nextIndex++;
        }
        int move = 2 * i + name.length() - nextIndex;
        minLeftRightMove = Math.min(move, minLeftRightMove);
      }

      //System.out.println("cur > "+curChar +"\t\t"+moveFromA+" \t\t"+moveFromZ+"\t\t"+answer);
    }
    return answer + minLeftRightMove;
  }

  public int solution(String name) {
    int answer = 0;
    int minLeftRightMove = name.length() - 1;
    for (int i = 0; i < name.length(); i++) {
      char curChar = name.charAt(i);
      int moveFromA = curChar - 'A';
      int moveFromZ = 'Z' - curChar + 1;
      if (moveFromA < moveFromZ) {
        answer += moveFromA;
      } else {
        answer += moveFromZ;
      }

      if(curChar != 'A') {
        int nextIndex = i + 1;
        while(nextIndex < name.length() && name.charAt(nextIndex) == 'A') {
          nextIndex++;
        }
        int move = 2 * i + name.length() - nextIndex;
        minLeftRightMove = Math.min(move, minLeftRightMove);
      }

      //System.out.println("cur > "+curChar +"\t\t"+moveFromA+" \t\t"+moveFromZ+"\t\t"+answer);
    }
    return answer + minLeftRightMove;
  }


  public static void main(String[] args) {
    Solution42860 solution = new Solution42860();
    System.out.println(solution.solution("JEROEN")); // 56
    System.out.println(solution.solution("JAN")); // 23

  }
}
