import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class graph_49190 {
    public static double[] x_direction = {0,0.5,0.5,0.5,0,-0.5,-0.5,-0.5};
    public static double[] y_direction = {0.5,0.5,0,-0.5,-0.5,-0.5,0,0.5};
    public static int count = 0;

    public static void main(String[] args) {
        int[] arrows = {6,6,6,6,3,3,1,1,6,7,5,5,2,2,2,2,7};  // star
        System.out.println(solution(arrows));
    }

    public static int solution(int[] arrows) {
        HashMap<Node, Boolean> node_visit_map = new HashMap<>();
        HashMap<Node, ArrayList<Node>> edge_map = new HashMap<>();
        HashMap<Node, ArrayList<Boolean>> edge_visit_map = new HashMap<>();

        double x = 0; double y = 0;
        Node prev = new Node(x, y);
        node_visit_map.put(prev, false);
        for(int arrow : arrows) {
            Node node = get_next_node(x, y, arrow);
            node_visit_map.put(node, false);


            if (!edge_map.getOrDefault(prev, new ArrayList<>()).contains(node)) {
                edge_map.computeIfAbsent(prev, i -> new ArrayList<>()).add(node);
                edge_visit_map.computeIfAbsent(prev, i -> new ArrayList<>()).add(false);
                edge_map.computeIfAbsent(node, i -> new ArrayList<>()).add(prev);
                edge_visit_map.computeIfAbsent(node, i -> new ArrayList<>()).add(false);
            }
            x = node.getX(); y = node.getY();
            prev = node;

            // 절반

            Node node2 = get_next_node(x, y, arrow);
            node_visit_map.put(node2, false);

            if (!edge_map.getOrDefault(prev, new ArrayList<>()).contains(node2)) {
                edge_map.computeIfAbsent(prev, i -> new ArrayList<>()).add(node2);
                edge_visit_map.computeIfAbsent(prev, i -> new ArrayList<>()).add(false);
                edge_map.computeIfAbsent(node2, i -> new ArrayList<>()).add(prev);
                edge_visit_map.computeIfAbsent(node2, i -> new ArrayList<>()).add(false);
            }
            x = node2.getX(); y = node2.getY();
            prev = node2;
        }

        Stack<Node> s = new Stack<>();
        s.add(new Node(0,0));
        while (!s.isEmpty()) {
            Node current_node = s.pop();

            if (node_visit_map.get(current_node)) count++;
            node_visit_map.put(current_node, true);

            ArrayList<Node> next_node_list = edge_map.get(current_node);
            ArrayList<Boolean> next_visit_list = edge_visit_map.get(current_node);
            for(int i=0; i<next_visit_list.size(); i++) {
                if (!next_visit_list.get(i)) {
                    Node next_node = next_node_list.get(i);

                    next_visit_list.set(i, true);
                    edge_visit_map.get(next_node).set(edge_map.get(next_node).indexOf(current_node), true);

                    s.push(next_node);
                }
            }
        }
        return count;
    }

    public static Node get_next_node(double current_x, double current_y, int direction) {
        double x = current_x + x_direction[direction];
        double y = current_y + y_direction[direction];
        return new Node(x, y);
    }


    public static class Node {
        private final double x;
        private final double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node target = (Node)o;
            return x == target.getX() && y == target.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
}
