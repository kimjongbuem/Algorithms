import java.util.PriorityQueue;

public class ShuttleBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] timeTable = {"08:00", "08:01", "08:02", "08:03"};
		System.out.println(new ShuttleBus().new Solution().solution(1, 1, 5, timeTable));

	}
	/** ��α׿� ������ ���� �Ͽ� ������ Ǯ�����ϴ�. // ���ذ� �Ȱ��� �Ф� 
	* 1. con�� ����� �ϱ� �ؾ��Ѵ�
	* 2. con�� ���� �ʰ� ���������忡 �����ϰ� �ʹ�
	* 3. ��, ������ ����(����)�� Ÿ�� �Ǵµ�, ��� ��п� ���� ���� �ϴ��� �˾Ƴ�����
	* 4. ��� crew�� ����� ����Ǵ� ���� �ƴϴ�. �׷��Ƿ� ó������ ������� �ùķ��̼��� �غ��鼭 ���� �ʰ� ������ �� �ִ� �ð��� ���غ���
	* 5-1. ������ ������ ���� ���, con�� ���� ���� �ð��� ���� �����忡 �����ϸ� �ȴ�
	* 5-2. ������ ������ ���� �ʴ� ���, con�� �������� ž���� crew���� 1�� ���� �����忡 �����ϸ� �ȴ�
	*/

	class Solution {
		  public String solution(int n, int t, int m, String[] timetable) {
		      String answer = "";
		      PriorityQueue<Time> pq = new PriorityQueue<Time>();
		      for(int i = 0; i < timetable.length;i++) pq.add(new Time(timetable[i]));
		      Time conTime = new Time("00:00"); // ���� ���ϴ��� �� �ִ� �ð�.
		      
		      for(int i = 0; i < n; i++) { // �����ϴ� ���� Ƚ��.
		    	  Time busTime = new Time("09:00"); // ���� ����!
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
