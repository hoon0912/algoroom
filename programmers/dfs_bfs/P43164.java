import java.util.*;
import java.util.stream.IntStream;

class Solution {
    private PriorityQueue<String> ablePath = new PriorityQueue<>();
    public String[] solution(String[][] tickets) {
        IntStream.range(0,tickets.length).filter(x->tickets[x][0].equals("ICN")).forEach(x->{
            int[] isCheck = new int[tickets.length];
            isCheck[x] = 1;
            dfs(0, tickets[x][1], tickets[x][0]+"|"+tickets[x][1], isCheck, tickets);
        });
        return ablePath.poll().split("\\|");
    }

    private void dfs(int idx, String dst, String path, int[] isCheck, String[][] tickets) {
        if(Arrays.stream(isCheck).reduce((x,y)->x*y).getAsInt() != 0) ablePath.add(path);
        for(int i = 0, limit = tickets.length; i<limit; i++){
            if(isCheck[i] == 0 && dst.equals(tickets[i][0])){
                isCheck[i] = 1;
                dfs(idx++, tickets[i][1], path+"|"+tickets[i][1], isCheck, tickets);
                isCheck[i] = 0;
            }
        }
    }
}