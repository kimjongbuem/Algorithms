import java.util.Stack;

class Solution {
	
    public String solution(String p) {
        
    	if(p.equals("")) return ""; // 아무것도 없는 문자열 재귀 종료조건1
    	//맞는지 안맞는지 체크..
    	Stack<Character> stack = new Stack<Character>(); 
    	char[] ch = p.toCharArray(); boolean checked = true;
    	for(int i = 0; i < p.length(); i++) {
    		 switch (ch[i]) {
    			case '(': stack.add(ch[i]); break;
    			case ')': if(stack.empty() || stack.pop() == ')')
    				checked =false;
    				break;
    			default:
    				break;
    			}
    		 if(!checked) break;
    	}
    	if(checked) return p; // 올바른 문자열 , 재귀 종료 조건2
    	
    	String result="";
    // 올바르지 않은 문자열... 
      stack.clear();
      int rightIndex = 0; int leftBracket = 0, rightBracket = 0; checked = true;
      for(int i = 0; i < ch.length; i++) {
    	  
    	  switch (ch[i]) {
		case '(': stack.add(ch[i]); leftBracket++; break;
		case ')': if(stack.empty() || stack.peek() == ')') checked = false;
		stack.add(ch[i]);
		rightBracket++; break;
		default:
			break;
		}
    	  rightIndex++;
          if(leftBracket == rightBracket) break;
      }
      if(!checked) while(!stack.empty()) result += stack.pop(); // 재귀 종료 조건3 역 출력
      else result += p.substring(0 ,rightIndex);
      result += solution(p.substring(rightIndex, p.length()));
      return result;
    }
}



public class ChangeingBracket {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("(()())()"));

	}

}
