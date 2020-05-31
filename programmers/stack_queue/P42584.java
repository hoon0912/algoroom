class Solution{
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0, len = prices.length; i < len;  i++){
            for(int j = i+1; j < len; j++){
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
}