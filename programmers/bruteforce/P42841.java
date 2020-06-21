import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int solution(int[][] baseball) {
        return (int) IntStream.range(123,988)
                .filter(x->(x/100 != x/10%10) && (x/10%10 != x-(x/10)*10) && (x/100 != x-(x/10)*10))
                .filter(x->(x/100 != 0) && (x/10%10 != 0) && (x-(x/10)*10 != 0))
                .filter(candidate->{
                    int[] x = new int[]{candidate/100, candidate/10%10, candidate-(candidate/10)*10};
                    return Arrays.stream(baseball).map(match->{
                        int[] matchItem = new int[]{match[0]/100, match[0]/10%10, match[0]-(match[0]/10)*10};
                        int strike = (int) IntStream.range(0,3).filter(y->x[y] == matchItem[y]).count();
                        int ball = (int) Arrays.stream(x).filter(y -> Arrays.stream(matchItem).anyMatch(z->z==y)).count()-strike;
                        return match[1] == strike && match[2] == ball;
                    }).reduce((y,z)->y&&z).get();
                }).count();
    }
}