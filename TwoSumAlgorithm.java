
public class TwoSumAlgorithm {
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        for(int num1 = 0; num1 < nums.length -1; num1++){
	             for(int num2 = num1 + 1; num2 < nums.length; num2++){
	                if(nums[num1] + nums[num2] == target){
	                    int[] twoSumResult = {num1, num2};
	                    return twoSumResult;
	                }
	             }       
	        }
	        return null;
	    }
	}
}
