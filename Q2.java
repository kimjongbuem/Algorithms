
import java.util.Arrays;

public class Q2 {
	public static void main(String[]args) {
		int[]A= {1,4,2}; int[]B= {5,4,4};
		int val = 
		new Q2().new Solution().solution(A, B);
		System.out.println(val);
	}
	class Solution
	{
	    public int solution(int []A, int []B)
	    {
	        int answer = 0;
	        Arrays.sort(A); Arrays.sort(B);
	        
	        for(int i = 0;i<A.length;i++) {
	        	answer += (A[i]*B[i]);
	        }
	        System.out.println("Hello Java");

	        return answer;
	    }
	}
}
