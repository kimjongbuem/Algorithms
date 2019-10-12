class Solution {
    public String solution(String number, int k) {
        for(int n = 0; n < k ; n++) {
        	int max = 0;
        	for(int i = 0; i < number.length(); i++) {
        		String test = number;
        		test = test.substring(0,i) + test.substring(i + 1 , test.length());
        		if(max < Integer.parseInt(test)) max = Integer.parseInt(test);
        	}
        	number = Integer.toString(max);
        }
        return number;
    }
}

public class MakeBigNumber {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("4177252841", 4));

	}

}
