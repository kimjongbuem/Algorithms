
public class DP_SchoolRoad {

	public static void main(String[] args) {
		int[][] puddles = {{2,2}};
		System.out.println(new DP_SchoolRoad().new Solution().solution(4, 3, puddles));

	}
	class Solution {
		private int x, y ;
		boolean[][] map;
	    public int solution(int m, int n, int[][] puddles) {
	        int answer = 0;
	        if(m==1 && n==1) return 1;
	        x = m; y = n;
	        map = new boolean[n][m];
	        for(int i = 0; i < puddles.length;i++) {
	        	map[puddles[i][1] - 1][puddles[i][0] - 1] = true; // -1은 못움직임.
	        }
	        answer = recursive(m,n, puddles, 0,0,0);
	        return answer;
	    }
	    public int recursive(int m, int n, int[][] puddles,int sx, int sy,int answer) {
	    	if(m - 1 ==sx && n - 1 ==sy) return answer - 1;
	    	else if(map[sy][sx]) return -1;
	    	else if(m - 1 == sx) return recursive(m,n,puddles,sx,sy + 1,answer+1);
	    	else if(n - 1 == sy) return recursive(m,n,puddles,sx+ 1,sy,answer+1);
	    	else {
	    		int a = recursive(m,n,puddles,sx + 1,sy,answer+1);
	    		int b = recursive(m,n,puddles,sx,sy + 1,answer+1);
	    		return (a > b? a : b ) ;
	    	}
	    }
	}
}
