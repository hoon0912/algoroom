import java.util.*;
class Solution {
    Set<Integer> candidates = null;
    String[] pieceOfPaper;
    public int solution(String numbers) {
        candidates = new HashSet<>();
        pieceOfPaper = numbers.split("");
        dfs(new boolean[pieceOfPaper.length], new StringBuilder());
        candidates.forEach(System.out::println);
        return (int) candidates.stream().filter(x->x>1).count();
    }

    private void dfs(boolean[] visited, StringBuilder candicate){
        if(candicate.length() != 0 && isPrime(Integer.parseInt(candicate.toString()))) candidates.add(Integer.parseInt(candicate.toString()));
        for(int i = 0; i < pieceOfPaper.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(visited, candicate.append(pieceOfPaper[i]));
                visited[i] = false;
                candicate.deleteCharAt(candicate.length()-1);
            }
        }
    }
    private boolean isPrime(int num){
        for (int i = 2,lastNum = (int)Math.sqrt(num); i<=lastNum; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}