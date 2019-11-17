import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearchAlgorithm {

	public static void main(String[] args) {
		Graph g = new GraphSearchAlgorithm().new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(2, 1);
		g.addEdge(3, 1);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		g.bfs(3);

	}
	class Graph{
		class Node{
			boolean marked;
			int data;
			LinkedList<Node> adjacent;
			Node(int data){
				this.data = data;
				this.marked = false;
				adjacent = new LinkedList<Node>();
			}
		}
		Node[] nodes;
		public Graph(int size) {
			nodes = new Node[size];
			for(int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}
		void addEdge(int i1, int i2) {
			Node n1 = nodes[i1];
			Node n2 = nodes[i2];
			if(!n1.adjacent.contains(n2)) n1.adjacent.add(n2);
			if(!n2.adjacent.contains(n1)) n2.adjacent.add(n1);
		}
		void dfs(int index) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(nodes[index]);
			nodes[index].marked = true;
			
			while(!stack.empty()) {
				Node cur = stack.pop();
				visit(cur);
				for(Node n : cur.adjacent) {
					if(!n.marked) { 
					n.marked = true;
					stack.push(n);
					}
				}
			}
		}
		
		void bfs(int index) {
			Queue<Node> queue = new LinkedList<GraphSearchAlgorithm.Graph.Node>();
			queue.add(nodes[index]); nodes[index].marked = true;
			while(!queue.isEmpty()) {
				Node cur = queue.poll();
				visit(cur);
				for(Node n : cur.adjacent) {
					if(!n.marked) { 
					n.marked = true;
					queue.add(n);
					}
				}
			}
		}
		void dfsR(int index) {
			dfsR(nodes[index]);
		}
		void dfsR(Node r) {
			if(r == null) return;
			r.marked = true;
			visit(r);
			for(Node n : r.adjacent) {
				if(!n.marked) dfsR(n);
			}
		}
		
		void visit(Node n) {
			System.out.print(n.data+" ");
		}
	}
}
