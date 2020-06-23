package bruteforce;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// 소수찾기
public class Solution42839 {

  public static ArrayList<Integer> list = new ArrayList<>();
  public static int ab = 0;
  // 2, 3, 421, 2341, 4231, 41, 43, 13, 431, 1423, 241, 23, 31, 2143]
  public void getNumber(int count, String currentNumber, String numbers, Set<String> checkNumber) {
    if (count == numbers.length()) {
      //System.out.println("n\t\t"+ currentNumber);
      if ("".equals(currentNumber)) return;
      if (!checkNumber.contains(currentNumber)) {
        checkNumber.add(currentNumber);
        if (isPrism(currentNumber)) {
          ab++;
          list.add(Integer.valueOf(currentNumber));
          //solution2(currentNumber);
        }
      }
      String tempNumber = new StringBuilder(currentNumber).reverse().toString();
      if (!checkNumber.contains(tempNumber)) {
        checkNumber.add(tempNumber);
        if (isPrism(tempNumber)) {
          ab++;
          list.add(Integer.valueOf(tempNumber));
          //solution2(tempNumber);
        }
      }
    } else if (count < numbers.length()) {

      getNumber(count+1, currentNumber, numbers, checkNumber);

      for (int i = 0; i < count; i++) {
        //System.out.println(currentNumber+"+"+numbers.charAt(i));
          getNumber(count+1, currentNumber + "" + numbers.charAt(i), numbers, checkNumber);
      }
    }
  }

  public int solution(String numbers) {
    Set<String> checkNumber = new HashSet<>();
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
      //System.out.println("TTT " + temp);

      for (int a = 0; a < length; a++) {
        getNumber(a,""+temp.charAt(a), temp, checkNumber);
      }
      break;
    }

//    for (int a = 0; a < length; a++) {
//      getNumber(a,"", numbers, checkNumber);
//    }

    answer = ab;
    return answer;
  }

  public int solution2(String numbers) {
    Set<String> checkNumber = new HashSet<>();
    int answer = 0;
    int length = numbers.length();

    for (int a = 0; a <= length; a++) {
      for (int b = a+1; b <= length; b++) {
        StringBuilder tempNumbers = new StringBuilder(numbers.substring(a,b));
        String num = tempNumbers.toString();
        if(!checkNumber.contains(num)) {
          checkNumber.add(num);
          System.out.println(tempNumbers + ">>" + isPrism(num));
          if (isPrism(num)){
            list.add(Integer.valueOf(num));
            answer++;
          }
        }

        num = tempNumbers.reverse().toString();
       // System.out.println(num );
        if(!checkNumber.contains(num)) {
          checkNumber.add(tempNumbers.reverse().toString());
          System.out.println(new StringBuilder(tempNumbers).reverse() + ">" + isPrism(num));
          if (isPrism(num)) {
            list.add(Integer.valueOf(num));
            answer++;
          }
        }

      }
    }

    return answer;
  }

  private boolean isPrism(String number) {
    int num = Integer.parseInt(String.valueOf(number));

    boolean isPrism = true;
    if (num <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        isPrism = false;
        break;
      }
    }
    return isPrism;
  }

  public static void main(String[] args) {
    Solution42839 solution = new Solution42839();
    //System.out.println("result:" + solution.solution("17")); // 3
    //System.out.println("result:" +solution.solution("011")); // 2
    //System.out.println("result:" +solution.solution("112")); // 3
    System.out.println("result:" +solution.solution("1234")); // 3
    list.sort(Comparator.naturalOrder());
    System.out.println(Arrays.toString(list.toArray()));
    int[] tempList = {2, 3, 421, 2341, 4231, 41, 43, 13, 431, 1423, 241, 23, 31, 2143};
    Arrays.sort(tempList);
    System.out.println(Arrays.toString(tempList));
  }
}
