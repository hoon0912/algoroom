import java.util.LinkedList;
import java.util.Queue;

public class dfsbfs_43162 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,1},{0,1,1}};
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            q.add(i);
            while (!q.isEmpty()) {
                int current_node = q.poll();
                for(int j=0; j<n; j++) {
                    if (computers[current_node][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
