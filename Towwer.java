import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Towwer {
	public static void main(String args[]) {
		int[] x= {3,9,9,3,5,7,2};
		int[] result = new Towwer().new Solution().solution(x);
		for(int i : result) {
			System.out.println(i);
		}
	}
	class Solution {
	    public int[] solution(int[] heights) {
	    	Stack<Integer> stack = new Stack<Integer>();
	    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	    	int k;
	    	
	    	for(int i : heights) {
	    		stack.push(i);
	    	}
	    	
	    	for(int i = 0; i < heights.length - 1;i++) {
	    		int requestTowwer = stack.pop();
	    		k = 0;
	    		for(int j = heights.length - 2 - i ; j>=0;j--) {
	    			int receiveTowwer = stack.pop();
	    			if(requestTowwer < receiveTowwer) {
	    				arrayList.add(j+1);
	    				k = j;
	    				break;
	    			}
	    		}
	    		if(k == 0) {
	    			arrayList.add(0);
	    		}
	    		for(int idx = k ; idx < heights.length -1 - i;idx++) {
	    			stack.add(heights[idx]);
	    		}
	    	}
	    	arrayList.add(0);
	    	Collections.reverse(arrayList);
	    	int [] answer = new int[arrayList.size()];
	       for(int i = 0;  i < answer.length ; i++) {
	    	   answer[i] = arrayList.get(i).intValue();
	       }
	        return answer;
	    }
	}
}
