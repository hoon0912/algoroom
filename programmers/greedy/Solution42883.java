package greedy;

// 큰 수 만들기
public class Solution42883 {
  public String solution(String number, int k) {
    StringBuilder sb = new StringBuilder();

    char max;
    int index = 0;

    for(int i = 0; i < number.length() - k; i++) {
      max = '0';
      for(int j = index; j <= i + k; j++) {
        if(max < number.charAt(j)) {
          max = number.charAt(j);
          index = j + 1;
        }
      }
      sb.append(max);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Solution42883 solution = new Solution42883();
    String result = solution.solution("1924", 2); // 94
    System.out.println("result : "+ result);

    result = solution.solution("1231234", 3); // 3234
    System.out.println("result : "+ result);

    result = solution.solution("4177252841", 4); // 775841
    System.out.println("result : "+ result);
  }
}
