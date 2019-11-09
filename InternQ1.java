import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InternQ1 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};	
		int [] moves = {1,5,3,5,1,2,1,4};
		System.out.println(new InternQ1().new Solution().solution(board, moves));

	}
	class Solution {
	    public int solution(int[][] board, int[] moves) {
	    	int len = board.length;
	    	//MyQueue[] store = new MyQueue[len];
	    	Queue<Integer>[] storing = (Queue<Integer>[]) new Queue[len];
	    	for(int i = 0; i < len ; i++) {
	    		storing[i] = new LinkedList<Integer>();
	    		for(int j = 0; j < len ; j++) {
		    		//if(board[j][i] > 0 ) store[i].queues.add(board[j][i]);
	    			if(board[j][i] > 0 ) storing[i].add(board[j][i]);
		    	}
	    	}
	    	int answer = 0;
	    	Stack<Integer> stack = new Stack<Integer>();
	    	for(int v : moves) {
	    		if(storing[v - 1].isEmpty()) continue;
	    		int data = storing[v - 1].poll();
	    		if(!stack.empty() && stack.peek() == data) {
	    			answer+=2;
	    			stack.pop();
	    		}
	    		else
	    		stack.add(data);
	    	}

	        return answer;
	    }
	}
	class MyQueue{
		public Queue<Integer> queues;
		MyQueue(){
			queues= new LinkedList<Integer>();
		}
		
	}
}
