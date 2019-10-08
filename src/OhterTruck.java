import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * class Solution { public int solution(int[] people, int limit) { int answer =
 * 0; // 간사람은 0으로 바꿔서 해결하자. //
 * 
 * int totalWeight = 0; int idx = 0; for(int w : people) { totalWeight += w; }
 * while(totalWeight > 0) { int rideOnBoatPeopleCount = 0; int weight = 0;
 * for(int i = idx; i<people.length;i++) { if(people[idx] == 0) {idx++; break;}
 * if(people[i]+ weight > limit) {} else if( people[i]+ weight == limit) {
 * if(rideOnBoatPeopleCount > 0) { int equalWeight = 0; for(int j =
 * idx;j<people.length;j++) { if(people[j] == 0) continue; if(equalWeight +
 * people[j] == limit) { equalWeight += people[j]; people[j] = 0; break; }else
 * if(equalWeight + people[j] < limit) { equalWeight += people[j]; people[j] =
 * 0; } } } people[idx] = 0; totalWeight -= limit; answer++; idx++; break; }
 * else if( people[i]+ weight < limit) { weight += people[i];
 * rideOnBoatPeopleCount++; }
 * 
 * if(i == people.length - 1) { // 맨끝이라면... int equalWeight = 0;
 * if(rideOnBoatPeopleCount > 0) { for(int j = idx;j<people.length;j++) {
 * if(people[j] == 0) continue; if(equalWeight + people[j] == limit) {
 * equalWeight += people[j]; people[j] = 0; break; }else if(equalWeight +
 * people[j] < limit) { equalWeight += people[j]; people[j] = 0; } } }
 * people[idx] = 0; totalWeight -= equalWeight; answer++; idx++; } } }
 * 
 * return answer; } }
 * 
 * 
 * public class Lifeboat {
 * 
 * public static void main(String[] args) { int[] people= {70,50,80,50};
 * System.out.println(new Solution().solution(people, 100));
 * 
 * }
 * 
 * }
 */


class Solution {
	 public void increaseTime(Queue<Integer> time) {
	        int queueSize = time.size();
	        
	        for(int i = 0; i < queueSize; i++) {
	            time.offer(time.poll() + 1);
	        }
	    }
	
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curWeight = 0;
        int acrossCount = 0;
        Queue<Integer> truck_time = new LinkedList<Integer>();
        
        while(acrossCount < truck_weights.length) {
        	answer++;
        	
        	
        	
        	if(truck_weights[acrossCount] + curWeight <=weight) {
        		curWeight+= truck_weights[acrossCount];
        		acrossCount++;
        		 truck_time.offer(0);
        	}
        	increaseTime(truck_time);
        	
        	if(truck_time.peek() == bridge_length) {
                curWeight -= truck_weights[acrossCount - truck_time.size()];
                truck_time.poll();
        	}
        }
        answer+=bridge_length;
        return answer;
    }
}



public class OhterTruck{
	public static void main(String[]args) {
		int[] truck_weights = {7,4,5,6};
		System.out.println(new Solution().solution(2, 10, truck_weights));
	}
}
