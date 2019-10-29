import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
  public int[] solution(String msg) {
	  int number = 27;
      int[] answer = {};
      java.util.List<Integer> list = new LinkedList<Integer>();
      Map<String, Integer> map = new HashMap<String, Integer>();
      String cur=String.valueOf(msg.charAt(0)); //String next="";
      for(int i = 1; i< msg.length();i++) {
    	  String temp = cur+String.valueOf(msg.charAt(i));
    	  if(!map.containsKey(temp)) {
    		  map.put(temp, number);
    		  list.add(number++);
    		  cur = String.valueOf(msg.charAt(i));
    	  }
    	  else {
    		  if(cur.length() > 1) list.add(map.get(cur));
    		  else list.add(msg.charAt(msg.length() - 1) - 'A' + 1);
    		  cur = temp;
    	  }
      }
      cur=String.valueOf(msg.charAt(msg.length() - 1));
      if(cur.length() > 1 ) list.add(map.get(cur));
      else list.add(msg.charAt(msg.length() - 1) - 'A' + 1);
      
      return answer;
  }
}
public class Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
