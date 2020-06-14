import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(String op : operations){
            if(op.startsWith("I ")){//삽입
                maxHeap.add(Integer.parseInt(op.substring(2)));
                minHeap.add(Integer.parseInt(op.substring(2)));
            }else{//삭제
                if(!maxHeap.isEmpty() && Integer.parseInt(op.substring(2)) > 0){
                       minHeap.remove(maxHeap.poll());
                }else if((!minHeap.isEmpty() && Integer.parseInt(op.substring(2)) < 0)){
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        return new int[]{ (maxHeap.isEmpty() ? 0 : maxHeap.poll()), (minHeap.isEmpty() ? 0 : minHeap.poll())};
    }
}
