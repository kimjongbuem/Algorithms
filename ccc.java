
public class ccc {
	public static void main(String arg[]) {
		int[]val=new ccc().new Solution().solution(2, 5);
		for(int i : val)
			System.out.println(i);
		
		System.out.println(13%1);
	}
	
	class Solution {
		  public int[] solution(int n, int m) { // 최대 공약수 , 최소공배수
		      int[] answer = new int[2];
		      answer[0] =gcd(n,m);
		      answer[1] =gmd(n,m);
		      return answer;
		  }
		}
		int gcd(int n, int m) {
			int smaller = m < n? m:n;
			for(int i = smaller; i>=1;i--) {
				if(n%i==0 && m%i==0)
					return i;
			}
			return -1; // error
		}
		int gmd(int n, int m) {
			int val = gcd(n,m);
			return val* (n/val) * (m/val); 
		}
}
