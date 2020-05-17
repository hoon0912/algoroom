import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution{
    private Integer[] countOfClothes;
    private int clothesCount;

    int solution(String[][] clothes){
        int answer = 0;
       countOfClothes = Arrays.stream(clothes).collect(Collectors.groupingBy(x->x[1])).values().stream().map(List::size).toArray(Integer[]::new);
        clothesCount = countOfClothes.length;

        for(int i = 1; i<=clothesCount; i++) answer += combination(0,i,1);

        return answer;
        // return Arrays.stream(clothes).collect(Collectors.groupingBy(x->x[1])).values().stream().map(List::size).reduce(1, (x,y)->x*(y+1))-1; // 안 입는 경우를 포함하고 계산 후 전부 안 입는 경우를 빼준다.
    }

    private int combination(int index, int r, int result){
        if(r==0)return result;
        else if(r>clothesCount-index) return 0;
        else return combination(index+1,r-1, result*countOfClothes[index]) + combination(index+1, r, result);
    }
}