
public class TileStructure {

	public static void main(String[] args) {
		new TileStructure().new Solution().solution(5);

	}
	class Solution {
	    public long solution(int N) {
	        long answer = 0;
	         
	        if(N == 1) return 4;
	        long num = 1; long height = 1; long width = 1;
	        while(num < N) {
	        	long temp = height + width;
	        	height = width;
	        	width =temp;
	        	num++;
	        }
	        answer = width*2 + height * 2;
	        return answer;
	    }
	}
}
