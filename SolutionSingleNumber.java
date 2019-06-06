
import java.util.Hashtable;
class SolutionSingleNumber {
    public int singleNumber(int[] nums) {
    	Hashtable<Integer, Integer> table =new Hashtable<Integer, Integer>();
    	Integer n = null;
    	for(int val : nums) {
    		n = table.get(val);
    		if( n==null)
    			table.put(val, 1);
    		else
            {
                int number = n;
    			table.put(val, number + 1);
            }
    	}
    	for(int val : nums) {
    		n = table.get(val);
    		if(n == 1)
    			return val;
    	}
    	return -1;
    }
}