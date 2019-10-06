import java.util.Arrays;
class Solution {
	   public int solution(int n, int[] lost, int[] reserve) {
		   int answer = n - lost.length;
		 
		   for(int i=0; i<lost.length; i++) {
	            for(int j=0; j<reserve.length; j++) {
	                if(lost[i]==reserve[j]) {
	                	answer++;
	                    lost[i] = -1;
	                    reserve[j] = -1;
	                    break;
	                }
	            }
	        }
		   
		   for(int i = 0; i <lost.length; i++) {
			   for(int j = 0; j < reserve.length; j++) {
				   if(lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
					   reserve[j] = -1;
					   answer++;
					   break;
				   }
			   }   
		   }
		   return answer;		   
	   }
}

public class Gym_suit {
	public static void main(String arg[]) {
		int[] lost= {2,4}; int[] reserve = {3};
		System.out.println(new Solution().solution(5,lost,reserve));
	}
}
