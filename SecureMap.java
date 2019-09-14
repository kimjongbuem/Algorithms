import java.util.Stack;

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      int[] resultArray= new int[n];
     Stack<Integer> stack = new Stack<Integer>();
      
      for(int i = 0; i< n;i++) {
    	  answer[i]="";
    	  resultArray[i] = arr1[i] | arr2[i];
      }
      for(int i = 0; i < n; i++) {
    	 int val = resultArray[i];
    	 int cnt = 0;
    	  while(cnt < n) {
    		  int d = val / 2;
    		  int r = val % 2;
    		  stack.push(r);
    		  if(d == 0 && cnt < 4) {
    			  for(int j = cnt + 1;j< n; j++)  stack.push(0);
    			  break;
    		  }
    		 val /=2;
    		  cnt++;
    	  }
    	  for(int j = 0; j< n;j++) {
    		  int c = stack.pop();
    		  if(c == 1) answer[i]+="#";
    		  else answer[i]+=" ";
    	  }
      }
      
      for(int j = 0; j< n;j++) {
		 System.out.println(answer[j]);
	  }
      
      
      return answer;
      
  }
}



public class SecureMap {

	public static void main(String[] args) {
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		Solution s = new Solution();
		s.solution(arr1.length, arr1, arr2);

	}

}
