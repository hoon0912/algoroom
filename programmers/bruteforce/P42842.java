class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i = 1,carpetSize = brown+yellow; i<= carpetSize; i++) {
            for (int j = i; j <= carpetSize; j++) {
                if (i * 2 + (j - 2) * 2 == brown && (i - 2) * (j - 2) == yellow) {
                    return new int[]{Math.max(i,j), Math.min(i,j)};
                }
            }
        }
        return null;
    }
}