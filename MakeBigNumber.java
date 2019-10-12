class Solution {
    public String solution(String number, int k) {
    	
    	if(number.charAt(0) == '0') return "0";
    	StringBuilder sb = new StringBuilder();
    	int idx = 0;
    	char max;
    	
    	for(int i =0; i <number.length() - k;i++) {
    		max= '0';
    		for(int j = idx; j <= k + i ;j++) {
    			if(max < number.charAt(j)) {
    				max = number.charAt(j); 
    				idx = j + 1;
    			}
    		}
    		sb.append(max);
    	}
    	
//        for(int n = 0; n < k ; n++) {
//        	int max = 0;
//        	for(int i = 0; i < number.length(); i++) {
//        		String test = number;
//        		test = test.substring(0,i) + test.substring(i + 1 , test.length());
//        		if(max < Integer.parseInt(test)) max = Integer.parseInt(test);
//        	}
//        	number = Integer.toString(max);
//        }
        return sb.toString();
    }
}

public class MakeBigNumber {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("4177252841", 1));

	}

}
