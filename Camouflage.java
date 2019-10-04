import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
        	if(hash.containsKey(clothes[i][1])) hash.replace(clothes[i][1], hash.get(clothes[i][1]) + 1);
        	else hash.put(clothes[i][1], 1);
        }

        int answer = 1;
        for (int value : hash.values()) {
            answer*=(value+1);
        }
        answer-=1;
        
        return answer;
    }
}

public class Camouflage {
	public static void main(String arg[]) {

	}
}
