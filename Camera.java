
public class Camera {

	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
			//{{-2,-1},{1,2},{-3,0}};
		System.out.println(
		new Camera().new Solution().solution(routes));

	}
	class Solution {
	    public int solution(int[][] routes) {
	    	if(routes.length == 1) return 1;
	        int answer = 1;
	        
	        for(int i = 0; i < routes.length; i++)
	        {
	        	if(routes[i][0] >routes[i][1]) {
	        		int temp = routes[i][0];
	        		routes[i][0] = routes[i][1];
	        		routes[i][1] = temp;
	        	}
	        }
	        
	        boolean[] check = new boolean[routes.length];
	        
	        
	        
	        for(int r = 0; r < routes.length - 1; r++)
	        {int minIndex = 0; int minCount = 70000;
	        	if(check[r]) continue; boolean add = false;
	        	for(int i = 0; i < routes.length; i++)
		        {
	        		if(check[i]) continue;
	        		int c = 0; 
	        		if(routes[i][1] >= 0) {
	        			if(routes[i][0] >= 0) c = routes[i][1] - routes[i][0];
	        			else c = routes[i][1] - routes[i][0];
	        		}else c = -routes[i][0] + routes[i][1];
	        		
		        	if( c < minCount && !check[i]) {
		        		minCount = c;
		        		minIndex = i;
		        	}
		        }
	        	for(int i = 0; i < routes.length; i++)
		        {
	        		if(!check[i]&&(routes[i][0] <= routes[minIndex][0] && routes[minIndex][0] <= routes[i][1])||
	        				(routes[i][0] <= routes[minIndex][1] && routes[minIndex][1] <= routes[i][1]))check[i] = true;
	        		else if(!add && !check[i]) {
	        			add = true; answer++;
	        		}
		        }
	        }
	        
	        return answer;
	    }
	}
}
