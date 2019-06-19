import java.util.*;

public class StackCalcultate {
	public static void main(String[]args) {
		Solution s = new StackCalcultate().new Solution();
		int val = s.calculate("9/3-8+6*2");
		System.out.println(val);
	}
	class Solution { //후위연산자
		private int count = 0;
	    public int calculate(String s) {
	        Stack<String> tempChar = new Stack<String>(); // 접시 스택
	    	String[] calInfo = new String[s.length()];
	    	//Integer count = 0;
	       for(int i = 0; i<s.length();i++){
	        	if(s.charAt(i) >='1' && s.charAt(i) <= '9')
	        	{
	        		calInfo[count] = Character.toString(s.charAt(i)); 	count++;
	        	}
	        	else {
	        		int n1 = 0; //현재 들어온 숫자의 우선순위값저장 
	    			int n2 = 0; // 스택우선순위값저장
	    			String c = Character.toString(s.charAt(i));
	    			if(c!=null)
	    			switch (c) {
	    			case "*":
	    			case "/":
	    				n1 = 2;
	    				break;
	    			case "-":
	    			case "+":
	    				n1 = 1;
	    				break;
	    			default:
	    				break;
	    			}
	    			String tmp = null;
	    			if(!tempChar.empty())
	    			{
	    			tmp = tempChar.pop();
	    			switch (tmp) {
	    			case "*":
	    			case "/":
	    				n2 = 2;
	    				break;
	    			case "-":
	    			case "+":
	    				n2 = 1;
	    				break;
	    			default:
	    				break;
	    			}
	    			}
	    			if(n1 == n2) {
	    				calInfo[count++] = tmp;
	    				tempChar.add(c);
	    			}else if(n1 == 2 && n2 == 0) {
	    				tempChar.add(c);
	    			}else if(n1 == 2 && n2 == 1) {
	    				tempChar.add(tmp);
	    				tempChar.add(c);
	    			}else if(n1 == 1 && n2 == 0) {
	    				tempChar.add(c);
	    			}else if(n1 < n2) {
	    				calInfo[count++] = tmp;
	    				while(!tempChar.empty()) {
	    					calInfo[count++] = tempChar.pop();
	    				}tempChar.add(c);
	    			}
	        	}
	        }
	       while(!tempChar.empty()) {
				calInfo[count++] = tempChar.pop();
			}
	       	return getValue(calInfo);
	    }
	    public int getValue(String[] s) {
			Stack<String> numberStack = new Stack<String>();
			int val = 0;
			for(int i = 0; i<s.length;i++) {
				try {
				if(Integer.parseInt(s[i]) >= Integer.MIN_VALUE && Integer.parseInt(s[i]) <= Integer.MAX_VALUE)
	        	{
	        		numberStack.add(s[i]);
	        	}
				}catch(NumberFormatException e) {
					String s1 = numberStack.pop();
	        		String s2 = numberStack.pop();
					int num1 = Integer.parseInt(s1);
					int num2 = Integer.parseInt(s2);
	        		switch (s[i]) {
					case "+": 
						val = num1 + num2;
						numberStack.add(Integer.toString(val));
						break;
					case "-":
						val = num2 - num1;
						numberStack.add(Integer.toString(val));
						break;
					case "*":
						val = num1 * num2;
						numberStack.add(Integer.toString(val));
						break;
					case "/":
						val = num2 / num1;
						numberStack.add(Integer.toString(val));
						break;
					default:
						break;
					}
				}
			}
			
			val = Integer.parseInt(numberStack.pop());
			return val;
	    }
	}
}


//else {
//	String s1 = numberStack.pop();
//	String s2 = numberStack.pop();
//	int num1 = Integer.parseInt(s1);
//	int num2 = Integer.parseInt(s2);
//	switch (s[i]) {
//	case "+": 
//		val = num1 + num2;
//		numberStack.add(Integer.toString(val));
//		break;
//	case "-":
//		val = num1 - num2;
//		numberStack.add(Integer.toString(val));
//		break;
//	case "*":
//		val = num1 * num2;
//		numberStack.add(Integer.toString(val));
//		break;
//	case "/":
//		val = num1 / num2;
//		numberStack.add(Integer.toString(val));
//		break;
//	default:
//		break;
//	}
//}





