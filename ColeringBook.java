
class Solution {
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];
		for (int i = 0; i < m; i++)
	    {
	        for (int j = 0; j < n; j++)
	        {
	            if (picture[i][j] == 0)
	                continue;
	          
	            int temp = checkarea(picture[i][j], i, j, m, n,picture);
	            maxSizeOfOneArea = (temp > maxSizeOfOneArea) ? temp : maxSizeOfOneArea;            
	            numberOfArea++;
	        }
	    }
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	int checkarea(int type, int x, int y, int m, int n,int[][] area) {
	    // if passed || out of range
	    if (x >= m || y >= n || x < 0 || y < 0 || type != area[x][y])
	        return 0;

	    area[x][y] = 0; // passed pos
	    int result = 1; // self count

	    result += checkarea(type, x - 1, y, m, n, area);  // left
	    result += checkarea(type, x, y - 1, m, n, area);  // top
	    result += checkarea(type, x + 1, y, m, n, area);  // right
	    result += checkarea(type, x, y + 1, m, n, area);  // bottom

	    return result; 
	}
}

public class ColeringBook {

	public static void main(String[] args) {
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int[] value = new Solution().solution(6, 4, picture);
		System.out.println(value[0]+"\t"+value[1]);
	}
}
