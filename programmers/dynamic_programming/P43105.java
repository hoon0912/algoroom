import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
    public int solution(int[][] triangle) {
        IntStream.range(1,triangle.length).forEach(i->IntStream.range(0,triangle[i].length).forEach(j->triangle[i][j] = calculation(i,j,triangle)));
        return Arrays.stream(triangle).flatMapToInt(Arrays::stream).max().getAsInt();
    }

    private int calculation(int x, int y,int[][] triangle){
        return triangle[x][y] + ((y == 0) ? triangle[x-1][y] : (x==y) ? triangle[x-1][y-1] : Math.max(triangle[x-1][y-1],triangle[x-1][y]));
    }
}