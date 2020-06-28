import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public String solution(String number, int k) {
        Queue<Character> candidate = new LinkedList<>();
        Stack<Character> complete = new Stack<>();
        IntStream.range(0,number.length()).forEach(x->candidate.add(number.charAt(x)));

        while (!candidate.isEmpty() && k > 0 ){
            while(k>0 && !complete.isEmpty() && complete.peek() < candidate.peek()){
                complete.pop();
                k--;
            }
            complete.push(candidate.poll());
        }

        if(candidate.isEmpty()) for (;k > 0; k--) complete.pop();
        else while (!candidate.isEmpty()) complete.push(candidate.poll());

        return complete.stream().map(Object::toString).reduce((acc, x)-> acc+x).get();
    }
}