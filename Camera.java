
public class Camera {

	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		new Camera().new Solution().solution(routes);

	}
	class Solution {
	    public int solution(int[][] routes) {
	        int answer = 0;
	        boolean[] check = new boolean[routes.length];
   
	        for(int r = 0; r < routes.length - 1; r++)
	        {int midValue = 0; int minCount = 70000;
	        	if(check[r]) continue; boolean add = false;
	        	for(int i = 0; i < routes.length; i++)
		        {
	        		int c = Math.abs(routes[i][0]) + Math.abs(routes[i][1]);
		        	if( c < minCount && !check[i]) {
		        		minCount = c;
		        		if(routes[i][1] >= 0) {
		        			if(routes[i][0] >= 0) midValue = (routes[i][0] + routes[i][1]) / 2;
		        			else midValue = routes[i][0] + routes[i][1];
		        		}else midValue = (routes[i][0] + routes[i][1]) / 2;	
		        	}
		        }
	        	for(int i = 0; i < routes.length; i++)
		        {
	        		if(!check[i]&&routes[i][0] <= midValue && midValue <= routes[i][1]) check[i] = true;
	        		else if(!add && !check[i]) {
	        			add = true; answer++;
	        		}
		        }
	        }
	        
	        return answer;
	    }
	}
}
