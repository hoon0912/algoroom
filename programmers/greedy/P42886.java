import java.util.*;
class Solution {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        int len = weight.length-1;
        for(int i=0; i<len; i++){
            answer += weight[i];
            if(answer < weight[i+1]) break;
        }
        return (answer > weight[len] ? answer+weight[len] : answer);
    }
}