import java.util.*;

public class StackCalcultate {
	class Solution { //후위연산자
	    public int calculate(String s) {
	        Stack<Character> calChar = new Stack<Character>();
	        Stack<Character> tempChar = new Stack<Character>();
	    	char[] calInfo = new char[s.length()];

	        for(int i = 0; i<s.length();i++) {
	        	
	        	if(s.charAt(i) >='1' && s.charAt(i) <= '9')
	        		calInfo[i] = s.charAt(i);
	        	else {
	        		Character c = calChar.pop() ;
	        		if(c != null) {
	        			
	        		}else {
	        			tempChar.add(c);
	        		}
	        	}
	        }
	    }
	}
	public boolean getIsHigherCharacter(Character c, Stack<Character> tempStack, Stack<Character> calNubmer) {
			switch (c) {
			case '*':
				
			case'/':

			break;
			default:
				break;
			}
	}
}
