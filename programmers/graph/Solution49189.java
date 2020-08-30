package graph;

import java.util.LinkedList;
import java.util.Queue;

// 가장 먼 노드
public class Solution49189 {
  public int solution(int n, int[][] edge) {
    int answer = 0;

    Queue<Integer> queue = new LinkedList<>();
    boolean[][] connect = new boolean[n][n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < edge.length; i++){
      int v1 = edge[i][0]-1;
      int v2 = edge[i][1]-1;
      connect[v1][v2] = true;
      connect[v2][v1] = true;
    }

    queue.add(0);
    visited[0]=true;

    while (!queue.isEmpty()){
      int queueSize = queue.size();
      for ( int i = 0; i < queueSize; i++){
        int node = queue.poll();
        for (int j = 0; j < n; j++){
          if (!visited[j] && connect[j][node]){
            visited[j] = true;
            queue.add(j);
          }
        }
      }
      answer = queueSize;
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution49189 solution = new Solution49189();
    int n = 6;
    int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

    System.out.println(solution.solution(n, edge)); // 3
  }
}
