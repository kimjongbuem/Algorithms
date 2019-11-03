
public class Apartment {

	public static void main(String[] args) {
		int[] stations = {9};
		System.out.println(new Apartment().new Solution().solution(16, stations, 2));

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
	        int location = 0;
	        while(location < n) {
	        	int count = 0; boolean check = false;
	        	for(int i = location; i < checked.length; i++) {
	        		if(checked[i] && check) {
	        			location = i + w*2 + 1;
	        			break;
	        		}
	        		else if(!checked[i]) {
	        			check = true;
	        			count++; checked[i] = true;
	        			location++;
	        		}
	        	}
	        	count = (count / (w*2 + 2)) + 1;
	        	answer += count; 
	        }
	        
	        return answer;
	    }
	}
	
}

