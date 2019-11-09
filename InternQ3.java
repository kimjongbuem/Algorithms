
public class InternQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};	
		String[] banned_id = {"*rodo", "*rodo", "******"};
				System.out.println(new InternQ3().new Solution().solution(user_id, banned_id));
				
			//	System.out.println(new InternQ3().new Solution().solution(user_id, banned_id));
				

	}
	class Solution {
	    public int solution(String[] user_id, String[] banned_id) {
	        int answer = 0;
	        int banCount = banned_id.length;
	         for(int i = 0; i < user_id.length; i++) {
	        	 int count = 0;
	       
	 	        
	        	 if(count == banCount) answer++;
	        }
	        
	        return answer;
	    }
	}
}
