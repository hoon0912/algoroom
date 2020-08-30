import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n+1];
        boolean[][] map = new boolean[n+1][n+1];//int로 하면 8,9번 터짐
        for(int[] x:edge) map[x[0]][x[1]] = map[x[1]][x[0]] = true;

        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);
        int maxDist = 0;
        while (!nodes.isEmpty()){
            for(int dst = 2, src = nodes.poll(); dst <= n; dst++){
                if(map[src][dst] && dist[dst] == 0){
                    dist[dst] = dist[src]+1;
                    maxDist = Math.max(dist[dst], maxDist);
                    nodes.add(dst);
                }
            }
        }
        for(int item : dist) if (maxDist == item) answer++;
        return answer;
    }
}