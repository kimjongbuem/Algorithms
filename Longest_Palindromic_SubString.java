
public class Longest_Palindromic_SubString {
	class Solution {
	    public String longestPalindrome(String s) {
	    	int maxLength = 0;
	    	String valString = null;
	    	if(s.length() == 1)
	    		return s;
	       for(int i = 0 ;i<s.length() ;i++) {
	    	   for(int j = i + 1;j <=s.length(); j++) {
	    		   String subString = s.substring(i,j);
		    	   if(isPalindromicString(subString) && maxLength < subString.length())
		    	   {
		    		   maxLength = subString.length();
		    		   valString = subString;
		    	   }
		       }
	       }
	       if(valString == null)
	    	   return "";
	       else
	    	   return valString;
	    }
	    public boolean isPalindromicString(String s) {
	    	for(int i = 0 ; i < s.length()/ 2;i++) {
	    		if(s.charAt(i) != s.charAt(s.length() - 1 - i))
	    			return false;
	    	}
	    	return true;
	    }
	}
}
