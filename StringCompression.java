
public class StringCompression {

	public static void main(String[] args) {
		new StringCompression(). new Solution().solution("aabbaccc");

	}
	class Solution {
	    public int solution(String s) {
	    	if(s.length()== 1) return 1;
	    	
	        int answer = s.length();
	        int index = s.length() / 2;
	        for(int x = index; x > 0; x--) {
	            int count = 0;
	        	String compare ="";
	        	String print = "";
	        	for(int i = 0; i < s.length(); i+=x) {
	        		String cur = s.substring(i, (i / x + 1)* x);
	        		 if(compare.isEmpty()) {
	        			 compare = cur;
	        			 continue;
	        		 }
	        		 if(compare != cur) {
	        			 if(i + x >= s.length()) print+=cur;
	        			 if(count > 1) print+=count+compare;
	        			 else print+=compare;
	        		 
	        		 compare = cur;
	        		 count = 1;
	        		 }
	        		 else {
	        			 count++;
	        			 if(i + x>=s.length()) {
	        				 print+=count+cur;
	        			 }
	        		 }
		        }
	        	answer = answer > print.length() ? print.length() : answer;
	        }
	        return answer;
	    }
	}
}
