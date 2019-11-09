import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Intern4Q {

	public static void main(String[] args) {
		long[] room_number = {1,3,4,1,3,1};
		long[] answer = new Intern4Q().new Solution().solution(10, room_number);
		for(int i = 0; i < answer.length; i++)
		System.out.print(answer[i]+" ");

	}
	class Solution {
	    public long[] solution(long k, long[] room_number) {
	        long[] answer = {};
	        Set<Long> set = new HashSet<Long>();
	        List<Long> list = new LinkedList<Long>();
	        //long low = 1; long upper = k;
	        for(int e = 0; e < room_number.length; e++) {
	        	if(!set.contains(room_number[e])) {
	        		list.add(room_number[e]);
	        		set.add(room_number[e]);
	        	}
	        	else {
	        		long l = room_number[e];
	        		while(true) {
	        			if(!set.contains(++l)) {
	        				set.add(l);
	        				list.add(l);
	        				break;
	        			}	
	        		}
	        	}
	        }
	       answer = list.stream().mapToLong(i -> i).toArray();
	        return answer;
	    }
	}
}
