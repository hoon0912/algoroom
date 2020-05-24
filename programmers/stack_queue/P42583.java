import java.util.*;
class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int time = 0;
            int nWeight = 0;
            for (int truck : truck_weights) {
                while (true){
                    time++;
                    if(bridge.size() == bridge_length) nWeight-=bridge.poll();
                    if(nWeight+truck<=weight){
                        bridge.add(truck);
                        nWeight+=truck;
                        break;
                    }else{
                        bridge.add(0);
                    }
                }

            }
            return time+bridge_length;
        }
}
=======================================================================================================
class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int time = 0;
            for (int truck : truck_weights) {
                while (true){
                    time++;
                    if(bridge.size() == bridge_length) bridge.poll();
                    if(queSum(bridge)+truck<=weight){
                        bridge.add(truck);
                        break;
                    }else{
                        bridge.add(0);
                    }
                }

            }
            return time+bridge_length;
        }
        private int queSum(Queue<Integer> q){
            Iterator<Integer> iter = q.iterator();
            int sum = 0;
            while (iter.hasNext()) sum +=iter.next();
            return sum;
        }
}
