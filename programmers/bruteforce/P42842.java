class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i = 2,carpetSize = brown+yellow; i<= carpetSize/2; i++)
            for (int j = i; j <= carpetSize/2; j++)
                if (i * 2 + (j - 2) * 2 == brown && (i - 2) * (j - 2) == yellow)
                    return new int[]{Math.max(i,j), Math.min(i,j)};
        return null;
    }
}
