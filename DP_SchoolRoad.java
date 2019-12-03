
public class DP_SchoolRoad {

	public static void main(String[] args) {
		//int[][] puddles = {{2,2}};
		int[][] puddles = {{1,2},{2,2},{3,2},{4,2},{5,4},{2,4},{3,4},{4,4}};
		System.out.println(new DP_SchoolRoad().new Solution().solution(5, 5, puddles));

	}
	class Solution {
		private int x, y ;
		boolean[][] map;
	    public int solution(int m, int n, int[][] puddles) {
	        int[][] d = new int[n + 1][m + 1];
	        d[1][0] = 1;
	        if(m==1 && n==1) return 1;
	        x = m; y = n;
	        map = new boolean[n + 1][m + 1];
	        for(int i = 0; i < puddles.length;i++) {
	        	map[puddles[i][1]][puddles[i][0]] = true; // -1은 못움직임.
	        }
	        for(int i = 1; i <= n; i++) {
	        	for(int j = 1; j <= m; j++) {
		        	if(map[i][j]) d[i][j] = 0;
		        	else {
		        		d[i][j] = d[i - 1][j] + d[i ][j - 1]  % 1000000007; 
		        	}
		        }
	        }
	        return d[n][m];
	    }
//	    public int recursive(int m, int n, int sx, int sy,int answer) { // 최단경로 recursive
//	    	if(sx < 0 || sy < 0) return Integer.MAX_VALUE;
//	    	
//	    	if(m - 1 ==sx && n - 1 ==sy) return (answer - 1)% 1000000007;
//	    	else if(map[sy][sx]) return Integer.MAX_VALUE;
//	    	else if(m - 1 == sx) {
//	    		map[sy][sx] = true;
//	    		int a = recursive(m,n ,sx - 1,sy,answer+1% 1000000007);
//	    		int b= recursive(m,n, sx,sy + 1,answer+1)% 1000000007;
//	    		return(a > b? b : a)% 1000000007;
//	    	}
//	    	else if(n - 1 == sy) {
//	    		map[sy][sx] = true;
//	    		int a = recursive(m,n,sx+ 1,sy,answer+1) % 1000000007;
//	    		int b= recursive(m,n,sx,sy - 1,answer+1) % 1000000007;
//	    		return (a > b? b : a) % 1000000007;
//	    	}
//	    	else {
//	    		map[sy][sx] = true;
//	    		int a = recursive(m,n,sx + 1,sy,answer+1) % 1000000007;
//	    		int b = recursive(m,n,sx,sy + 1,answer+1) % 1000000007;
//	    		int c = recursive(m,n,sx - 1,sy,answer+1) % 1000000007;
//	    		int d = recursive(m,n,sx,sy - 1,answer+1) % 1000000007;
//	    		int v1 =  (a > b? b : a) % 1000000007; int v2 =  (c > d? d : c) % 1000000007;
//	    		return (v1>v2?v2:v1) % 1000000007;
//	    	}
//	    }
//	}
	}
}
//#include <vector> using namespace std; 
//int solution(int m, int n, vector<vector<int>> puddles) {
// int map[101][101] = {0,}; int d[101][101]; // set puddles into map.
// for (auto v : puddles) map[v[1]][v[0]] = -1; 
//d[1][0] = 1; for (int i=1 ; i<=n ; i++) { 
//for (int j=1; j<=m ; j++) { 
//if (map[i][j] == -1) d[i][j] = 0; 
//else 
//d[i][j] = (d[i-1][j] + d[i][j-1]) % 1000000007; 
//} 
//
//} 
//
//return d[n][m]; }