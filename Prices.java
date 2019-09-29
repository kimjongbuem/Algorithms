import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
    	Queue<Integer> queue= new LinkedList<Integer>();
    	int[] answer = new int[prices.length];
    	for(int p : prices) {
    		queue.add(p);
    	}
    	for(int i = 0; i<prices.length;++i) {
    		int cnt = 0;
    		int v = queue.poll();
    		Queue<Integer> ansQueue = new LinkedList<Integer>();
    		for(int j = i + 1 ; j < prices.length;j++) {
        		ansQueue.add(prices[j]);
        	} 
    		while(!ansQueue.isEmpty()) {
    			cnt++;
    			if(ansQueue.poll() < v) break;
    			
    		}
    		answer[i] = cnt;
    	}
        return answer;
    }
}



public class Prices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {1,2,3,2,3};
		System.out.println(new Solution().solution(prices));
	}

}
