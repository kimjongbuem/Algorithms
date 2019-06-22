
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
class name {
	class Solution {
		public TreeNode invertTree(TreeNode root) {
			if (root == null) {
				return null;
			}
			TreeNode right = invertTree(root.right);
			TreeNode left = invertTree(root.left);
			root.right = left;
			root.left = right;
			return root;
		}
	}
}
public class Que{
	public static void main(String[]args) {
		new HappyNumber().new Solution().isHappy(2);
	}
}
class HappyNumber {
	class Solution {
		public boolean isHappy(int n) {
			if (n == 1)
				return true;

			String sNum = Integer.toString(n);
			while (n != 1) {
				n = 0;
				for (int i = 0; i < sNum.length(); i++) {
					n += Math.pow(Character.getNumericValue(sNum.charAt(i)),2);
				}if(n == 4)
					return false;
				sNum = Integer.toString(n);
			}
			return true;
		}
	}
}