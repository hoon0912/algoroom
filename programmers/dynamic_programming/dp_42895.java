import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class dp_42895 {
    public static void main(String[] args) {
        System.out.println(solution(5,12));
    }

    public static int solution(int N, int number) {
        HashMap<Integer, Set<Integer>> tryMap = new HashMap<>();
        for(int tryCount=1; tryCount<=8; tryCount++){
            Set<Integer> temp = new HashSet<>();
            for(int i=1; i<=tryCount/2; i++){
                temp.addAll(getCombination(tryMap.get(i), tryMap.get(tryCount - i)));
            }
            temp.add(IntStream.iterate(N, i -> i * 10).limit(tryCount).sum());

            if (temp.stream().anyMatch(x -> x == number)) return tryCount;
            else tryMap.put(tryCount, temp);
        }
        return -1;
    }

    public static Set<Integer> getCombination(Set<Integer> a, Set<Integer> b) {
        Set<Integer> temp = new HashSet<>();
        for(int a_num : a){
            for(int b_num : b) {
                temp.add(a_num + b_num);
                temp.add(a_num * b_num);

                if (a_num != b_num) temp.add(Math.abs(a_num - b_num));
                temp.add((a_num > b_num) ? a_num / b_num : b_num / a_num);
            }
        }
        return temp;
    }
}
