import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	class Solution {
	   
		public int lengthOfLongestSubstring(String s) {
	    	int n = s.length();
	    	int maxCnt = 0;
	    	Set<Character> set = new HashSet<Character>();
	    	int i = 0, j = 0;
	    	while(i < n && j <n) {
	        if(!set.contains(s.charAt(i))) {
	        	set.add(s.charAt(i++));	
	        	maxCnt = Math.max(maxCnt, i - j);
	        }else {
	        	set.remove(s.charAt(j++));
	        }  
	    }
	    	return maxCnt;
	}
	
	}
}
