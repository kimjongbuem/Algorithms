
public class NQueen {
	static int count = 0; static int num = 0; 
	public static void main(String[] args) {
		System.out.println(new NQueen().new Solution().solution(4));

	}
	
	
	class Solution {
	    public int solution(int n) {
	    	if(n <= 3) return 0;
	        int[] pos = new int[n];
	        recursive(pos, 0);
	        return count;
	    }
	    public void recursive(int[] pos, int n) {
	    	if(n == pos.length) {
	    		count++; 
	    	
	    	}
	    	else {
	    		for(int i = 0; i < pos.length; i++) {
		        	pos[n] = i; num++;
		        	if(Promising(pos, n)) recursive(pos, n + 1);
		      }
	    	}
	    }
	    boolean Promising(int[] pos, int n) {
	    	for(int i = 0; i < n; i++) {
	    		if(pos[i] == pos[n]) return false; //같은 인가?
	    		if(pos[n] - pos[i] == n - i) return false; // \
	    		if(pos[i] - pos[n] == n - i) return false; // /
	    	}
	    	return true;
	    }
	}
}
