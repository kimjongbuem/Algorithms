import java.util.Stack;

class Solution {
	
    public String solution(String p) {
        
    	if(p.equals("")) return ""; // �ƹ��͵� ���� ���ڿ� ��� ��������1
    	//�´��� �ȸ´��� üũ..
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
    	if(checked) return p; // �ùٸ� ���ڿ� , ��� ���� ����2
    	
    	String result="";
    // �ùٸ��� ���� ���ڿ�... 
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
      if(!checked) while(!stack.empty()) result += stack.pop(); // ��� ���� ����3 �� ���
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
