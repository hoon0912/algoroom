import java.util.*;
class Solution{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        public int solution(int[] scoville, int K) {
            int answer = 0;
            for(int x : scoville) pq.add(x);
            while (pq.peek() < K && pq.size() != 1) answer += pq.add(pq.poll() + pq.poll() * 2) ? 1:0;
            return pq.peek() < K ? -1 : answer;
        }
}
//===============================================================================================
class Solution{
        MinHeap minHeap = new MinHeap();
        public int solution(int[] scoville, int K) {
            int answer = 0;
            for(int x:scoville) minHeap.add(x);
            while (minHeap.peek() < K && minHeap.size != 1) answer += minHeap.add(minHeap.get() + minHeap.get() * 2);
            return minHeap.peek() < K ? -1 : answer;
        }
        class MinHeap{
            int[] heap = new int[2000002];
            int lastIndex = 0;
            int size = 0;
            int peek(){return heap[size != 0 ? 1 : 0];}
            int add(int scovulle){
                size++;
                heap[++lastIndex]  = scovulle;
                int childIdx = lastIndex;
                while(true){
                    int parentIdx = childIdx/2 == 0 ? 1 : childIdx/2;
                    if(heap[parentIdx] <= heap[childIdx]) break;
                    else{
                        changeChildToParent(childIdx, parentIdx);
                        childIdx = parentIdx;
                    }
                }
                return 1;
            }
            int get(){
                size--;
                if(lastIndex == 0) return -1;
                int minVal = heap[1];
                heap[1] = heap[lastIndex--];
                int parentIdx = 1;
                int childIdx = heap[2] < heap[3] ? 2:3;
                while (childIdx <= lastIndex){
                    if(heap[parentIdx] < heap[childIdx]) break;
                    else{
                        changeChildToParent(childIdx, parentIdx);
                        parentIdx = childIdx;
                        childIdx = heap[childIdx*2] < heap[childIdx*2+1] ? childIdx*2 : childIdx*2+1;
                    }
                }

                return minVal;
            }
            private void changeChildToParent(int child, int parent){
                int temp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = temp;
            }
        }
    }
