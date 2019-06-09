
public class isPalindrome {
	class Solution {
	    public boolean isPalindrome(int x) {
	    	if(x < 0)
	    		return false;
	        String str = String.valueOf(x);
	        char[] c = str.toCharArray();
	        int n = c.length;
	        
	        for(int i = 0; i< n/2;i++) {
	        	if(c[i] != c[n - i - 1])
	        		return false;
	        }
	    	return true;
	    }
	}
}
