package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 모의고사
public class Solution42840 {

  static class Student implements Comparable<Student> {

    int number;
    int[] dap;
    int score;

    public Student(int number, int[] dap, int[] answers) {
      this.number = number;
      this.dap = dap;
      this.score = matching(answers);
    }

    public int matching(int[] answers) {
      int score = 0;
      for (int i = 0; i < answers.length; i++) {
        if (dap[i % dap.length] == answers[i]) {
          score++;
        }
      }
      return score;
    }

    @Override
    public int compareTo(Student o) {
      if (this.score == o.score) {
        return this.number - o.number;
      }
      return o.score - this.score;
    }
  }


  public int[] solution(int[] answers) {
    List<Integer> answer = new ArrayList<>();

    int[] student1 = {1, 2, 3, 4, 5};
    int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(new Student(1, student1, answers));
    priorityQueue.add(new Student(2, student2, answers));
    priorityQueue.add(new Student(3, student3, answers));

    int max = 0;
    while (!priorityQueue.isEmpty()) {
      Student student = priorityQueue.poll();
      if (max > student.score) break;
      if (max < student.score) {
        max = student.score;
      }
      answer.add(student.number);
    }

    return answer.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    Solution42840 solution = new Solution42840();
    int[] answers = new int[]{1, 2, 3, 4, 5};
    int[] result = solution.solution(answers);
    System.out.println(Arrays.toString(result));

    answers = new int[]{1, 3, 2, 4, 2};
    result = solution.solution(answers);
    System.out.println(Arrays.toString(result));
  }
}
