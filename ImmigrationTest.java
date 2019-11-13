import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ImmigrationTest {

//	public static void main(String[] args) {
//		int [] times= {7,10};
//		System.out.println(new ImmigrationTest().new Solution().solution(6, times));
//
//	}
//	class Solution {
//	    public long solution(int n, int[] times) {
//	        long answer = 0;
//	        List<Tester> list = new LinkedList<ImmigrationTest.Tester>();
//	        for(int time : times) {
//	        	list.add(new Tester(time)); //큐에 비어있음에도 불구하고 추가를 못할경우 리스트에서 ㅏㄱ제
//	        }
//	        int p = times.length;
//	        
//	      for(int i = 0; i < list.size(); i++) list.get(i).Add();
//	        while(!checkEnd(list) ||  p != n) {
//	        	if(isEmptyListAnyMatch(list)) {
//	        		if(p < n ) p++;
//	        		Add(list);
//	        		if(p == n) {
//	        			Remove(list);
//	        		}
//	        	}
//	        	for(int i = 0; i < list.size(); i++) list.get(i).DecrementTime();
//	        	
//	        	answer++;
//	        }
//	        
//	        
//	        return answer;
//	    }
//	    public void Remove(List<Tester> list) {
//	    	for(int i = 0; i < list.size(); i++)
//	    		if(list.get(i).isEmpty()) list.remove(i);
//	    }
//	    
//	    public void Add(List<Tester> list) {
//	    	int minIndex = 0; int min = Integer.MAX_VALUE;
//	    	for(int i = 0; i < list.size(); i++) {
//	    		if(list.get(i).GetWaitingTime() < min) {
//	    			minIndex = i; 
//	    			min = list.get(i).GetWaitingTime();
//	    		}
//	    	}
//	    	list.get(minIndex).Add();
//	    }
//	    public boolean isEmptyListAnyMatch(List<Tester> list) {
//	    	return list.stream().anyMatch(
//	    			l -> {
//	    			if(l.GetTesterDestList().isEmpty()) return true;
//	    			return false;
//	    			});
//	    }
//	    public boolean checkEnd(List<Tester> list) {
//	    	return list.stream().allMatch(
//	    			l -> {
//	    			if(l.GetTesterDestList().isEmpty()) return true;
//	    			return false;
//	    			});
//	    }
//	}
//	class Tester{
//		private int time;
//		List<Integer> testerDesk;
//		public Tester(int time) {
//			this.time = time;
//			testerDesk = new LinkedList<Integer>();
//		}
//		public int GetWaitingTime() {
//			if(testerDesk.isEmpty()) return time;
//			return time + testerDesk.get(0);
//		}
//		
//		public void DecrementTime() {
//			if(testerDesk.isEmpty()) return;
//			testerDesk.set(0, testerDesk.get(0) - 1);
//			if(testerDesk.get(0) == 0) testerDesk.remove(0);
//		}
//		public List<Integer> GetTesterDestList(){
//			return testerDesk;
//		}
//		public void Add() {
//			testerDesk.add(time);
//		}
//		public int GetTime() {
//			return time;
//		}
//		public boolean isEmpty() {
//			return testerDesk.isEmpty();
//		}
//	}
	public static void main(String[] args) {
        int n = 6;
        int[] times = new int[] { 7, 10 };
 
       ImmigrationTest examination = new ImmigrationTest();
        System.out.println(examination.solution(n, times));
    }
 
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        if (times.length >= n) {
            return times[times.length - 1];
        }
        long answer = times[0] - 1;
        while (n > 0) {
            answer++;
            for (int i = 0; i < times.length && n != 0; i++) {
                if (answer % times[i] == 0) {
                    n--;
                }
            }
        }
        return answer;
    }
}
