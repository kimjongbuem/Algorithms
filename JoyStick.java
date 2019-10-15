class Solution {
    public int solution(String name) {    
       return RepeatFunc(name, 0);
    }
    private int RepeatFunc(String name, int cur) {
    	 int answer = 0;
    	 int curidx = cur;
    	 char[] charData = name.toCharArray();
    	if(name.length() == 1) {
    		char ch = 'A';
    		if(name == "A") {}
    		else if(charData[0] < 'M'){
    			while(ch != charData[0]) {
    				answer++; ch++;
    			}
    		}else {
    			ch = 'Z';
    			while(ch != charData[0]) 
    				answer++; ch--;
    		}
    		return answer;
    	}
        
    	if(charData[curidx] < 'M') {
    		char ch = 'A';
    		while(ch != charData[curidx]) {
				answer++; ch++;
			}
    	}else {
			char ch = 'Z'; answer++;
			while(ch != charData[curidx]) {
				answer++; ch--;
			}
		}
        
    	int leftSize = 0, rightSize = 0;
    	
    	int first = 0; int last = name.length() - 1;
    	if(first == cur)
    	for(int i = first + 1; i <= last; ++i) {   		
    		if(charData[i] == 'A' && i == last) return answer;
    		else if (charData[i] == 'A') {
    			leftSize++;
    		}
    		else {
    			leftSize++;
    			break;
    		}
    	}
    	else
    		for(int i = first; i < last; ++i) {   		
        		if(charData[i] == 'A' && i == last - 1) return answer;
        		else if (charData[i] == 'A') {
        			leftSize++;
        		}
        		else {
        			leftSize++;
        			break;
        		}
        	}
    		
    		
    	if(last==cur)
    	for(int i = last - 1; i >= first; --i) {   		
    		if(charData[i] == 'A' && i == first) return answer;
    		else if (charData[i] == 'A') {
    			rightSize++;
    		}
    		else {
    			rightSize++;
    			break;
    		}
    	}
    	else
    		for(int i = last; i >= first + 1; --i) {   		
        		if(charData[i] == 'A' && i == first + 1) return answer;
        		else if (charData[i] == 'A') {
        			rightSize++;
        		}
        		else {
        			rightSize++;
        			break;
        		}
        	}
    	
    	if(leftSize <= rightSize) answer+=RepeatFunc(name.substring(curidx+leftSize)
    			,first+leftSize) + 1;
    	else answer+=RepeatFunc(name.substring(curidx + 1 , name.length() - rightSize + 1),
    			 last - rightSize) + 1;
    	
    	return answer;
    }
}



public class JoyStick {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("JEROEN"));
	}
}
