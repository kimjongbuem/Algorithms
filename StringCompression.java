
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(new StringCompression(). new Solution().solution("xababcdcdababcdcd"));

	}
	class Solution {
	    public int solution(String s) {
	    	int answer = s.length();
	    	if(s.length()== 1) return 1;
	    	 int x = s.length() / 2;
	    	for(int idx = x; idx > 0; idx--) {
	    		String cur=""; int count = 1;
	    		String compression = ""; int j = -1;
	    		for(int i = 0; i <= s.length(); i+=idx) {
	    			j++;
	    			if(cur == "") cur+= s.substring(0,idx);
	    			else {
	    				String next="";
	    				if((j+1) * idx <= s.length()) next = s.substring(j*idx, (j+1) * idx);
	    				else next = s.substring(j * idx, s.length());
	    				if(cur.equals(next)) {
	    					count++;
	    				}else {
	    					
	    					if(count > 1) {
	    						compression += String.valueOf(count)+cur;
	    					}
	    					else {
	    						compression += cur;
	    					}
	    					cur = next;
	    					count = 1;
	    				}
	    				if ( i + idx > s.length()) compression += cur;
	    			}
	    		}
	    		answer = compression.length() < answer ? compression.length() : answer ; 
	    	}
	    	return answer;
	    }
	}
}

