
class Solution {
    public int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
    	answer[answer.length - 1] = 0;
    	for(int i = 0; i<prices.length - 1 ;++i) {
    		int cnt = 1; 
    		for(int j = i + 1; j<prices.length - 1; j++) {
    			if(prices[j] >=prices[i]) cnt++;
    			else break;
    		}
    		answer[i] = cnt;
    	}
        return answer;
    }
}



public class PricesVer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {1,2,3,2,3};
		System.out.println(new Solution().solution(prices));
	}

}
