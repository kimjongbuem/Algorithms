import java.util.Arrays;
import java.util.Stack;

public class Jeoul {
	Stack<Integer> st = new Stack<Integer>();
	//int[] arr= {1,2,3,4};
	public static void main(String[] args) {
		int[] weight = {3,1,6,2,7,30,1};
		System.out.println(new Jeoul().new Solution().solution(weight));
		//new Jeoul().nCr(4, 2, 0);
	}
//	void nCr(int n, int r, int index) {
//		if( r == 0) showStack();
//		else if( n == r) {
//			for(int i=0;i<n;i++)st.add(arr[index+i]);//index부터 n개를 차례대로 스택에 넣고
//            showStack(); //스택을 보여준다.
//            for(int i=0;i<n;i++)st.pop(); //이후 전부 pop을 시켜 다음 과정을 진행한다.
//		}else {
//			st.add(arr[index]);
//			nCr(n-1, r-1, index + 1);
//			
//			st.pop();
//			nCr(n-1,r, index + 1);
//		}
//	}
	void showStack() {
		for(int i = 0; i < st.size(); i++){
            System.out.print(st.get(i)+" ");
        }
        System.out.println("");

	}
	class Solution {
	    public int solution(int[] weight) {
	        int answer = 1;
	        Arrays.sort(weight);
	        while(true) {
	        	boolean min = true; 
	        	for(int i = 0; i < weight.length; i++) {
	        		if(!min) break; 
	        		if(Combition(weight, weight.length, i, 0, answer)) {
	        			min = false;
	        			break;
	        		}
	        	}
	        	if(min) break; 
	        	answer++;
	        }
	        return answer;
	    }
	    boolean Combition(int[] weight, int n ,int r, int index, int number) { // i를 개수로하자. , 조합 nCr...
	    	boolean b1, b2;
	    	if( r == 0) {
	    		int sum= 0;
	    		for(int i = 0; i < st.size(); i++) sum+=i;
	    		if(number == sum) return true; else return false;
	    	}else if(n == r) {
	    		int sum= 0;
	    		for(int i = 0; i < weight.length; i++) sum+=i;
	    		if(number == sum) return true; else return false;
	    	}else {
	    		st.add(weight[index]);
	    		b1 = Combition(weight, n - 1, r - 1, index + 1, number);
	    		
	    		st.pop();
	    		b2 = Combition(weight, n - 1, r - 1, index + 1, number);
	    		
	    		if(b1 || b2) return true; else return false;
	    	}
	    }
	}
}
