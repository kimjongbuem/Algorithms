import java.util.*;

public class Printers {

	public static void main(String[] args) {
		int[] priorities = {1,1,9,1,1,1}; int location = 0;
		System.out.println(new Printers().new Solution().solution(priorities, location));

	}
	class Solution {
	    public int solution(int[] priorities, int location) {
	        int answer = 0; // 몇번째로 반환이 되는가... 
	        int maxIdx = 0;
	        int beforeMaxIdx = 0;
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i : priorities) {
	        	list.add(i);
	        }
	    for(int recur = 0; recur < priorities.length ; recur++) {
	    	maxIdx = 0;
	    	if(list.stream().allMatch(n-> priorities[location] == n)) {
	    		if(beforeMaxIdx < location) break;
	    		return priorities.length - beforeMaxIdx + location + 1; 
	    	}
	    	for(int i = 1; i < priorities.length;i++) {
	    		if(priorities[maxIdx] <= priorities[i]) maxIdx = i;
	    	}
	    	if(maxIdx == location) return ++answer;
	    	
	    	beforeMaxIdx = maxIdx;
	    	answer++;
	    	priorities[maxIdx] = -1;
	    	list.remove(maxIdx);
	    	
	    }
	    return ++answer;
	}
	    
	}
}
