import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
        public int[] solution(int[] array, int[][] commands) {
            return Arrays.stream(commands).mapToInt(x -> IntStream.range(1, array.length+1).filter(y->x[0] <= y).limit(x[1]-x[0]+1).map(y->array[y-1]).sorted().toArray()[x[2]-1]).toArray();
        }
}