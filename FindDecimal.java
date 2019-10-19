import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
       Set<Integer> set = new HashSet<Integer>();
       FindDeciaml(numbers.toCharArray(), set,0);
    	return set.size();
    }
    private void FindDeciaml(char[] numbers, Set<Integer> set, int depth) {
    	if(depth == numbers.length && checkDeciaml(Integer.parseInt(new String(numbers)))) { 
    		set.add(Integer.parseInt(new String(numbers)));
    		return;
    	}
    	for(int i = depth; i < numbers.length; i++) {
    		rightRotate(numbers, i, depth);
    		FindDeciaml(numbers, set, depth + 1);
    		leftRotate(numbers, i, depth);
    	}
    	
    }
    public static void rightRotate(char[] numbers, int e, int s) {
    	char temp = numbers[e];
		
		for(int i=e; i>s; i--) {
			numbers[i] =numbers[i - 1];
		}
		numbers[s] = temp;
	}
	public static void leftRotate(char[] numbers, int s, int e) {
    	char temp =numbers[e];
		for(int i=e; i<s; i++) {
			numbers[i] = numbers[i + 1];
		}
		numbers[s] = temp;
	}
    private boolean checkDeciaml(int num) {
    	
    	if(num < 2) return false; // 소수아님
    	else if(num == 0) return true;
    	else if(num % 2 == 0) return false;
    	
    	for(int i = 2; i < num;i++) {
    		if(num % i  == 0) return false;
    	}
    	return true; // 소수
    }
}
public class FindDecimal {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("17"));

	}

}
