import java.util.LinkedList;

public class LinkIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        LinkedList<Node> store = new LinkedList<Node>();
	        for(int i = 0;  i< n; i++) store.add(new Node(i)); 
	        for(int i = 0; i < costs.length; i++) {
	        	store.get(costs[i][0]).lines.add(new Line(store.get(costs[i][1]), costs[i][2]));
	        	store.get(costs[i][1]).lines.add(new Line(store.get(costs[i][0]), costs[i][2]));
	        }
	        int sum = 0;
	        while(sum < n) {
	        	
	        }
	        
	        return answer;
	    }
	    class Line{
	    	int cost;
	    	Node n;
	    	boolean checked;
	    	Line(Node n , int cost){
	    		this.n = n; this.cost = cost; checked = false;
	    	}
	    }
	    
	    class Node{
	    	int number; 
	    	LinkedList<Line> lines;
	    	boolean checked = false;
	    	Node(int number){
	    		this.number = number;
	    		lines = new LinkedList<Line>();
	    	}
	    }
	}
}
