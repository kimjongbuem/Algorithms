import java.util.Stack;

class Solution {
	boolean isok(String s) {
	   Stack<Character> st = new Stack<Character>();
	 
	    for (int i = 0; i < s.length();i++) {
	        if (s.charAt(i) == '(') {
	            st.push(s.charAt(i));
	        }
	        else if (s.charAt(i) == ')') {
	            if (st.empty()) {
	                return false;
	            }
	            else {
	                st.pop();
	            }
	        }
	    }
	 
	    if (st.empty()) return true;
	    else return false;
	}
    public String solution(String p) {
        
    	String answer="";
    	if(isok(p)) return p;
    	answer = changeBracket(p);
    	return answer;
    }
    public String changeBracket(String p) {
    	if(p.equals("")) return ""; // 아무것도 없는 문자열 재귀 종료조건 <1> 
    	char[] ch = p.toCharArray(); 
    	String result="";
      //<2>
      int rightIndex = 0; int leftBracket = 0, rightBracket = 0; 
      for(int i = 0; i < ch.length; i++) {
    	  switch (ch[i]) {
		case '(': leftBracket++; break;
		case ')': rightBracket++; break;
		}
    	  rightIndex++;
          if(leftBracket == rightBracket) break;
      }
      String u = p.substring(0 ,rightIndex);
      String v = p.substring(rightIndex, p.length());
      if(isok(u)) {
    	  result += u;
          result += changeBracket(v);
      }
      else {
    	  result="(";
    	  result+=changeBracket(v);
    	  result+=")";
    	  u = u.substring(1, rightIndex - 1);
    	  for(int i = 0; i <u.length();i++)
    	  {
    		  if(u.charAt(i) == ')') result+='(';
    		  else result+=')';
    	  }
    	  
      }
      return result;
    }
}



public class ChangeingBracket {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(")()()()("));

	}

}
