import java.util.LinkedList;
import java.util.Queue;

public class Network {

	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};  //{1, 1, 0}, {1, 1, 0}, {0, 0, 1}
		System.out.println(new Network().new Solution().solution(3, computers));

	}

	class Solution {
	    public int solution(int n, int[][] computers) {
	    	LinkedList<Node> nodeList = new LinkedList<Node>();
	    	for(int i = 0; i < n; i++) {
	    		 nodeList.add(new Node(i));
	    	}
	    	
	    	for(int i = 0; i < computers.length; i++) {
	    		for(int j = 0; j < computers[0].length; j++) {
		    		if( i == j || computers[i][j] == 0) continue;
		    		AddEdge(nodeList, i, j);
		    	}
	    	}
	    	
	    	int answer = 0;
	    	for(int i = 0; i < n; i++) {
	    		Node node = nodeList.get(i);
	    		if(!node.marked) {
	    			bfs(node); answer++;
	    		}
	    	}
	        return answer;
	    }
	    void bfs(Node n) {
	    	Queue<Node> queue = new LinkedList<Node>();
	    	n.marked = true;
	    	queue.add(n);
	    	while(!queue.isEmpty()) {
	    		Node q = queue.poll();
	    		for(Node d : q.list) {
	    			if(!d.marked) {
	    				d.marked = true;
	    				queue.add(d);
	    			}
	    		}
	    	}
	    }
	    
	    void AddEdge(LinkedList<Node> nodeList, int i1, int i2) {
    		Node n1 = nodeList.get(i1); Node n2 = nodeList.get(i2);
	    	if(!n1.list.contains(n2)) n1.list.add(n2);
	    	if(!n2.list.contains(n1)) n2.list.add(n1);
    	}
	    class Node{
	    	public int number;
	    	public LinkedList<Node> list;
	    	public boolean marked;
	    	Node(int number){
	    		this.number = number;
	    		marked = false;
	    		list = new LinkedList<Node>();
	    	}
	    	
	    }
	}
}
