
public class KeyAndLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public boolean solution(int[][] key, int[][] lock) {
	        boolean answer = false;
	        for(int i = 0; i < lock.length; i++) {
	        	for(int j = 0; j < lock[0].length; j++) {
		        	if(lock[i][j] == 0) {
		        		int[][] check = key;
		        		for(int k = 0; k < key.length; k++) {
		        			for(int r = 0; r < key.length; r++) {
		        				if(key[k][r] == 1) {
		        					int moveX = j - r;
		        					int moveY = i - k;
		        				}
			        		}
		        		}
		        	}
		        }
	        }

	        
	        
	        // x 좌표가  같을때  
	        // 그대로..
	        //90도 회전시) 위에 블럭들:  y 인덱스 차 + x , y = 해당 이동 중심 y  // 아래블럭들 : -(y 인덱스 차) + x ,  y
	        // 180 회전시) 위에블럭들  : x  ,  y  + (y 인덱스 차 ) = 해당 이동 중심 y  // 아래블럭들 : x ,  y - (y 인덱스 차 ) 
	        // 270 도 회전시 : 위에 블럭들:  -y 인덱스 차 + x , y = 해당 이동 중심 y  // 아래블럭들 : (y 인덱스 차) + x ,  y  
	        
	        //y 좌표가 같은 때 
	        //90도 회전시) 왼쪽 블럭들:  x , y - x 인덱스 차    // 오른쪽블럭들 : + x ,  y + (x 인덱스 차) 
	        // 180 회전시) 왼쪽에블럭들  : x  + x 인덱스 차   ,  y  // 아래블럭들 : x - x 인덱스 차   ,  y 
	        // 270 도 회전시 ) 왼쪽 블럭들:  x , y + x 인덱스 차    // 오른쪽블럭들 : + x ,  y - (x 인덱스 차)   
	        
	        // x , y좌표가 다를 때
	        // 해당 중심좌표에서 왼쪽위 대각선 방향일 때 :
	        /*
	         * 90  x + x 인덱스차: , y
	         * 180 : x + x 인덱스차 , y + y인덱스 차
	         * 270 : x , y + y인덱스 차
	         */
	        
	        // 해당 중심좌표에서 오른쪽위 대각선 방향일 때 
	        /*
	         * 180 :  x - x 인덱스차: , y + y인덱스 차
	         * 270 : x - x 인덱스차 , y
	         * 90 : x , y + y인덱스 차
	         */
	        // 해당 중심좌표에서 오른쪽밑 대각선 방향일 때
	        /*
	         * 90 :  x - x 인덱스차: , y
	         * 180 : x - x 인덱스차 , y - y인덱스 차
	         * 270 : x , y - y인덱스 차
	         */
	        // 해당 중심좌표에서 왼쪽밑 대각선 방향일 때 
	        /*
	         * 90 :  x 인덱스차: , y - y인덱스차
	         * 180 : x + x 인덱스차 , y - y인덱스 차
	         * 270 : x + x 인덱스차 , y
	         */
	        
	        
	        return answer;
	    }
	    public boolean Rotate0(int[][] key, int moveX, int moveY) {
        	return false;
        }
	    
        public boolean Rotate90(int[][] key, int moveX, int moveY) {
        	return false;
        }
        public boolean Rotate180(int[][] key, int moveX, int moveY) {
        	return false;
        }
        public boolean Rotate270(int[][] key, int moveX, int moveY) {
        	return false;
        }
	}
}
