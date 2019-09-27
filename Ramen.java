import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int idx = 0;
    	int answer = 0;
    	 Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    	 
    	 for(int i = 0; i < k;i++) {
    		 if(idx < dates.length && i == dates[idx]) {
    			 priorityQueue.add(supplies[idx++]);
    		 }
    		 if(stock == 0) {
    			 stock += priorityQueue.poll();
    			 answer++;
    		 }
    		 stock-=1;
    	 }    	
        return answer;
    }
}


public class Ramen {

	public static void main(String[] args) {
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		
		System.out.println(new Solution().solution(4, dates,supplies, 30));

	}

}
