
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
	        	nodelist.add(new Node(nodeinfo[i][0],nodeinfo[i][1], i + 1));
	        }
	        Collections.sort(nodelist);
	        LinkedList<Integer> prefixList = new LinkedList<Integer>(); 
	        prefix(nodelist, prefixList, 0); 
	       
	        
	        return answer;
	    }
	   void prefix(LinkedList<Node> nodelist,LinkedList<Integer> prefixList, int idx) {
	    	Node parent = nodelist.get(idx);
	    	prefixList.add(nodelist.get(idx).value); // 전위
	    	
	    	Node leftNode = null; int leftIdx = -1;
	    	for(int i = idx + 1; i < nodelist.size(); i++) {
	    		if(parent.TopNode == null) {
	    			if(leftNode == null) {
    					leftNode = nodelist.get(i);
	    				leftIdx = i;
    				}else {
    					if(leftNode.xPos > nodelist.get(i).xPos && leftNode.yPos <= nodelist.get(i).yPos) {
							leftNode = nodelist.get(i); leftIdx = i;
						}
    				}
	    			
	    		}
	    		else if(parent.xPos > nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos&&
						parent.TopNode.xPos > nodelist.get(i).xPos) {
	    			if(leftNode == null) {
    					leftNode = nodelist.get(i);
	    				leftIdx = i;
    				}	
    				else {
    						if(leftNode.xPos < nodelist.get(i).xPos && leftNode.yPos <= nodelist.get(i).yPos) {
    							leftNode = nodelist.get(i); leftIdx = i;
    						}
    					}
    				}
	    		}
	    	
	    	
	    	
	    	Node rightNode = null; int rightIdx = -1;
	    	for(int i = idx + 1; i < nodelist.size(); i++) { 
	    		if(parent.TopNode == null) {
	    			if(rightNode == null) {
    					rightNode = nodelist.get(i);
	    				rightIdx = i;
    				}
    				else {
    						if(rightNode.xPos < nodelist.get(i).xPos && rightNode.yPos <= nodelist.get(i).yPos) {
    							rightNode = nodelist.get(i);
    							rightIdx = i;
    						}
    				}
	    		}

	    		else if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos&&
						parent.TopNode.xPos > nodelist.get(i).xPos ) {
	    				if(rightNode == null) {
	    					rightNode = nodelist.get(i);
		    				rightIdx = i;
	    				}
	    				else {
	    						if(rightNode.xPos > nodelist.get(i).xPos && rightNode.yPos <= nodelist.get(i).yPos) {
	    							rightNode = nodelist.get(i); rightIdx = i;
	    						}
	    				}
	    		}
	    	}
	    	if(leftIdx == -1 && rightIdx == -1) return;
	    	else if(leftIdx == -1) {
	    		rightNode.TopNode = parent;
	    		prefix(nodelist, prefixList, rightIdx);
	    	
	    	}
	    	else if(rightIdx == -1) {
	    		leftNode.TopNode = parent;
	    		prefix(nodelist, prefixList, leftIdx);
	    	}
	    	else {
	    		rightNode.TopNode = parent;
	    		leftNode.TopNode = parent;
	    		prefix(nodelist, prefixList, leftIdx); // 왼쪽 ㄱㄱ
		    	prefix(nodelist, prefixList, rightIdx);// 오른쪽 ㄱㄱ
	    	}
	    
	    }
		class Node implements Comparable<Node>{
			int xPos; int yPos;
			int value; Node TopNode;
			boolean checked = false;
			
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
