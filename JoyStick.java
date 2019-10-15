class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] charName = name.toCharArray();
        char data = 'A';
        
        int first = 0, last = name.length() - 1;
        int idx = 0;
        if(last - first == 0) {
        	if(charName[0] == 'A') {
        		return 0;
            }
            else if(charName[0] < 'M') {
            	while(charName[0] != data) {
            		data++; answer++;
            	}
            }else {
            	data = 'Z';
            	while(charName[0] != data) {
            		 data--; answer++;
            	}
            }
            
            return answer;
        }
        
        while(last - first != 0) {
        	 if(charName[idx] == 'A') {
        		 boolean isAllcheckedA = true;
        		 int leftSize = 0, rightSize = 0;
        		 for(int i = first + 1; i < last; i++) {
        			 leftSize += 1;
        			 if(charName[i] != 'A') {
        				 isAllcheckedA = false;
        			 }
        			 else break;
        			 
        		 }
        		 
        		 for(int i = last; i >= first; i--) {
        			 rightSize +=1;
        			 if(charName[i] != 'A') {
        				 isAllcheckedA = false;
        			 }
        			 else break;
        		 }
        		 
        		 if(isAllcheckedA) {
        			 return answer + last -first + 1;
        		 }
        		 
        		 else if (leftSize < rightSize) {
        			 first+=leftSize; 
        			 answer+=leftSize;
        		 }
        		 else {
        			 last-=rightSize; 
        			 answer+=rightSize;
        		 }
             }
             else if(charName[idx] < 'M') {
             	while(charName[idx] != data) {
             		data++; answer++;
             	}
             	 boolean isAllcheckedA = true;
        		 int leftSize = 0, rightSize = 0;
        		 for(int i = first + 1; i < last; i++) {
        			 leftSize += 1;
        			 if(charName[i] != 'A') {
        				 isAllcheckedA = false;
        			 }
        			 else break;
        			 
        		 }
        		 
        		 for(int i = last; i >= first; i--) {
        			 rightSize +=1;
        			 if(charName[i] != 'A') {
        				 isAllcheckedA = false;
        			 }
        			 else break;
        		 }
        		 
        		 if(isAllcheckedA) {
        			 return answer + last -first + 1;
        		 }
        		 
        		 else if (leftSize < rightSize) {
        			 first+=leftSize; 
        			 answer+=leftSize;
        		 }
        		 else {
        			 last-=rightSize; 
        			 answer+=rightSize;
        		 }
             	
             	
             	
             }else {
             	data = 'Z';
             	while(charName[idx] != data) {
             		 data--; answer++;
             	}
             	 boolean isAllcheckedA = true;
        		 int leftSize = 0, rightSize = 0;
        		 for(int i = first + 1; i < last; i++) {
        			 leftSize += 1;
        			 if(charName[i] != 'A') {
        				 isAllcheckedA = false;
        			 }
        			 else break;
        			 
        		 }
        		 
        		 for(int i = last; i >= first; i--) {
        			 rightSize +=1;
        			 if(charName[i] != 'A') {
        				 isAllcheckedA = false;
        			 }
        			 else break;
        		 }
        		 
        		 if(isAllcheckedA) {
        			 return answer + last -first + 1;
        		 }
        		 
        		 else if (leftSize < rightSize) {
        			 first+=leftSize; 
        			 answer+=leftSize;
        		 }
        		 else {
        			 last-=rightSize; 
        			 answer+=rightSize;
        		 }
             }
        	 data='A';
        }
 
        return answer;
    }
}



public class JoyStick {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("JAZ"));

	}

}
