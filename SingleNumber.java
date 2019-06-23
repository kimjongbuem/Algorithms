import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleNumber {
	public static void main(String[] args) {
		int [] nums = {1,2,1,3,2,5};
		int[] result = new SingleNumber().new Solution().singleNumber(nums);
		for(int i : result)
		System.out.print(nums[i]+"\t");
	}

	class Solution {
		public int[] singleNumber(int[] nums) {
			boolean check;
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				check = true;
				for (int j = 0; j < nums.length; j++) {
					if (i == j)
						continue;
					if (nums[i] == nums[j]) {
						check = false;
						break;
					}
				}
				if (check)
					list.add(nums[i]);
			}
			int[] result = new int[list.size()];
			int j = 0;
			for(Iterator<Integer> iter = list.iterator(); iter.hasNext();j++) {
				result[j] = iter.next();
			}
			return result;
				
		}
	}
}
