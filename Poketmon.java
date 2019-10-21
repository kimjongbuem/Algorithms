import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer1 = 0;
        int answer2 = nums.length/ 2;
        int type = -100;
        
        Arrays.sort(nums);
        
        for(int c : nums) {
        	if(c != type) {
        		type = c;
        		answer1++;
        	}
        }
        if(answer1 < answer2) return answer1; // type의 종류가 더 적은 경우
        return answer2;
    }
}

public class Poketmon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
