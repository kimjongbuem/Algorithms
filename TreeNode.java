
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      
      public static void main(String[] args) {
    	  TreeNode testNode = new TreeNode(1);
    	  testNode.left = new TreeNode(2);
    	  testNode.right = new TreeNode(3);
    	  testNode.left.left = null;
    	  testNode.left.right = new TreeNode(4);
    	  testNode.left.right.left = null;
    	  testNode.left.right.right = null;
    			  
    	  testNode.right.left = null;
    	  testNode.right.right = new TreeNode(5);
    	  testNode.right.right.left = null;
    	  testNode.right.right.right = null;
    	  
    	  if(new Solution().isCousins(testNode, 5, 4))
    		  System.out.println("성공");
    	  else
    		  System.out.println("실패");
      }
  }
 
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode leftNode = returnValueLeftNode(root);
        TreeNode rightNode = returnValueRightNode(root);
        if(leftNode.val == x && rightNode.val == y)
        	return true;
        return false;
    }
    public TreeNode returnValueLeftNode(TreeNode root) {
    	TreeNode returnLNode = null, returnRNode = null;
    	if(root.left == null || root.right == null)
    		return root;
    	 if(root.left != null)
    		 returnLNode = returnValueLeftNode(root.left);
    	 if(root.right != null)
    		 returnRNode = returnValueRightNode(root.right);
    	 
    	 if(returnLNode != null && returnRNode !=null)
    		 return returnLNode;
    	 else
    		 return returnRNode;
    }
	public TreeNode returnValueRightNode(TreeNode root) {
		TreeNode returnLNode = null, returnRNode = null;
    	if(root.left == null || root.right == null)
    		return root;
    	 if(root.left != null)
    		 returnLNode = returnValueLeftNode(root.left);
    	 if(root.right != null)
    		 returnRNode = returnValueRightNode(root.right);
    	 
    	 if(returnLNode != null && returnRNode !=null)
    		 return returnRNode;
    	 else
    		 return returnLNode;
	}
}
