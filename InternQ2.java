import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class InternQ2 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] answer = new InternQ2().new Solution().solution1(s);
		for(int i : answer) System.out.print(i+" ");
		System.out.println();
		answer = new InternQ2().new Solution().solution(s);
		for(int i : answer) System.out.print(i+" ");

	}
	class Solution {
	    public int[] solution1(String s) {
	        int[] answer = {};
	        Set<Integer> set = new HashSet<Integer>();
	        StringTokenizer st = new StringTokenizer(s,"{}");
			while(st.hasMoreTokens()) {
				String ss = st.nextToken();
				if(ss.equals(",")) continue;
				
				StringTokenizer sr = new StringTokenizer(ss, ",");
				while(sr.hasMoreTokens()) {
					set.add(Integer.valueOf(sr.nextToken()));
				}
			}
			answer = set.stream().mapToInt(i->i).toArray();
	        return answer;
	    }
	    public int[] solution(String s) {
	        int[] answer = {};
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        StringTokenizer st = new StringTokenizer(s,"{}");
			while(st.hasMoreTokens()) {
				String ss = st.nextToken();
				if(ss.equals(",")) continue;
				
				StringTokenizer sr = new StringTokenizer(ss, ",");
				while(sr.hasMoreTokens()) {
					int data = Integer.valueOf(sr.nextToken());
					if(map.get(data) != null)
					map.put(Integer.valueOf(data), map.get(data) + 1);
					else
					map.put(Integer.valueOf(data), 1);
				}
			}
			List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
	        
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
	            @Override
	            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
	                int comparision = (o1.getValue() - o2.getValue()) * -1;
	                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
	            }
	        });
	        
	        answer = new int[list.size()];
	        //Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>(); 
	        int idx = 0;
	        for(Iterator<Map.Entry<Integer, Integer>> iter = list.iterator(); iter.hasNext();){
	            Map.Entry<Integer, Integer> entry = iter.next();
	            answer[idx++] = entry.getKey();
	            //sortedMap.put(entry.getKey(), entry.getValue());
	        }
	        
	        //System.out.println(sortedMap);
	        return answer;
	    }
	}
}
