import java.util.Arrays;

public class heap_42628 {
    public static void main(String[] args) {
        String[] operations = {"I 16","D 1"};
        int[] result = solution(operations);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(String[] operations) {
        Heap minHeap = new Heap(1000000, 0);
        for(String operation : operations) {
            String command = operation.split(" ", 2)[0];
            String value = operation.split(" ", 2)[1];

            if (command.equals("I")) { // insert
                minHeap.insert(Integer.parseInt(value));
            }
            else if (command.equals("D") && !minHeap.isEmpty()) {  // Delete
                if (value.equals("1")) {  // max
                    minHeap.deleteLast();
                }
                else if (value.equals("-1")) {  // min
                    minHeap.delete();
                }
            }
        }

        int[] answer = {0, 0};
        if (!minHeap.isEmpty()) answer[0] = minHeap.deleteLast();
        if (!minHeap.isEmpty()) answer[1] = minHeap.delete();
        return answer;
    }

    public static class Heap {
        private int[] nodes;
        private int maxNodeCount;
        private int nextIdx;
        private int heapType;

        public Heap(int n, int heapType) {
            this.nodes = new int[n];
            this.maxNodeCount = n;
            this.nextIdx = 0;
            this.heapType = heapType;
        }

        public int insert(int data) {
            if (nextIdx < maxNodeCount) {
                nodes[nextIdx++] = data;
                sortSiblings();
                bottomUpCheck();
                return 1;
            }
            return -1;
        }

        private void sortSiblings() {
            int recentIdx = nextIdx - 1;
            int recentValue = nodes[recentIdx];

            int beforeIdx = recentIdx - 1;
            // find
            while(beforeIdx > 0 && nodes[beforeIdx] > nodes[recentIdx]) {
                beforeIdx--;
            }
            // move
            for(int i=recentIdx-1; (i > 0 && i > beforeIdx); i--) {
                nodes[i+1] = nodes[i];
            }
            nodes[beforeIdx + 1] = recentValue;
        }

        private void bottomUpCheck() {
            for(int childIdx = nextIdx - 1; childIdx > 0;) {
                int parentIdx=(childIdx-1)/2;

                if(validate(parentIdx, childIdx)) break;
                else {
                    swap(parentIdx, childIdx);
                    childIdx = parentIdx;
                }
            }
        }

        public int delete() {
            if (nextIdx == 0) return -1;
            int rootData = nodes[0];
            nodes[0] = nodes[--nextIdx];
            topDownCheck();
            return rootData;
        }

        public int deleteLast() {
            if (nextIdx == 0) return -1;
            int lastData = nodes[--nextIdx];
            return lastData;
        }

        private void topDownCheck() {
            for(int parentIdx=0; parentIdx < nextIdx;) {
                int leftChildIdx = getLeftChildIdx(parentIdx);
                int rightChildIdx = getRightChildIdx(parentIdx);

                int nextParentIdx = getParentIdxFromChilds(parentIdx, leftChildIdx, rightChildIdx);
                if (nextParentIdx != -1) {
                    swap(parentIdx, nextParentIdx);
                    parentIdx = nextParentIdx;
                } else break;
            }
        }

        private int getLeftChildIdx(int parentIdx) {
            int leftIdx = 2 * parentIdx + 1;
            if (leftIdx < nextIdx) return leftIdx;
            else return -1;
        }

        private int getRightChildIdx(int parentIdx) {
            int rightIdx = 2 * parentIdx + 2;
            if (rightIdx < nextIdx) return rightIdx;
            else return -1;
        }

        private int getParentIdxFromChilds(int parentIdx, int leftChildIdx, int rightChildIdx) {
            int candidateIdx = -1;

            if (leftChildIdx == -1 && rightChildIdx == -1) return -1;
            else if (leftChildIdx != -1 && rightChildIdx == -1) candidateIdx = leftChildIdx;
            else if (leftChildIdx == -1 && rightChildIdx != -1) candidateIdx = rightChildIdx;
            else {
                if (this.heapType == 0) {
                    candidateIdx = (nodes[leftChildIdx] <= nodes[rightChildIdx])? leftChildIdx : rightChildIdx;
                }
                else candidateIdx = (nodes[leftChildIdx] >= nodes[rightChildIdx])? leftChildIdx : rightChildIdx;
            }

            if(!validate(parentIdx, candidateIdx)) return candidateIdx;
            return -1;
        }

        private boolean validate(int parentIdx, int childIdx) {
            if (this.heapType == 0) { // min heap
                return nodes[parentIdx] < nodes[childIdx];
            } else { // max heap
                return nodes[parentIdx] > nodes[childIdx];
            }
        }


        private void swap(int parentIdx, int childIdx) {
            int temp = nodes[parentIdx];
            nodes[parentIdx] = nodes[childIdx];
            nodes[childIdx] = temp;
        }

        public boolean isEmpty() {
            return nextIdx == 0;
        }

        public int peek() {
            if (this.nextIdx != 0) return nodes[0];
            return -1;
        }
    }
}
