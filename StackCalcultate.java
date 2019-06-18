import java.util.*;

public class StackCalcultate {
	public static void main(String[]args) {
		Solution s = new StackCalcultate().new Solution();
		System.out.println(s.calculate("2+3+5"));
	}
	class Solution { //����������
		private int count = 0;
	    public String calculate(String s) {
	        Stack<Character> tempChar = new Stack<Character>(); // ���� ����
	    	char[] calInfo = new char[s.length()];
	    	//Integer count = 0;
	        while(count < s.length()) {
	        	if(s.charAt(count) >='1' && s.charAt(count) <= '9')
	        	{
	        		calInfo[count] = s.charAt(count); 	count++;
	        	}
	        	else {
	        		Record(s.charAt(count), tempChar, calInfo);
	        	}
	        }
	        return calInfo.toString();
	    }
	    public void Record(Character c, Stack<Character> tempStack, char[] info) {
			int n1 = 0; //���� ���� ������ �켱���������� 
			int n2 = 0; // ���ÿ켱����������
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
			if(!tempStack.empty())
			{
			tmp = tempStack.pop();
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
				info[count++] = c;
				tempStack.add(c);
			}else if(n1 == 2 && n2 == 0) {
				info[count++] = c;
			}else if(n1 == 2 && n2 == 1) {
				tempStack.add(tmp);
				tempStack.add(c);
			}else if(n1 == 1 && n2 == 0) {
				tempStack.add(c);
			}else if(n1 < n2) {
				while(!tempStack.empty()) {
					info[count++] = tempStack.pop();
				}tempStack.add(c);
			}
	}
	}
	
}
