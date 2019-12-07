
import java.util.Collections;
import java.util.LinkedList;

public class RoadFindingGame {

	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		new RoadFindingGame().new Solution().solution(nodeinfo);

	}
	class Solution {
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
	    	
	    	Node leftNode = null; Node rightNode = null; int left = -1; int right = -1;
	    	if(parent.TopNode == null) {
	    		for(int i = idx + 1; i < nodelist.size();i++) {
	    			if(parent.xPos > nodelist.get(i).xPos &&  parent.yPos > nodelist.get(i).yPos) {
	    				if(leftNode == null) {
	    					leftNode = nodelist.get(i);
	    					left = i;
	    				}
	    				else continue;
	    			}
	    			else if(parent.xPos < nodelist.get(i).xPos &&  parent.yPos > nodelist.get(i).yPos) {
	    				if(rightNode == null) {
	    					rightNode = nodelist.get(i);
	    					right = i;
	    				}
	    				else continue;
	    			}
	    		}
	    	}else {
	    		Node up = parent.TopNode;
	    		if(up.xPos > parent.xPos) {
	    			for(int i = idx + 1; i < nodelist.size(); i++) {
	    				if(parent.xPos > nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) {
	    					if(leftNode == null) {
	    						leftNode = nodelist.get(i);
	    						left = i;
	    					}
	    					else continue; // ? 수정예상곳
	    				}
	    				else if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) {
	    					if(rightNode == null) {
	    						rightNode = nodelist.get(i);
	    						right = i;
	    					}
	    				}
	    			}
	    		}
	    		else if(up.xPos < parent.xPos) {
	    			for(int i = idx + 1; i < nodelist.size(); i++) {
	    				if(parent.xPos > nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) { // left
	    					if(leftNode == null) {
	    						leftNode = nodelist.get(i);
	    						left = i;
	    					}
	    				}
	    				else if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) {
	    					if(rightNode == null) {
	    						rightNode = nodelist.get(i);
	    						right = i;
	    					}
	    				}
	    			}
	    		}
	    	}
	    	if(left == -1 && right == -1) return;
	    	else if(left== -1) {
	    		rightNode.TopNode = parent;
	    		prefix(nodelist, prefixList, right);
	    	
	    	}
	    	else if(right== -1) {
	    		leftNode.TopNode = parent;
	    		prefix(nodelist, prefixList, left);
	    	}
	    	else {
	    		rightNode.TopNode = parent;
	    		leftNode.TopNode = parent;
	    		prefix(nodelist, prefixList, left); // 왼쪽 ㄱㄱ
		    	prefix(nodelist, prefixList, right);// 오른쪽 ㄱㄱ
	    	}
	    }

	    
		class Node implements Comparable<Node>{
			int xPos; int yPos;
			int value; Node TopNode;
			
			Node(int x, int y ,int v){
				xPos =x; yPos = y; value =v;
			}

			@Override
			public int compareTo(Node o) {
			if(yPos == o.yPos)return xPos - o.xPos;
			else return o.yPos - yPos;
			}
		}   
	}
}
