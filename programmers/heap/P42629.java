import java.util.*;
class Solution{
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int idx = 0;
        while (stock<k){
            for(; idx<dates.length && dates[idx] <= stock; idx++) pq.add(supplies[idx]);
            stock+=pq.poll();
            answer++;
        }
        return answer;
    }
}
//===============================================================================================
class Solution{
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        MaxHeap maxHeap = new MaxHeap();
        int answer = 0;
        int idx = 0;
        while(stock<k){
            for(; idx<dates.length && dates[idx] <= stock; idx++) maxHeap.add(supplies[idx]);
            stock+=maxHeap.get();
            answer++;
        }
        return answer;
    }

    class MaxHeap{
        int[] heap = new int[20000];
        int lastIdx = 1;
        void add(int amount){
            heap[lastIdx++] = amount;
            int childIdx = lastIdx-1;
            while (true){//1
                int parentIdx = (childIdx)/2 == 0 ? 1 : (childIdx)/2;
                if(heap[childIdx] > heap[parentIdx]){
                    changeChildParent(childIdx, parentIdx);
                    childIdx = parentIdx;
                }else{
                    break;
                }
            }
        }
        int get(){
            int maxVal = heap[1];
            heap[1] = heap[--lastIdx];
            int parent = 1;
            int child = heap[2] >= heap[3] ? 2 : 3;
            while (child < lastIdx){
                if(heap[parent] > heap[child]) break;
                else{
                    changeChildParent(child, parent);
                    parent = child;
                    child = heap[child*2] > heap[child*2+1] ? child*2 : child*2+1;
                }
            }
            return maxVal;
        }

        private void changeChildParent(int child, int parent){
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;
        }

    }
}
