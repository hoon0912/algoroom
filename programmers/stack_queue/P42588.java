class Solution {
    public int[] solution(int[] heights) {
        int[] ans = new int[heights.length];
        for(int i = (heights.length-1); i>0; i--){
            for(int j = i-1; j>=0; j--){
                if(heights[i] < heights[j]){
                    ans[i]=j+1;
                    break;
                }
            }
        }
        return ans;
    }
}