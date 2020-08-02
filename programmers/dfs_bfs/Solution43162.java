import java.util.Arrays;

class Solution43162 {
    private int[][] computers;
    
    private void dfs(int number, boolean[] visited) {
        visited[number] = true;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[number][i] == 1) {
                dfs(i, visited);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        boolean[] visited = new boolean[computers.length];
        Arrays.fill(visited, false);
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i, visited);
            }
        }
        
        return answer;
    }
}
