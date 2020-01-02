import java.util.LinkedList;
import java.util.Queue;

public class FarNode {
	public static void main(String[] s) {
		int[][] edge = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};
		System.out.println(new FarNode().new Solution().solution(6, edge));
	}
	
	
	class Solution {
		
		
		int[] d;
		int index = 0;
	    public int solution(int n, int[][] edge) {
	        int answer = 0;
	        d = new int[n];
	        LinkedList<Node> nodeList = new LinkedList<Node>();
	        for(int i = 0; i < n;i++) nodeList.add(new Node(i)); // Node
	        for(int i = 0; i < edge.length;i++) {
	        	nodeList.get(edge[i][0] - 1).nodeList.add(nodeList.get(edge[i][1] - 1));
	        	nodeList.get(edge[i][1] - 1).nodeList.add(nodeList.get(edge[i][0] - 1));
	        }
	        
	        Queue<Node> q = new LinkedList<Node>();
	        q.add(nodeList.get(0)); d[index] = 0; q.peek().checked = true;
	        while(!q.isEmpty()) {
	        	Node node = q.poll(); index = node.idx;
	        	for(int i = 0; i < node.nodeList.size();i++) {
	        		Node temp = node.nodeList.get(i);
	        		if(!temp.checked) {
	        			temp.checked = true; 
	        			d[temp.idx] = d[index] + 1;
	        			q.add(temp);
	        		}
	        	}
	        }
	        int v = 0;
	        for(int i = 1; i < d.length;i++) {
	        	if(d[i] > v) {
	        		answer = 1;
	        		v = d[i];
	        	}else if(d[i] == v) {
	        		answer++;
	        	}
	        }
	        
	        return answer;
	    }
	}
	class Node{
		LinkedList<Node> nodeList;
		boolean checked;
		int idx;
		Node(int idx){
			checked =false;
			nodeList = new LinkedList<Node>();
			this.idx = idx;
		}
	}
}
