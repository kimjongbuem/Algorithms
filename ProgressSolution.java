import java.util.ArrayList;

public class ProgressSolution {

	public static void main(String[] args) {
		int[] progresses= {93,30,55};
		int[] speeds= {1,30,5};
		int[] result = new ProgressSolution().new Solution().solution(progresses, speeds);
		for(int i = 0 ; i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        ArrayList<Integer> answer = new ArrayList<Integer>();
	        int count = 0; int nextIdx = 0; int length = progresses.length;
	        while(nextIdx < length) {
	        	for(int i = nextIdx; i<length;i++) {
	        		if(progresses[i] >= 100) {}
	        		progresses[i] += speeds[i];
	        	}
	        	if(progresses[nextIdx] >= 100) {
	        		for(int idx = nextIdx; idx < length;idx++) {
	        			if(progresses[idx] >= 100)
	        				count++;
	        			else
	        				break;
	        		}
	        		nextIdx += count;
	        		answer.add(count);
	        		count = 0;
	        	}
	        }
	        int[] result = new int[answer.size()];
	        for(int i = 0; i< result.length;i++)
	        	result[i] = answer.get(i);
	        return result;
	    }
	}
}
