package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
public class Solution42583 {

  static class Truck {
    private int weight;
    private int time;

    public Truck(int weight, int time) {
      this.weight = weight;
      this.time = time;
    }

    public int getWeight() {
      return weight;
    }

    public int getTime() {
      return time;
    }


    @Override
    public String toString() {
      return "Track{" +
          "weight=" + weight +
          ", time=" + time +
          '}';
    }
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Truck> bridgeQueue = new LinkedList<>();
    int currentTime = 0;
    int currentBridgeWeight = 0;
    int truckIndex = 0;

    while (truckIndex < truck_weights.length || !bridgeQueue.isEmpty()){
      currentTime++;
      if(!bridgeQueue.isEmpty()) {
        Truck truck = bridgeQueue.peek();
        if(currentTime - truck.getTime() >= bridge_length) {
          currentBridgeWeight -= truck.getWeight();
          bridgeQueue.poll();
        }
      }

      if(truckIndex < truck_weights.length && currentBridgeWeight + truck_weights[truckIndex] <= weight) {
          bridgeQueue.offer(new Truck(truck_weights[truckIndex], currentTime));
          currentBridgeWeight += truck_weights[truckIndex];
          truckIndex++;
      }

    }
    return currentTime;
  }

  public static void main(String[] args) {
    Solution42583 solution42583 = new Solution42583();

    // 8
    int bridge_length = 2;
    int weight = 10;
    int[] truck_weights = new int[]{7,4,5,6};
    System.out.println(solution42583.solution(bridge_length, weight, truck_weights));

    // 101
    bridge_length = 100;
    weight = 100;
    truck_weights = new int[]{10};
    System.out.println(solution42583.solution(bridge_length, weight, truck_weights));

    // 110
    bridge_length = 100;
    weight = 100;
    truck_weights = new int[]{10,10,10,10,10,10,10,10,10,10};
    System.out.println(solution42583.solution(bridge_length, weight, truck_weights));
  }
}
