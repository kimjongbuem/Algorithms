import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<Character>();
        boolean isStick = false;
       int rayer = 0;
       char before = 0;
       String str = arrangement;
       while(true) {

       String temp="";
       int rf = 0;
       int beforeAnswer = answer;
        for(int i = 0; i < str.length(); i++) {      	
        	if(str.charAt(i) == '(') {
        		if(queue.isEmpty()) rf = i;
        		queue.add(str.charAt(i));
        		before = str.charAt(i);
        	}
        	else {
        		 if(before == '(') rayer++;
        		 before =str.charAt(i); queue.poll(); 
        		if(!queue.isEmpty()) isStick = true;
        		else {
        			if(isStick) {
        				answer+= (rayer + 1);
        				temp+= str.substring(rf + 1, i );
        			}
        			isStick = false; rayer = 0;
        		}
        	}
        }
        if(beforeAnswer == answer) break;
         str = temp;
       }
        return answer;
    }
}
public class IronStick {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("()(((()())(())()))(())"));

	}

}
