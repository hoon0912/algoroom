import java.util.Arrays;
class Solution {
    int[] root;
    public int solution(int n, int[][] computers) {
        root = new int[n];
        for(int i = 0; i<n;i++) root[i] = i;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(i != j && computers[i][j] == 1) union(i,j);
        for(int i = 0; i<n;i++) root[i] = find(root[i]);
        return (int) Arrays.stream(root).distinct().count();
    }
    private int find(int x){
        return (root[x] == x) ? x : (root[x] = find(root[x]));
    }
    private void union(int x, int y){
        int pX = find(x);
        int pY = find(y);
        if(pX != pY) root[Math.max(pX,pY)] = Math.min(pX,pY);
    }
}