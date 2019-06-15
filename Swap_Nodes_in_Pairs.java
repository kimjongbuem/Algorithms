


 class ListNode {
     int val;
      ListNode next;
     ListNode(int x) { val = x; }
 }


public class Swap_Nodes_in_Pairs {
	class Solution {
		 public ListNode swapPairs(ListNode head) {
		        int swapCount = 1;
		        ListNode preNode = null;
		        ListNode curNode = head;
		        if(head == null || head.next == null)
		        	return head;
		        while(curNode!= null) {
		        	if(swapCount % 2 == 0) {
		        		int temp = preNode.val;
		        		preNode.val = curNode.val;
		        		curNode.val = temp;
		        	}
		        	preNode = curNode;
		        	curNode = curNode.next;
		        	swapCount++;
		        }
		        return head;
		 }	 
	}
}
