import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
       Set<Integer> set = new HashSet<Integer>();
       FindDeciaml(numbers, set);
    	return set.size();
    }
    private int FindDeciaml(String numbers, Set<Integer> set) {
    	int answer = 0;
//    	if(numbers.length() == 0) return 0; // ��� ��������
//    	
//    	for(int i = 0; i < numbers.length(); i++) {
//    		if(numbers.indexOf(i) == '0') continue;
//    		StringBuilder builder= new StringBuilder();
//    		builder.append(numbers.indexOf(i));
//    		int repeat =  1;
//    		for(int r = 1; r < numbers.length() - 1; r++) repeat*= r;
//    		while(repeat > 0) {
//    			repeat--;
//    		}
//    	}
    	
    	
    	
    	
    	return answer;
    }
    private boolean checkDeciaml(int num) {
    	
    	if(num < 2) return false; // �Ҽ��ƴ�
    	else if(num == 0) return true;
    	else if(num % 2 == 0) return false;
    	
    	for(int i = 2; i < num;i++) {
    		if(num % i  == 0) return false;
    	}
    	return true; // �Ҽ�
    }
}
public class FindDecimal {

	public static void main(String[] args) {
		//¦���� �Ǹ�ȵȴ�.

	}

}
