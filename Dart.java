
class Solution {
  public int solution(String dartResult) {
      int sum = 0;
      int beforeVal = 0;
      int beforebeforeVal = 0;
      String str ="";
      
      for(int i = 0; i < dartResult.length(); i++) {
    	  if(dartResult.charAt(i) < 48 || dartResult.charAt(i) > 58) { // 숫자가 아닌경우.
    		  int val = 0;
    		  if(str!="") val = Integer.parseInt(str);
    		  switch(dartResult.charAt(i)) {
    		  
    		  case 'S':
    			  beforebeforeVal = beforeVal;
    			  beforeVal = val;
    			  sum += val;
    			  break;
    		  case 'D':
    			  beforebeforeVal = beforeVal;
    			  beforeVal = val*val;
    			  sum += val*val;
    			  break;
    		  case 'T':
    			  beforebeforeVal = beforeVal;
    			  beforeVal = val*val*val;
    			  sum+=	val*val*val;
    			  break;
    		  case '*':
    			  sum+=(beforeVal + beforebeforeVal);
    			  beforeVal *= 2;
    			  break;
    		  case '#':
    			  beforeVal = - beforeVal;
    			  sum +=beforeVal * 2;
    			  break;
    		  }
    		  str="";
    	  }
    	  else str +=dartResult.charAt(i); // 숫자인경우 붙임.
      }
      
      return sum;
  }
}


public class Dart {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("1S*2T*3S"));

	}

}
