

public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		ReverseInteger.Solution s = r.new Solution();
		int val = s.reverse(123456789);
		System.out.println(val);
	}
	
	class Solution {
	    public int reverse(int x) {
	        int reverseValue = 0;
	        int cnt = 0;
	        int xs = x;
	        int val = 1;
	        while( xs != 0) {
	        	cnt++ ;
	        	xs /= 10;
	        	if(val*10  <= 1000000000)
	        	val *= 10;
	        }
	        	if(val != 1000000000)
	        		val /=10;
	        int absX = Math.abs(x);  //Àý´ë°ª
	        int d = 1;
	        for(int i = 1; i <= cnt ; i++) {
	        	if(absX / val != 0)
	        	reverseValue+=absX / val * d;
	        	
	        	absX = absX - (absX / val) * val;
	        	if(val/ 10  != 0)
	        	val /= 10;
	        	d *= 10;
	        }
	        if(x < 0)
	        	return -reverseValue;
	        else
	        	return reverseValue;
	    }
	}
}

