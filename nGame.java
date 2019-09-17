import java.util.Stack;

class Solution {
	public String solution(int n, int t, int m, int p) {
		String answer = "";
		int cur_number = 1;
		int my_number = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int next = p;
		int cur = 1;
			while (my_number < t) {
				int idx = 0;
				String s="";
				if(n <= 10) s = getBaseString(stack, cur - 1, n,true);
				else  s = getBaseString(stack, cur - 1, n,false);
				char[] c = s.toCharArray();
				int length = s.length();
				while (length == 0 && idx == 0 || idx < length) {
					if (cur_number == next) {
						next += m;
						answer += c[idx];
						my_number++;
						if(my_number == t) break;
					} 
					cur_number++;
					idx++;
				}
				cur++;
			}
		return answer;
	}

	public <String getBaseString(Stack<Integer> stack, int num, int deviceN, boolean is10down) {
		String base = "";
		if (num == 0)
			return "0";

		while (num != 0) {
			int r = num % deviceN;
			num /= deviceN;
			stack.push(r);
		}
		while (!stack.empty()) base += stack.pop().toString();
		
		return base;
	}
}

public class nGame {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(2, 4, 2, 1));

	}

}
