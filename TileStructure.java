
public class TileStructure {

	public static void main(String[] args) {
		new TileStructure().new Solution().solution(5);

	}
	class Solution {
	    public long solution(int N) {
	        long answer = 0;
	         
	        if(N == 1) return 4;
	        int num = 1; int height = 1; int width = 1;
	        while(num < N) {
	        	int temp = height + width;
	        	height = width;
	        	width =temp;
	        	num++;
	        }
	        answer = width*2 + height * 2;
	        return answer;
	    }
	}
}
