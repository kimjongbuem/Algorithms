
public class Algorithm {
	public static void main(String[]str) {
		System.out.println(new Algorithm().new Solution().solution(5, 24));
	}
	class Solution {
		  public String solution(int a, int b) {
			  // 2016 01 01 : Friday
			  String answer = "";	  
			switch(a) {
			case 1:
				return answer=dayOfTheWeek(b);
			case 2: b+=31;
				return answer=dayOfTheWeek(b);
			case 3: b+=60;
				return answer=dayOfTheWeek(b);
			case 4: b+=91;
				return answer=dayOfTheWeek(b);
			case 5: b+=121;
				return answer=dayOfTheWeek(b);
			case 6: b+=152;
				return answer=dayOfTheWeek(b);
			case 7: b+=182;
				return answer=dayOfTheWeek(b);
			case 8: b+=213;
				return answer=dayOfTheWeek(b);
			case 9: b+=244;
				return answer=dayOfTheWeek(b);
			case 10: b+=274;
				return answer=dayOfTheWeek(b);
			case 11: b+=305;
				return answer=dayOfTheWeek(b);
			case 12: b+=335;
				return answer=dayOfTheWeek(b);
			}
		      return answer;
		  }
		  public String dayOfTheWeek(int b){
				 String answer = "";
				if(b % 7 == 0)
					answer="THU";
				else if(b % 7 == 1)
					answer ="FRI";
				else if(b % 7 == 2)
					answer ="SAT";
				else if(b % 7 == 3)
					answer ="SUN";
				else if(b % 7 == 4)
					answer ="MON";
				else if(b % 7 == 5)
					answer ="TUE";
				else if(b % 7 == 6)
					answer ="WED";
				return answer;
			}
		}
	
}
