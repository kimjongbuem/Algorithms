class Solution
{
    public int solution(int n, int a, int b)
    {
    	int answer = 0;
    	
    	if(n <= 0) return 0;
    	
        if( (a <= n/2 && b <= n/2) || (a > n/2 && b > n/2) )
        	return solution(n/2, a, b);
        else {
        	int mul = 1;
        	while(true) {
        		answer++; mul*=2;
        		if(mul == n) break;
        	}
        }

        return answer;
    }
}
public class Expected_Draw {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(8, 4, 2));

	}
}
