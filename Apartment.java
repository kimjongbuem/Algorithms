
public class Apartment {

	public static void main(String[] args) {
		int[] stations = {4, 11};
		System.out.println(new Apartment().new Solution().solution(11, stations, 1));

	}
	class Solution {
	    public int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        boolean[] checked =new boolean[n];
	        for(int i : stations) {
	        	checked[i - 1] = true;
	        	for(int j = 1; j <= w; j++) {
	        		if(i - 1 - j < 0) break;
		        	else checked[i  - 1 - j] =true;	        	
	        	}
	        	for(int j = 1; j <= w; j++) {
	        		if(i  - 1 + j >= n) break;
		        	else checked[i - 1 + j] =true;	        	
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
	        	count = (count / (w*2 + 1 + 1)) + 1;
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

