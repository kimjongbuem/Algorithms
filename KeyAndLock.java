
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

	        
	        
	        // x ��ǥ��  ������  
	        // �״��..
	        //90�� ȸ����) ���� ����:  y �ε��� �� + x , y = �ش� �̵� �߽� y  // �Ʒ����� : -(y �ε��� ��) + x ,  y
	        // 180 ȸ����) ��������  : x  ,  y  + (y �ε��� �� ) = �ش� �̵� �߽� y  // �Ʒ����� : x ,  y - (y �ε��� �� ) 
	        // 270 �� ȸ���� : ���� ����:  -y �ε��� �� + x , y = �ش� �̵� �߽� y  // �Ʒ����� : (y �ε��� ��) + x ,  y  
	        
	        //y ��ǥ�� ���� �� 
	        //90�� ȸ����) ���� ����:  x , y - x �ε��� ��    // �����ʺ��� : + x ,  y + (x �ε��� ��) 
	        // 180 ȸ����) ���ʿ�����  : x  + x �ε��� ��   ,  y  // �Ʒ����� : x - x �ε��� ��   ,  y 
	        // 270 �� ȸ���� ) ���� ����:  x , y + x �ε��� ��    // �����ʺ��� : + x ,  y - (x �ε��� ��)   
	        
	        // x , y��ǥ�� �ٸ� ��
	        // �ش� �߽���ǥ���� ������ �밢�� ������ �� :
	        /*
	         * 90  x + x �ε�����: , y
	         * 180 : x + x �ε����� , y + y�ε��� ��
	         * 270 : x , y + y�ε��� ��
	         */
	        
	        // �ش� �߽���ǥ���� �������� �밢�� ������ �� 
	        /*
	         * 180 :  x - x �ε�����: , y + y�ε��� ��
	         * 270 : x - x �ε����� , y
	         * 90 : x , y + y�ε��� ��
	         */
	        // �ش� �߽���ǥ���� �����ʹ� �밢�� ������ ��
	        /*
	         * 90 :  x - x �ε�����: , y
	         * 180 : x - x �ε����� , y - y�ε��� ��
	         * 270 : x , y - y�ε��� ��
	         */
	        // �ش� �߽���ǥ���� ���ʹ� �밢�� ������ �� 
	        /*
	         * 90 :  x �ε�����: , y - y�ε�����
	         * 180 : x + x �ε����� , y - y�ε��� ��
	         * 270 : x + x �ε����� , y
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
