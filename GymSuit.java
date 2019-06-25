import java.util.*;

public class GymSuit {
	public static void main(String[]args) {
		int lost[]= {2,4};  int reserve[] = {3};
		System.out.println(new GymSuit().new Solution().solution(5, lost, reserve));
	}
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
			int okMember = n - lost.length; // @1
			
			List<Integer> lostList = new ArrayList<Integer>(); // @2
			for (int i : lost) lostList.add(i);

			List<Integer> reserveList = new ArrayList<Integer>(); // @3
			for (int i : reserve) reserveList.add(i);
			
	    
	    
			for (int i = 0; i < lostList.size(); i++) { // @5
				int lostNum = lostList.get(i);
				for (int j = 0; j < reserveList.size(); j++) {
					int reserveNum = reserveList.get(j);
					if (lostNum == reserveNum - 1 || lostNum == reserveNum + 1) {
						reserveList.remove(j);
						okMember++;
						break;
					}
				}
			}

			return okMember;
		}
	}
}
