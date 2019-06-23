
import java.util.*;

public class player {
	public static void main(String arg[]) {
	//	new HIndex().new Solution().solution(participant, completion)
	}
	
	class Solution {
	    public String solution(String[] participant, String[] completion) {
	       Arrays.sort(participant);
	       Arrays.sort(completion);
	       int i;
	       for(i = 0; i<completion.length;i++){
	    	   if(!participant[i].equals(completion[i]))
	    		   return participant[i];
	       }
	       return participant[i]; 
	    }
	}
	
	
	
}
