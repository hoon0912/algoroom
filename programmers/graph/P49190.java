import java.util.*;
class Solution {
    class Node{
        int x,y;
        Node(int x, int y){ this.x = x; this.y = y;}
        public boolean equals(Object obj) { return ((Node)obj).x ==x && ((Node)obj).y ==y; }
        public int hashCode() { return Objects.hash(x,y);}
    }
    class Edge{
        Node s,e;
        Edge(Node s, Node e){
            if(Math.max(s.hashCode(),e.hashCode()) == s.hashCode()){this.s = s; this.e = e;}
	else{this.s = e; this.e = s;}
        }
        public boolean equals(Object obj) { return ((Edge)obj).s.equals(s) &&((Edge)obj).e.equals(e); }
        public int hashCode() { return Objects.hash(s,e); }
    }
    int[][] move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public int solution(int[] arrows) {
        Set<Node> visitedNode = new HashSet<>();
        Set<Edge> visitedEdge = new HashSet<>();
        visitedNode.add(new Node(0,0));
        int ans = 0;
        for (int i = 0, x= 0, y=0; i <arrows.length ; i++) {
            for(int j = 0; j < 2; j++){
                Node prvNode = new Node(x,y);
                x += move[arrows[i]][0];
                y += move[arrows[i]][1];
                Node node = new Node(x, y);
                Edge edge = new Edge(prvNode, node);
                if(visitedNode.contains(node) && !visitedEdge.contains(edge))ans++;
                visitedEdge.add(edge);
                visitedNode.add(node);
            }
        }
        return ans;//오일러의 다면체 정리 (visitedEdge.size()-visitedNode.size()+1)
    }
}