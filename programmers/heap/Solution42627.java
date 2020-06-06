package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 디스크컨트롤러
public class Solution42627 {

  static class Job implements Comparable<Job> {

    private final int requestTime;
    private final int executionTime;

    public Job(int requestTime, int executionTime) {
      this.requestTime = requestTime;
      this.executionTime = executionTime;
    }

    public int getRequestTime() {
      return requestTime;
    }

    public int getExecutionTime() {
      return executionTime;
    }

    @Override
    public int compareTo(Job o) {
      return this.getExecutionTime() - o.getExecutionTime();
    }
  }

  public int solution(int[][] jobs) {
    int currentTime = 0;
    int jobIndex = 0;
    int sumExecutionTime = 0;
    Queue<Job> queue = new PriorityQueue<>();

    // 실행시간별 정렬
    Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    while (!queue.isEmpty() || jobIndex < jobs.length) {
      for (int i = jobIndex; i < jobs.length; i++) {
        int requestTime = jobs[i][0];
        if (requestTime > currentTime) {
          break;
        }
        queue.offer(new Job(requestTime, jobs[i][1]));
        jobIndex++;
      }

      if (!queue.isEmpty()) {
        Job job = queue.poll();
        sumExecutionTime += (currentTime - job.getRequestTime() + job.getExecutionTime());
        currentTime += job.getExecutionTime();
      } else {
        currentTime++;
      }
    }

    return sumExecutionTime / jobs.length;
  }

  public static void main(String[] args) {
    Solution42627 solution42627 = new Solution42627();
    // 9
    int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
    System.out.println("##### result : " + solution42627.solution(jobs));

    // 9
    jobs = new int[][]{{0, 6}, {0, 8}, {7, 1}};
    System.out.println("##### result : " + solution42627.solution(jobs));

    // 74
    jobs = new int[][]{{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2},
        {35, 43}, {26, 1}};
    System.out.println("##### result : " + solution42627.solution(jobs));
  }
}
