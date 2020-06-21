package bruteforce;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 소수찾기
public class Solution42839 {

  public int solution(String numbers) {
    Set<Integer> checkNumber = new HashSet<>();
    int answer = 0;
    int length = numbers.length();
    for (int i = 0; i < length; i++) {

      String temp = "";
      for (int j = i; j < length; j++) {
        temp += numbers.charAt(j);
      }
      for (int j = 0; j < i; j++) {
        temp += numbers.charAt(j);
      }


      if (!temp.startsWith("0") && !checkNumber.contains(Integer.valueOf(temp))) {
        System.out.println("i "+i+"> "+ numbers  + " ==> "+ temp);
        if(isPrime(Integer.valueOf(temp))) answer++;
      }
    }

    for (int i = 0; i < length; i++) {
      if (numbers.charAt(i) != '0' && !checkNumber.contains(Integer.valueOf(numbers.charAt(i)))) {
        System.out.println("???" + numbers.charAt(i) +"-->"+isPrime(numbers.charAt(i)));
        if(isPrime(numbers.charAt(i))) answer++;
      }
    }

    return answer;
  }

  public boolean isPrime(int number) {
    if (number == 1) {
      return false;
    }
    if (number == 2) {
      return true;
    }
    if (number % 2 == 0) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    Solution42839 solution = new Solution42839();
    System.out.println(solution.solution("17")); // 3
    System.out.println(solution.solution("011")); // 2
  }
}
