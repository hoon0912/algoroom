import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int answer = 0;
        for(int i = 0, len = routes.length, minEnd = -30001; i<len; i++){
            int[] route = routes[i];
            if(route[0]<=minEnd){//중복된 범위
                minEnd = Math.min(route[1],minEnd);
            }else{//중복되지 않은 범위
                answer++;
                minEnd = route[1];
            }
        }
        return answer;
    }
}