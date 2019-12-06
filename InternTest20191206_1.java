
public class InternTest20191206_1 {
	class Solution
	{
	    public long[] solution(long n)
	    {
	    	long []answer = {0,0};
	    	if(n == 0) return answer;
	    	
	    	long min = 0; long max = 0;
	        if(n < 7) {
	        	if(n == 1) {
	        		min = 0; max = 1;
	        	}
	        	else if(n >= 2 && n <= 5) {
	        		min = 0; max = 2;
	        	}
	        	else if(n == 6) {
	        		min = 1; max = 2;
	        	}
	        }else {
	        	long d = (n / 7);
	        	long r = d / 7; 
	        	min = d * 2;
	        	
	        	if(r == 0) max = min;
	        	else if(r == 1) max = min + 1;
	        	else if(r>=2 && r<=5)max = min + 2;
	        	else if(r == 6) {
	        		max = min + 2; min = min + 1;
	        	}
	        }	
	        answer[0] = min;
	        answer[1] = max;
	        return answer;
	    }
	}
}
