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

class TruckState{
	private int weight, location;
	TruckState(int weight, int location){
		this.weight = weight; 
		this.location = location;
	}
	public int getWeight(){return weight;}
	public int getLocation() {return location;}
	public void setLocation() {location+=1;}
}


class Solution {
	static int acrossCount = 0;
	static int curWeight = 0;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> weightTruckQueue = new LinkedList<Integer>();
        List<TruckState> truckStateList = new LinkedList<TruckState>();
        
        for(int v : truck_weights) {
        	weightTruckQueue.add(v);
        }
        
        while(acrossCount < truck_weights.length) {
        	answer++;
        	if(weightTruckQueue.isEmpty() || curWeight + weightTruckQueue.peek() <= weight) {
        		curWeight += weightTruckQueue.peek();
        		if(!weightTruckQueue.isEmpty()) truckStateList.add(new TruckState(weightTruckQueue.poll(), 0));
        		truckStateList.stream().forEach(t -> {
        			t.setLocation();
        			if(t.getLocation() == bridge_length) {
        				curWeight -= t.getWeight();
        				truckStateList.remove(t);
        				acrossCount++;
        			}
        		});	
        	}
        }
        
        return answer;
    }
}



public class Truck{
	public static void main(String[]args) {
		int[] truck_weights = {7,4,5,6};
		System.out.println(new Solution().solution(2, 10, truck_weights));
	}
}
