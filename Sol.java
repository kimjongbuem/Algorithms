
public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
		  public int[] solution(int n, int s) {
			  if(n > s) return new int[] {-1};
		      int[] answer = {};
		      answer = new int[n];
		      int start = s / n;
		      int remain = s % n;
		      int i = 0;
		      for(; i < n; i++) answer[i] = start;
		      i = n - 1;
		      while(remain > 0) {
		    	  answer[i--] += 1;
		    	  remain--;
		    	  if(i == 0) i = n - 1;
		      }
		      
		      return answer;
		  }
		}
}
