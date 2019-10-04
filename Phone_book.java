import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length - 1;i++) {
        	for(int j = i + 1; j<phone_book.length;j++) {
            	if(phone_book[i].length() > phone_book[j].length()) continue;
            	if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())))
        			return false;
            }
        }
        return answer;
    }
}

public class Phone_book {
	public static void main(String arg[]) {
		String[] s = {"119", "97674223", "1195524421"};
		System.out.println(new Solution().solution(s));
	}
}
