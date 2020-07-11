import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    Set<Integer>[] dp = new HashSet[9];
    public int solution(int N, int number) {
        for(int i = 1; i <= 8; i++){
            dp[i] = new HashSet<>();
            dp[i].add(Integer.parseInt(IntStream.range(0,i).mapToObj(x->String.valueOf(N)).reduce((x,y)->x+y).get()));
        }
        for(int i = 1; i <= 8; i++){
            for(int j = 1, count = i+j; j<=i && count <= 8; j++, count = i+j){
                for (int x : dp[i]) {
                    for (int y : dp[j]) {
                        dp[count].add(x + y);
                        dp[count].add(x * y);
                        if (Math.abs(x - y) != 0) dp[count].add(Math.abs(x - y));
                        if (x / y != 0) dp[count].add(x / y);
                        if (y / x != 0) dp[count].add(y / x);
                    }
                }
            }
        }
        return IntStream.range(1,9).filter(x->dp[x].contains(number)).findFirst().orElse(-1);
    }
}