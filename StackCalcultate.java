import java.util.*;

public class StackCalcultate {
	public static void main(String[]args) {
		Solution s = new StackCalcultate().new Solution();
		String s1 = s.calculate("2+3*5");
		System.out.println(s1.toString());
	}
	class Solution { //����������
		private int count = 0;
	    public String calculate(String s) {
	        Stack<Character> tempChar = new Stack<Character>(); // ���� ����
	    	char[] calInfo = new char[s.length()];
	    	//Integer count = 0;
	       for(int i = 0; i<s.length();i++){
	        	if(s.charAt(i) >='1' && s.charAt(i) <= '9')
	        	{
	        		calInfo[count] = s.charAt(i); 	count++;
	        	}
	        	else {
	        		int n1 = 0; //���� ���� ������ �켱���������� 
	    			int n2 = 0; // ���ÿ켱����������
	    			Character c = s.charAt(i);
	    			if(c!=null)
	    			switch (c) {
	    			case '*':
	    			case '/':
	    				n1 = 2;
	    				break;
	    			case '-':
	    			case '+':
	    				n1 = 1;
	    				break;
	    			default:
	    				break;
	    			}
	    			Character tmp = null;
	    			if(!tempChar.empty())
	    			{
	    			tmp = tempChar.pop();
	    			switch (tmp) {
	    			case '*':
	    			case '/':
	    				n2 = 2;
	    				break;
	    			case '-':
	    			case '+':
	    				n2 = 1;
	    				break;
	    			default:
	    				break;
	    			}
	    			}
	    			if(n1 == n2) {
	    				calInfo[count++] = c;
	    				tempChar.add(c);
	    			}else if(n1 == 2 && n2 == 0) {
	    				calInfo[count++] = c;
	    			}else if(n1 == 2 && n2 == 1) {
	    				tempChar.add(tmp);
	    				tempChar.add(c);
	    			}else if(n1 == 1 && n2 == 0) {
	    				tempChar.add(c);
	    			}else if(n1 < n2) {
	    				while(!tempChar.empty()) {
	    					calInfo[count++] = tempChar.pop();
	    				}tempChar.add(c);
	    			}
	        	}
	        }
	       while(!tempChar.empty()) {
				calInfo[count++] = tempChar.pop();
			}
	       	return new String(calInfo);
	    }
	    public void Record(Character c, Stack<Character> tempStack, char[] info) {
			
	}
	}
	
}
