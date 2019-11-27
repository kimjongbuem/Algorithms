import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PriorityQueueQuestion {

	public static void main(String[] args) {
		String[] operations= //{"I 16","D 1"}; 
				{"I 7","I 5","I -5","D -1"};
		new PriorityQueueQuestion().new Solution().solution(operations);
	}
	class Solution {
	    public int[] solution(String[] operations) {
	        int[] answer = {0,0};
	        LinkedList<Integer> answerList = new LinkedList<Integer>();
	        for(int i = 0; i < operations.length; i++) {
	        	StringTokenizer tokenLizer = new StringTokenizer(operations[i]," ");
	        	
	        	if(tokenLizer.nextToken().equals("I")){
	        		answerList.add(Integer.valueOf(tokenLizer.nextToken()));
	        	}else {
	        		if(answerList.isEmpty()) continue;
	        		
	        		int val = Integer.valueOf(tokenLizer.nextToken());
	        		if(val < 0) answerList.remove(0);
	        		else answerList.remove(answerList.size() - 1);
	        	}
	        	Collections.sort(answerList);
	        }
	        //
	        if(answerList.isEmpty()) return answer;
	        answer[0] = answerList.get(answerList.size() - 1); answer[1] = answerList.get(0);
	        return answer;
	    }
	}
}
