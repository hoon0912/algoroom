import java.util.*;

public class sort_42746 {
    public static void main(String[] args) {
        int[] numbers = {6,10,2};
        String result = solution(numbers);
        System.out.println(result);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.concat(o2).compareTo(o2.concat(o1));
            }
        });
        for(int num : numbers) pq.add(String.valueOf(num));
        while(!pq.isEmpty()) {
            String temp = pq.poll();
            if (!answer.equals("0")) {
                answer += temp;
            }
        }
        return answer;
    }
}
