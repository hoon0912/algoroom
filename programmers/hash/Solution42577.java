package hash;

import java.util.Arrays;

// 전화번호 목록
public class Solution42577 {
  public boolean solution(String[] phone_book) {
    boolean answer = true;
    Arrays.sort(phone_book);
    for (int i = 0; i < phone_book.length-1; i++) {
      String prefix = phone_book[i];
      for (int j = i+1; j < phone_book.length; j++) {
        String number = phone_book[j];
        if (number.startsWith(prefix)) {
          answer = false;
          return answer;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution42577 solution = new Solution42577();
    String[] phone_book = {"119", "97674223", "1195524421"}; // false
    System.out.println(solution.solution(phone_book));

    String[] phone_book2 = {"123", "456", "789"};  // true
    System.out.println(solution.solution(phone_book2));

    String[] phone_book3 = {"12", "123", "1235", "567", "88"}; // false
    System.out.println(solution.solution(phone_book3));
  }
}


==================================================================================================
  
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        
        for(int i=0; (answer && i < phone_book.length); i++) {
            String phoneNumber = phone_book[i];
            for(int k=i+1; k < phone_book.length; k++) {
                if (phone_book[k].startsWith(phoneNumber)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
