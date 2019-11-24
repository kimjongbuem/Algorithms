import java.util.Collections;
import java.util.LinkedList;

public class LinkIsland {

	public static void main(String[] args) {
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(new LinkIsland(). new Solution().solution(4, costs));

	}
	class Solution {
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        LinkedList<Line> lines = new LinkedList<Line>(); 
	        LinkedList<Node> nodes = new LinkedList<Node>();
	        
	        for(int i = 0; i < n; i++) nodes.add(new Node(i));
	        
	        for(int i = 0; i < costs.length; i++) {
	        	lines.add(new Line(nodes.get(costs[i][0]),nodes.get(costs[i][1]),costs[i][2]));
	        }
	        Collections.sort(lines);
	        int sum = 0;
	        	for(int i = 0; i < lines.size() || sum < n; i++) {
	        		if(!lines.get(i).n1.checked && !lines.get(i).n2.checked) {
	        			lines.get(i).n1.checked = true; lines.get(i).n2.checked = true;
	        			answer += lines.get(i).cost;
	        			sum +=2;
	        		}else if(!lines.get(i).n1.checked || !lines.get(i).n2.checked) {
	        			lines.get(i).n1.checked = true; lines.get(i).n2.checked = true;
	        			answer += lines.get(i).cost;
	        			sum +=1;
	        		}else continue;
	        	}
	        
	        return answer;
	    }
	    class Line implements Comparable<Line>{
	    	int cost;
	    	Node n1, n2;
	    	Line(Node n1, Node n2,int cost){
	    		this.n1 = n1; this.n2 = n2; this.cost = cost;
	    	}
			@Override
			public int compareTo(Line o) {
				return cost - o.cost;
			}
	    }
	    
	    class Node{
	    	int number; 
	    	boolean checked = false;
	    	Node(int number){
	    		this.number = number;
	    	}
	    }
	}
}
