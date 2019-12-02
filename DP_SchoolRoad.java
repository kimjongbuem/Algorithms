
public class DP_SchoolRoad {

	public static void main(String[] args) {
		int[][] puddles = {{2,2}};
		System.out.println(new DP_SchoolRoad().new Solution().solution(4, 3, puddles));

	}
	class Solution {
	    public int solution(int m, int n, int[][] puddles) {
	        int answer = func(m, n, puddles, 0);
	        return answer;
	    }
	    public int func(int m, int n, int[][] puddles, int answer) {
	    	if(n == puddles.length && m == puddles[0].length) return answer;
	    	else if(n == puddles.length) return func(m + 1, n, puddles, answer+1);
	    	else if(m == puddles[0].length) return func(m, n + 1, puddles, answer+1);
	    	else {
	    		int a = func(m, n + 1, puddles, answer+1);
	    		int b = func(m + 1, n, puddles, answer+1);
	    		return a>b? a:b;
	    	}
	    }
	}
}
