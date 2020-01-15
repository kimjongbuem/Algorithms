import java.util.Arrays;
import java.util.Collections;

public class LifeBoat {

	public static void main(String[] args) {
		int people[] = {70,80,50}; int limit = 100;
		System.out.println(new LifeBoat().new Solution().solution(people, limit));
	}
	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Integer[] peoples = new Integer[people.length];
	        int[] containers = new int[people.length];
	        for(int i = 0; i < people.length; i++) peoples[i] = people[i]; 
	        Arrays.sort(peoples,Collections.reverseOrder());
	        for(int i = 0; i < peoples.length; i++) {
	        	int w = peoples[i]; boolean flag = false;
	        	for(int j = 0; j <= answer;j++) {
	        		if(containers[j] + w <= limit) {
	        			flag = true;
	        			containers[j] += w;
	        			break;
	        		}
	        	}
	        	if(!flag) containers[++answer] = w;
	        }
	        return containers[answer] > 0 ? answer + 1 : answer;
	    }
	}
}
