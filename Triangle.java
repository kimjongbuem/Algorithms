import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		new Triangle().new Solution().solution(triangle);

	}
	class Solution {
	    public int solution(int[][] triangle) {
	        int answer = 0;
	        int m = triangle.length;
	        int[][] d = new int[m][m];
	        d[0][0] = triangle[0][0];
	        for(int i = 0; i < m - 1; i++) {
	        	for(int j = 0; j < i + 1; j++) {
		        	int temp = triangle[i + 1][j] + d[i][j];
		        	if(d[i+1][j] < temp) d[i+1][j] = temp; 
		        	temp = triangle[i + 1][j + 1] + d[i][j];
		        	if(d[i+1][j + 1] < temp) d[i+1][j + 1] = temp;
		        }
	        }
	        Arrays.sort(d[m - 1]);
	        return d[m-1][m-1];
	    }
	}
}
