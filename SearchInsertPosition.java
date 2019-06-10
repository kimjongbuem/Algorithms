
public class SearchInsertPosition {
	class Solution {
	    public int searchInsert(int[] nums, int target) {
	        int cnt = 0;
	    	for(int i = 0; i < nums.length; i++) {
	    		
	    	if(nums[i] == target) 
	        		return cnt;
	    	else if(i != 0 && (nums[i - 1] < target && nums[i] > target))
	    			return cnt;
	    	else if(i == nums.length - 1 && nums[i] < target)
	    			return ++cnt;
	    	else if(i == 0 && nums[i] > target)
	    			return cnt;
	    		cnt++;	
	        }
	    	return 0;
	    }
	}
}
