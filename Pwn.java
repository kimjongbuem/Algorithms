
public class Pwn {
	
		
		public static void main(String[]arg) {
			Solution s = new Solution();
			System.out.println(s.strStr("a", ""));
		}
}
class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        char[] stacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        if(haystack.equals(needle) || needle.equals(""))
        	return 0;
         if(haystack.length() < needle.length())
        	return result;
        for(int i = 0; i<haystack.length();i++) {
        	for(int j = 0; j<needles.length;j++) {
                try{
        		if(stacks[i+j] != needles[j]) {
        			break;
        		}
        		if(needles.length - 1 == j)
        		{
        			result = i;
        			return result;
        		}
                }catch(ArrayIndexOutOfBoundsException e){
                    break;
                }
        			
        	}
        }

        return result;
    }
}