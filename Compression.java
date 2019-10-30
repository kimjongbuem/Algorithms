
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
  public int[] solution(String msg) {
	  int number = 1;
      int[] answer = {};
      java.util.List<Integer> list = new LinkedList<Integer>();
      Map<String, Integer> map = new HashMap<String, Integer>();
      
      for(char i = 'A'; i <= 'Z'; i++) {
    	  map.put(String.valueOf(i), number++);
      }
      number--;
      String cur=String.valueOf(msg.charAt(0)); //String next="";
      for(int i = 1; i< msg.length();i++) {
    	  String temp = cur+String.valueOf(msg.charAt(i));
    	  if(!map.containsKey(temp)) {
    		  map.put(temp, ++number);
    		  list.add(map.get(cur));
    		  cur = String.valueOf(msg.charAt(i));
    	  }
    	  else cur = temp;
    	  
      }
      cur=String.valueOf(msg.charAt(msg.length() - 1));
      if(cur.length() > 1 ) list.add(map.get(cur));
      else list.add(msg.charAt(msg.length() - 1) - 'A' + 1);
     answer = list.stream().mapToInt(i->i).toArray();
      
      return answer;
  }
}
public class Compression {

	public static void main(String[] args) {
		int[] answer= new Solution().solution("KAKAO");
		for(int i = 0; i<answer.length;i++) System.out.println(answer[i]);

	}

}
