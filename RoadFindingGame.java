
import java.util.*;
public class RoadFindingGame {

	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		new RoadFindingGame().new Solution().solution(nodeinfo);

	}
//	class Solution {
//	    public int[][] solution(int[][] nodeinfo) {
//	        
//	        LinkedList<Node> nodelist = new LinkedList<Node>();
//	        for(int i = 0; i < nodeinfo.length;i++) {
//	        	nodelist.add(new Node(nodeinfo[i][0],nodeinfo[i][1], i + 1));
//	        }
//	        Collections.sort(nodelist);
//	        LinkedList<Integer> prefixList = new LinkedList<Integer>(); 
//	        prefix(nodelist, prefixList, 0); 
//	       int[] a1 = new int[prefixList.size()];
//	       for(int i = 0; i < prefixList.size();i++) {
//	    	   a1[i] = prefixList.get(i);
//	       } prefixList.clear();
//	       postfix(nodelist.get(0),prefixList);
//	       int[] a2 = new int[prefixList.size()];
//	       for(int i = 0; i < prefixList.size();i++) {
//	    	   a2[i] = prefixList.get(i);
//	       } 
//	       int[][] answer = new int[2][a2.length];
//	       for(int i = 0; i < a2.length; i++) {
//	    	   answer[0][i] = a1[i];
//	    	   answer[1][i] = a2[i];
//	       }
//	       
//	        return answer;
//	    }
//	    void postfix(Node n,LinkedList<Integer> prefixList) {
//	    	if(n == null) return;
//	    	
//	    	postfix(n.left, prefixList);
//	    	postfix(n.right, prefixList);
//	    	prefixList.add(n.value);
//	    }
//	    
//	    void prefix(LinkedList<Node> nodelist,LinkedList<Integer> prefixList, int idx) {
//	    	Node parent = nodelist.get(idx);
//	    	prefixList.add(nodelist.get(idx).value); // 전위
//	    	if(prefixList.size() > 7) {
//	    		System.out.println();
//	    	}
//	    	Node leftNode = null; Node rightNode = null; int left = -1; int right = -1;
//	    	if(parent.TopNode == null) {
//	    		for(int i = idx + 1; i < nodelist.size();i++) {
//	    			if(parent.xPos > nodelist.get(i).xPos &&  parent.yPos > nodelist.get(i).yPos) {
//	    				if(leftNode == null) {
//	    					leftNode = nodelist.get(i);
//	    					left = i;
//	    				}
//	    				else continue;
//	    			}
//	    			else if(parent.xPos < nodelist.get(i).xPos &&  parent.yPos > nodelist.get(i).yPos) {
//	    				if(rightNode == null) {
//	    					rightNode = nodelist.get(i);
//	    					right = i;
//	    				}
//	    				else continue;
//	    			}
//	    		}
//	    	}
//	    	else if(parent.TopNode.TopNode == null) {
//	    		Node up = parent.TopNode;
//	    		if(up.xPos > parent.xPos) {
//	    			for(int i = idx + 1; i < nodelist.size(); i++) {
//	    				if(parent.xPos > nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) {
//	    					if(leftNode == null) {
//	    						leftNode = nodelist.get(i);
//	    						left = i;
//	    					}
//	    					else continue; // ? 수정예상곳
//	    				}
//	    				else if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos &&
//	    						up.xPos > nodelist.get(i).xPos) {
//	    					if(rightNode == null) {
//	    						rightNode = nodelist.get(i);
//	    						right = i;
//	    					}
//	    				}
//	    			}
//	    		}else {
//	    			for(int i = idx + 1; i < nodelist.size(); i++) {
//	    				if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos&&
//	    						up.xPos < nodelist.get(i).xPos ) {
//	    					if(leftNode == null) {
//	    						leftNode = nodelist.get(i);
//	    						left = i;
//	    					}
//	    					else continue; // ? 수정예상곳
//	    				}
//	    				else if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) {
//	    					if(rightNode == null) {
//	    						rightNode = nodelist.get(i);
//	    						right = i;
//	    					}
//	    				}
//	    			}
//	    		}
//	    	}
//	    	else {
//	    		Node up = parent.TopNode; //Node upup = up.TopNode;
//	    		
//	    		
//	    		if(up.xPos > parent.xPos) {
//	    			for(int i = idx + 1; i < nodelist.size(); i++) {
//	    				if(parent.xPos > nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos&&
//	    					up.TopNode.xPos > nodelist.get(i).xPos ) {
//	    					if(leftNode == null) {
//	    						leftNode = nodelist.get(i);
//	    						left = i;
//	    					}
//	    					else continue; // ? 수정예상곳
//	    				}
//	    				else if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos) {
//	    					if(rightNode == null) {
//	    						rightNode = nodelist.get(i);
//	    						right = i;
//	    					}
//	    				}
//	    			}
//	    		}
//	    		else if(up.xPos < parent.xPos) {
//	    			for(int i = idx + 1; i < nodelist.size(); i++) {
//	    				if(parent.xPos > nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos &&
//	    						up.TopNode.xPos < nodelist.get(i).xPos ) { // left
//	    					if(leftNode == null) {
//	    						leftNode = nodelist.get(i);
//	    						left = i;
//	    					}
//	    				}
//	    				else if(parent.xPos < nodelist.get(i).xPos && parent.yPos > nodelist.get(i).yPos &&
//	    						up.TopNode.xPos > nodelist.get(i).xPos 
//	    						) {
//	    					if(rightNode == null) {
//	    						rightNode = nodelist.get(i);
//	    						right = i;
//	    					}
//	    				}
//	    			}
//	    		}
//	    	}
//	    	if(left == -1 && right == -1) return;
//	    	else if(left== -1) {
//	    		parent.right = rightNode;
//	    		rightNode.TopNode = parent;
//	    		prefix(nodelist, prefixList, right);
//	    	
//	    	}
//	    	else if(right== -1) {
//	    		parent.left= leftNode;
//	    		leftNode.TopNode = parent;
//	    		prefix(nodelist, prefixList, left);
//	    	}
//	    	else {
//	    		parent.left= leftNode;
//	    		parent.right= rightNode;
//	    		rightNode.TopNode = parent;
//	    		leftNode.TopNode = parent;
//	    		prefix(nodelist, prefixList, left); // 왼쪽 ㄱㄱ
//		    	prefix(nodelist, prefixList, right);// 오른쪽 ㄱㄱ
//	    	}
//	    }
//
//	    
//		class Node implements Comparable<Node>{
//			int xPos; int yPos;
//			int value; Node TopNode;
//			Node left, right;
//			Node(int x, int y ,int v){
//				xPos =x; yPos = y; value =v;
//			}
//
//			@Override
//			public int compareTo(Node o) {
//			if(yPos == o.yPos)return xPos - o.xPos;
//			else return o.yPos - yPos;
//			}
//		}   
//	} myCode;

	
	class Solution {
		int idx = 0;
	    public int[][] solution(int[][] nodeinfo) {
	        int[][] answer = new int[2][nodeinfo.length];  if ( nodeinfo == null || nodeinfo.length == 0 ) return answer;

	        int[] pre = new int[nodeinfo.length]; int[] post = new int[nodeinfo.length];
	        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) ->{
	        	return (n2.y > n1.y) ? 1 : (n1.y > n2.y) ? -1 : (n1.x > n2.x)? 1 : (n2.x > n1.x)? -1 :0;
	        });
	        Node head = null; Node cur = null; Node prev = null;
	        for(int i = 0; i < nodeinfo.length;i++) {
	        	pq.offer(new Node(nodeinfo[i][0],nodeinfo[i][1], i + 1));
	        }
        	head = pq.poll();
        	while(!pq.isEmpty()) {
        		cur = head;
        		Node node = pq.poll();
        		while(cur != null) {
        			if(node.x < cur.x) {
        				prev = cur;
        				cur = cur.left;
        			}
        			else if(node.x > cur.x) {
        				prev = cur;
        				cur = cur.right;
        			}
        		}
                if ( prev.left == null && node.x < prev.x ) prev.left = node;
                if ( prev.right == null && node.x > prev.x ) prev.right = node;
        	}
        	answer[0] = pre; answer[1] = post;
	        preOrder(head, pre);
	        idx = 0;
	        postOrder(head, post);
	        
	        return answer;
	    }
		void preOrder(Node cur, int[] pre) {
			if(cur == null) return;
			pre[idx++] = cur.idx;
			preOrder(cur.left, pre);
			preOrder(cur.right, pre);
		}
		void postOrder(Node cur, int[] post) {
			if(cur == null) return;
			postOrder(cur.left, post);
			postOrder(cur.right, post);
			post[idx++] = cur.idx;
		}
	    class Node{
	    	int x; int y; int idx;
	    	Node left, right;
	    	Node(int x, int y , int idx){
	    		this. x= x; this.y = y;
	    		this.idx = idx;
	    		left = null; right = null;
	    	}
	    }
	}
}
