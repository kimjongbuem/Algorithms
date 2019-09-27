class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int day = 0;
    	int answer = 0;
    	int datesIndex = 0;

    	
    	for(int s : supplies) {
    		day += s;
    	}
    	
    	if(day + stock == k) return supplies.length;
    	
    	day = 0;
    	 while(day < k) {
         	if(--stock <= 0 ) { 
         		stock = supplies[datesIndex];
         		datesIndex++;
         		answer++;
         	}
         	else if(day == dates[datesIndex] - 1) { 
         		if(k - day < stock + supplies[datesIndex] ) answer++;
         		datesIndex++;
         		
         	}
         	if(datesIndex == dates.length) break;
         	day++;
         }
    	
    	
    	
    	
        return answer;
       
    }
}


public class Ramen {

	public static void main(String[] args) {
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		
		System.out.println(new Solution().solution(2, dates,supplies, 30));

	}

}
