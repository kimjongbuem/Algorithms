import java.util.PriorityQueue;

public class ShuttleBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] timeTable = {"08:00", "08:01", "08:02", "08:03"};
		System.out.println(new ShuttleBus().new Solution().solution(1, 1, 5, timeTable));

	}
	/** 블로그와 동영상 참고를 하여 문제를 풀었습니다. // 이해가 안가서 ㅠㅠ 
	* 1. con은 출근을 하긴 해야한다
	* 2. con은 가장 늦게 버스정류장에 도착하고 싶다
	* 3. 즉, 마지막 버스(막차)를 타면 되는데, 몇시 몇분에 줄을 서야 하는지 알아내보자
	* 4. 모든 crew의 출근이 보장되는 것은 아니다. 그러므로 처음부터 순서대로 시뮬레이션을 해보면서 가장 늦게 도착할 수 있는 시간을 구해보자
	* 5-1. 버스의 정원이 남는 경우, con은 버스 도착 시간에 맞춰 정류장에 도착하면 된다
	* 5-2. 버스의 정원이 남지 않는 경우, con은 마지막에 탑승한 crew보다 1분 일찍 정류장에 도착하면 된다
	*/

	class Solution {
		  public String solution(int n, int t, int m, String[] timetable) {
		      String answer = "";
		      PriorityQueue<Time> pq = new PriorityQueue<Time>();
		      for(int i = 0; i < timetable.length;i++) pq.add(new Time(timetable[i]));
		      Time conTime = new Time("00:00"); // 콘이 제일늦을 수 있는 시간.
		      
		      for(int i = 0; i < n; i++) { // 도착하는 버스 횟수.
		    	  Time busTime = new Time("09:00"); // 버스 시작!
		    	  busTime.add(i, t);
		    	  conTime = busTime;
		    	  int capacity = m;
		    	  while(!pq.isEmpty() && capacity > 0) {
		    		  Time crew = pq.poll();
		    		  if(capacity == 1) {
		    			crew.add(1, -1);
		    			conTime = crew;
		    		  }
		    		  capacity--;
		    	  }
		      }
		      
		      return conTime.toString();
		  }
		  
		  class Time implements Comparable<Time>{
			  int h, m ;
			  Time(String timedata){
				  h = Integer.parseInt(timedata.substring(0,2));
				  m = Integer.parseInt(timedata.substring(3,5));
			  }
			  void add(int n, int t) {
				  int th = (n* t) / 60;
				  int tt = (n* t) % 60;
				  h += th; m += tt;
				  if(m >= 60) {
					  h += m / 60;
					  m = m % 60;
				  }else if(m < 0) {
					  h--;
					  m = 60 + m;
				  }
			  }
			  @Override
			  public String toString() {
				  return String.format("%02d:%02d", this.h, this.m);
			  }
			  
			  @Override
			  public int compareTo(Time o) {
				  return o.h > h? 1 : o.h < h? -1 : o.m > m ? 1 : 0;
			  }
			  
		  }
		}
}
