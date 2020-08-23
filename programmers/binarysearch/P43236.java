import java.util.Arrays;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        //mid 제거해야하는 최소 간격
        int answer = Integer.MIN_VALUE;
        Arrays.sort(rocks);
        int left = 0, right = distance;
        while (left <= right){
            int mid = (left + right)/2;//제거해야하는 간격
            int removeRock = 0, minDiff = Integer.MAX_VALUE;
            for(int i= 0, prevRock = 0, len = rocks.length; i < len; i++){
                if(rocks[i]-prevRock < mid) removeRock++;
                else{
                    minDiff = Math.min(rocks[i]-prevRock, minDiff);
                    prevRock = rocks[i];
                }
            }
            if(removeRock <= n){
                left = mid+1;
                answer = Math.max(answer, minDiff);
            } 
            else right = mid-1;
        }
        return answer;
    }
}