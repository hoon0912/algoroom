import java.util.Arrays;
class Solution {
    int[][] path;
    public int solution(int m, int n, int[][] puddles) {
        path = new int[m+1][n+1];
        path[1][1] = 1;
        Arrays.stream(puddles).forEach(x->path[x[0]][x[1]] = -1);
        return searchPath(m,n);
    }
    private int searchPath(int x, int y){
        if(x < 1 || y < 1 || path[x][y] == -1) return 0; //øıµ¢¿Ã
        else if (path[x][y] > 0) return path[x][y];
        else return path[x][y] = (searchPath(x-1, y) + searchPath(x,y-1)) % 1000000007;// ¡ﬂ∞£ø° ø¨ªÍ«ÿ¡‡æﬂ«‘
    }
}