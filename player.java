
import java.util.*;

public class player {
	public static void main(String arg[]) {
	//	new HIndex().new Solution().solution(participant, completion)
	}
	
	class Solution {
	    public String solution(String[] participant, String[] completion) {
	       Arrays.sort(participant);
	       Arrays.sort(completion);
	       int i;
	       for(i = 0; i<completion.length;i++){
	    	   if(!participant[i].equals(completion[i]))
	    		   return participant[i];
	       }
	       return participant[i]; 
	    }
	}
}
class BinaryQ{
	class Solution {
	    public TreeNode searchBST(TreeNode root, int val) {
	        if(root == null)
	            return null;
	        if(root.val == val)
	            return root;
	        else if(root.val < val)
	            return searchBST(root.right,val);
	        else
	            return searchBST(root.left,val);
	    }
	}
}
