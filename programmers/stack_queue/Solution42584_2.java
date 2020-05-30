package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution42584 {

  static class Price {
    private int price;
    private int index;

    public Price(int price, int index) {
      this.price = price;
      this.index = index;
    }

    public int getPrice() {
      return price;
    }

    public int getIndex() {
      return index;
    }

    @Override
    public String toString() {
      return "Price{" +
          "price=" + price +
          ", index=" + index +
          '}';
    }
  }

  public int[] solution(int[] prices) {
    List<Integer> answer = new ArrayList<>();
    Queue<Price> queue = new LinkedList<>();
    for (int i = 0; i < prices.length; i++) {
      queue.offer(new Price(prices[i], i));
    }

    while (!queue.isEmpty()) {
      Price curPrice = queue.poll();
      int count = (int) queue.stream().filter(p -> (curPrice.getPrice() <= p.getPrice())).count();
      //System.out.println("["+curPrice.getIndex()+"] "+curPrice.getPrice()+" > " + count+"\n\t" +queue.toString());
      answer.add(count);
    }

    return answer.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    Solution42584 solution42584 = new Solution42584();

    // [4, 3, 1, 1, 0]
    int[] prices = new int[]{1, 2, 3, 2, 3};
    int[] answer = solution42584.solution(prices);
    System.out.println(Arrays.toString(answer));
  }
}
