
import java.util.Collections;
import java.util.LinkedList;

public class RoadFindingGame {

	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		new RoadFindingGame().new Solution().solution(nodeinfo);

	}
	class Solution {
		//Node topNode;
	    public int[][] solution(int[][] nodeinfo) {
	        int[][] answer = {};
	        LinkedList<Node> nodelist = new LinkedList<Node>();
	        for(int i = 0; i < nodeinfo.length;i++) {
	        	nodelist.add(new Node(nodeinfo[i][0],nodeinfo[i][0], i + 1));
	        }
	        Collections.sort(nodelist);
	       
	       // topNode = nodelist.get(0);
	       
	        
	        return answer;
	    }
	    LinkedList<Integer> prefix(LinkedList<Node> nodelist,LinkedList<Integer> prefixList, int idx) {
	    	int count = 0;
	    	Node parent = nodelist.get(idx);
	    	prefixList.add(nodelist.get(idx).value); // ÀüÀ§
	    	
	    	Node leftNode = null;
	    	for(int i = idx + 1; i < nodelist.size(); i++) {
	    		if(parent.xPos > nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) {
	    			if(leftNode == null) leftNode = nodelist.get(i); 
	    		}
	    	}
	    	
	    	return prefixList;
	    }
	    
		class Node implements Comparable<Node>{
			int xPos; int yPos;
			int value;
			Node(int x, int y ,int v){
				xPos =x; yPos = y; value =v;
			}
			
			@Override
			public int compareTo(Node o) {
				return o.yPos - yPos;
			}
		}   
	}
}
