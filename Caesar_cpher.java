class Solution {
  public String solution(String s, int n) {
      String answer = "";
      char[] chArray = s.toCharArray();
      for(int i = 0; i< s.length(); i++) {
    	  if(chArray[i] >= 65 && chArray[i]<=90) {//대문자라면..
    		  char move =  (char) (chArray[i] + (char) n);
    		  if(move > 90) move = (char) (move - 90 + 65 - 1) ;
    		  answer+= move;
    	  }
    	  else if(chArray[i] >= 97 && chArray[i]<=122) {
    		  char move =  (char) (chArray[i] + (char) n);
    		  if(move > 122) move = (char) (move - 122 + 97 - 1);
    		  answer+= move;
    	  }
    	  else answer+=chArray[i];
      }
      return answer;
  }
}
public class Caesar_cpher {

	public static void main(String[] args) {
		char move = 97;
		String s="";  s+= move;
		System.out.println(s);

	}

}
// 97 ~ 122 소문자  <-----> 65 ~ 90 대문자. 