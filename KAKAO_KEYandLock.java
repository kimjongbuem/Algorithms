
public class KAKAO_KEYandLock {

	public static void main(String[] args) {
		 int[][] key = {
			        {0, 0, 0},
			        {1, 0, 0},
			        {0, 1, 1}
			    };	 
		 int[][] lock = {
			        {1, 1, 1},
			        {1, 1, 0},
			        {1, 0, 1}
			    };
		 System.out.println(new KAKAO_KEYandLock(). new Solution().solution(key, lock));
	}
	class Solution {
		int[][] Lock;
		int lock_length;
	    public boolean solution(int[][] key, int[][] lock) {
	        lock_length = lock.length;
	        Lock = Magnify(lock);
	        for(int R = 0; R < 4; R++) { // rotate;
	        	key = Rotate(key);
	        	for(int c = 0; c <= Lock.length - key.length; c++)
	        		for(int r = 0; r <= Lock[0].length - key[0].length; r++)
	        			if(check(key, c, r)) return true;
	        }
	        return false;
	    }
	    
	    public int[][]Magnify(int[][] lock){
	    	int r = 0, c = 0;
	    	int[][] ret = new int[lock.length * 3][lock[0].length * 3]; // 세배증가.
	    	for(int i = lock.length; i < ret.length - lock.length; i++) {
	    		for(int j = lock[0].length; j < ret[0].length - lock[0].length; j++) {
		    		ret[i][j] = lock[c][r]; r++;
		    		if(r == lock_length) {
		    			c++; r = 0;
		    		}
		    	}
	    	}
	    	return ret;
	    }
	    
	    
	    public int[][] Rotate(int[][] key){
	    	int[][] ret = new int[key.length][key[0].length];
	    	for(int c = 0; c < key.length; c++) {
	    		int rr = 0;
	    		for(int r = key[0].length - 1; r >= 0 ; r--) {
		    		ret[c][rr] = key[r][c]; rr++;
		    	}
	    	}
	    	return ret;
	    }
	    public boolean check(int[][] key, int col, int row) {
	    
	    	
	    	int[][] temp = new int[Lock.length][Lock[0].length];
	    	for(int i = 0; i < Lock.length; i++) {
	    		for(int j = 0; j < Lock[0].length; j++) {
		    		temp[i][j] = Lock[i][j];
		    	}
	    	}
	    	for (int i = 0; i < key.length; i++) {
	    		for (int j = 0; j < key[0].length; j++) {
	    			temp[col + i][row + j] += key[i][j];
	    		}
	    	}

	    
	    	
	    	for (int i = key.length; i < key.length * 2; i++)
	    	{
	    		for (int j = key[0].length; j < key[0].length * 2; j++)
	    		{
	    			if (temp[i][j] == 1) continue;
	    			else {
	    				return false;
	    			}
	    		}
	    	}
	    	return true;
	    	
	    }
	}
}
