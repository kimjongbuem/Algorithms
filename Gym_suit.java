import java.util.Arrays;
class Solution {
	   public int solution(int n, int[] lost, int[] reserve) {
		   int answer = n - lost.length;
		   
		   for(int i = 0; i <lost.length; i++) {
			   for(int j : reserve) {
				   if(lost[i] == j - 1 || lost[i] == j + 1) {
					   if(lost[i] == j - 1 && lost[i + 1] == j + 1) answer--;
					   lost[i] = -1;
					   answer++;
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
