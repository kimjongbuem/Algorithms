
public class DP_SchoolRoad {

	public static void main(String[] args) {
		int[][] puddles = {{1,2},{2,2},{3,2},{4,2},{5,4},{2,4},{3,4},{4,4}};
		System.out.println(new DP_SchoolRoad().new Solution().solution(5, 5, puddles));

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
	        answer = recursive(m,n, 0,0,0);
	        return answer;
	    }
	    public int recursive(int m, int n, int sx, int sy,int answer) {
	    	if(sx < 0 || sy < 0) return Integer.MAX_VALUE;
	    	
	    	if(m - 1 ==sx && n - 1 ==sy) return (answer - 1)% 1000000007;
	    	else if(map[sy][sx]) return Integer.MAX_VALUE;
	    	else if(m - 1 == sx) {
	    		map[sy][sx] = true;
	    		int a = recursive(m,n ,sx - 1,sy,answer+1% 1000000007);
	    		int b= recursive(m,n, sx,sy + 1,answer+1)% 1000000007;
	    		return(a > b? b : a)% 1000000007;
	    	}
	    	else if(n - 1 == sy) {
	    		map[sy][sx] = true;
	    		int a = recursive(m,n,sx+ 1,sy,answer+1) % 1000000007;
	    		int b= recursive(m,n,sx,sy - 1,answer+1) % 1000000007;
	    		return (a > b? b : a) % 1000000007;
	    	}
	    	else {
	    		map[sy][sx] = true;
	    		int a = recursive(m,n,sx + 1,sy,answer+1) % 1000000007;
	    		int b = recursive(m,n,sx,sy + 1,answer+1) % 1000000007;
	    		int c = recursive(m,n,sx - 1,sy,answer+1) % 1000000007;
	    		int d = recursive(m,n,sx,sy - 1,answer+1) % 1000000007;
	    		int v1 =  (a > b? b : a) % 1000000007; int v2 =  (c > d? d : c) % 1000000007;
	    		return (v1>v2?v2:v1) % 1000000007;
	    	}
	    }
	}
}
