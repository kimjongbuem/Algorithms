
public class Country124 {

	public static void main(String[] args) {
		System.out.println(new Country124().new Solution().solution(4));

	}
	class Solution {
		  public String solution(int n) {
			  StringBuffer answer = new StringBuffer();
			  int sel = n;
		      while(true ) {
		    	  int val = sel%3;
		    	  sel = sel/3;
		    	  if(val == 0)
		    	  {
		    		  answer.append("4");
		    		  if(sel>=1)
		    		  sel-=1;
		    	  }
		    	  else if(val == 2)
		    		  answer.append("2");
		    	  else if(val == 1)
		    		  answer.append("1");
		    	  if(sel/3 == 0 && sel%3 == 0)
		    		  break;
		      }
		      answer.reverse();
		      return answer.toString();
		  }
	}
}
