import java.util.LinkedList;

public class NExpreesion {

	public static void main(String[] args) {
		System.out.println(new NExpreesion().new Solution().solution(12, 5));

	}
	class Solution {
		int min = 9;
		int count = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
	    public int solution(int N, int number) {
	        //dfs(N,number,0,0);
	    	return min< 9 ? min : -1;
	    }
	    public void BFS(int N, int number) {
	    	if(count >= min) return;
	    	if(list.size() >= min) return;
	    	int lastNumber = (list.size() == 0) ? 0 : list.get(list.size() - 1);
	    	if(lastNumber == N) {
	    		min = min > count ? count : min; return;
	    	}
	    	int n = 0; int addCount = 0;
	    	for(int c = 1; c<=1000000; c*=10) {
	    		
	    	}
	    }
	    
//	    public void dfs(int N, int number, int start, int value){
//	    	for(int i = 0; i<=100000;i*=10) {
//	    		int val = (i*number) + number; // ��Ģ����.. 
//	    		int temp = i + 1; if(min < temp) return;
//	    		// basic
//	    		if(val + value == N) {
//	    			if(min > temp) min = temp;
//	    			return;
//	    		}else {
//	    			int tempVal;
//	    			// +
//	    			tempVal = val + value;
//	    			if(tempVal == N)if(min > temp+ 1) {
//	    				min = temp+1;
//	    			} else dfs(N, number ,++start,tempVal);
//	    			// -
//	    			tempVal = value - val;
//	    			if(tempVal == N)if(min > temp + 1) {
//	    				min = temp + 1;
//	    			}else if(tempVal <= 0) {}
//	    			else dfs(N, number ,++start,tempVal);
//	    			// *
//	    			tempVal = val * number;
//	    			if(tempVal == N)if(min > temp + 1) {
//	    				min = temp + 1;
//	    			}else dfs(N, number ,++start,tempVal);
//	    			// /
//	    			tempVal = number/val;
//	    			if(tempVal == N)if(min > temp) {
//	    				min = temp;
//	    			}else dfs(N, number ,++start,tempVal);
//	    		}
//	    	}
//	    }
	}
}
