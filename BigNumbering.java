

public class BigNumbering {

	public static void main(String[] args) {
		Solution s = new BigNumbering().new Solution();
		int numbers[] = {6,10,2};
		String str =s.solution(numbers);
		System.out.println(str);

	}
	class Solution {
		   public String solution(int[] numbers) {
		      StringBuilder bs = new StringBuilder();
		       for(int n = 0; n < numbers.length; n++) {
		    	   bs.append(Integer.toString(numbers[n]));
		       }
			   String answer = bs.toString();
		        return answer;
		    }
	}
}
