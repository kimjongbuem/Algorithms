import java.util.Arrays;
import java.util.Stack;

public class Jeoul {
	
	static int[] arr= {3,1,6,2,7,30,1};
	public static void main(String[] args) {
		int[] weight = {3,1,6,2,7,30,1};
		Arrays.sort(arr);
		System.out.println(new Jeoul().new Solution().solution(weight));
		//new Jeoul().nCr(7, 3, 0);
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
//	void showStack() {
//		for(int i = 0; i < st.size(); i++){
//            System.out.print(st.get(i)+" ");
//        }
//        System.out.println("");
//
//	}
	class Solution {
		Stack<Integer> st = new Stack<Integer>();
	    public int solution(int[] weight) {
	    	Arrays.sort(weight); if(weight[0]!=1) return 1; int[] sum = new int[weight.length]; int tmpsum = 0; for(int i=0;i<weight.length;i++) 
	    	{ tmpsum+=weight[i]; sum[i]=tmpsum; if(i<weight.length-1 && sum[i]+1<weight[i+1]) {
	    		return sum[i]+1; } }
	    	return sum[sum.length-1]+1;

	    }
	    boolean Combition(int[] weight, int n ,int r, int index, int number) { // i를 개수로하자. , 조합 nCr...
	    	boolean b1, b2;
	    	if( r == 0) {
	    		if(st.isEmpty()) return false;
	    		int sum= 0;
	    		for(int i = 0; i < st.size(); i++) sum+=st.pop();
	    		if(number == sum) return true; else return false;
	    	}else if(n == r) {
	    		if(number == 14 && st.size() == 3) {
	    			System.out.println("");
	    		}
	    		if(st.isEmpty()) return false;
	    		int sum= 0;
	    		for(int i=0;i<n;i++)st.add(weight[index+i]);
	    		for(int i = 0; i < n; i++) sum+=st.pop();
	    		if(number == sum) return true; else return false;
	    	}else {
	    		st.add(weight[index]);
	    		b1 = Combition(weight, n - 1, r - 1, index + 1, number);
	    		if(b1) return true;
	    		return Combition(weight, n - 1, r, index + 1, number);
	    	}
	    }
	}
}
