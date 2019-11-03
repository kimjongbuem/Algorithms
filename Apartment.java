import java.util.Arrays;

public class Apartment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        Arrays.stream(stations).map(i -> i - 1); // ¿Œµ¶Ω∫ ∫Ø»Ø 
	        boolean[] checked =new boolean[n];
	        for(int i : stations) {
	        	checked[i] = true;
	        	for(int j = 1; j <= w; j++) {
	        		if(i - j < 0) break;
		        	else checked[i - j] =true;	        	
	        	}
	        	for(int j = 1; j <= w; j++) {
	        		if(i + j >= n) break;
		        	else checked[i + j] =true;	        	
	        	}
	        }
	        
	        while(!isAllTrue(checked)) {
	        	int count = 0; boolean check = false;
	        	for(int i = 0; i < checked.length; i++) {
	        		if(checked[i] && check) break;
	        		else if(!checked[i]) {
	        			check = true;
	        			count++; checked[i] = true;
	        		}
	        	}
	        	count = (count / (w + 1)) + 1;
	        	answer += count; 
	        }
	        
	        return answer;
	    }
	    boolean isAllTrue(boolean[] checked) {
			for(boolean check : checked) if(!check) return false;
			return true;
		}
	}
	
}

