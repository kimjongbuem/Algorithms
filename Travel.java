import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Travel {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

				
				//{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		new Travel().new Solution().solution(tickets);
	}
	class Solution {
	    public String[] solution(String[][] tickets) {
	        String[] answer = {};
	        LinkedList<Ticket> ticketLink = new LinkedList<Ticket>();
	        LinkedList<String> answerList = new LinkedList<String>();
	        for(int i = 0; i < tickets.length; i++) {
	        	ticketLink.add(new Ticket(tickets[i][0], tickets[i][1]));
	        }
	        
	        for(int i = 0; i < tickets.length; i++) {
	        	for(int j = 0; j < tickets.length; j++) {
		        	if(ticketLink.get(i).end.equals(ticketLink.get(j).start)) {
		        		ticketLink.get(i).link.add(ticketLink.get(j));
		        	}
		        }
	        }
	        Collections.sort(ticketLink);
	        Ticket start = null;
	        for(int i = 0; i < ticketLink.size(); i++) {
	        	if(ticketLink.get(i).start.equals("ICN")) {
	        		start = ticketLink.get(i); 
	        		break;
	        	}
	        }
	        
	        Queue<Ticket> queue = new LinkedList<Ticket>();
	        queue.add(start);
	        start.check = true; boolean ch = true;
	        while(!queue.isEmpty()) {
	        	Ticket t = queue.poll();
	        	if(t.start.equals("ICN") && ch) {
	        		answerList.add(t.start);
	        		answerList.add(t.end);
	        		ch = false;
	        	}else answerList.add(t.end);
	        	
	        	for(Ticket tc : t.link) {
	        		if(!tc.check && t.end.equals(tc.start)) {
	        			tc.check = true;
	        			queue.add(tc);
	        		}
	        	}
	        }
	        answer = new String[answerList.size()];
	        for(int i = 0; i < answerList.size(); i++) answer[i] =answerList.get(i);
	        return answer;
	    }
	    class Ticket implements Comparable<Ticket>{
	    	String start;
	    	String end;
	    	boolean check = false;
	    	LinkedList<Ticket> link = new LinkedList<Ticket>();
	    	public Ticket(String start, String end) {
				this.start = start; this.end = end;
			}
			@Override
			public int compareTo(Ticket o) {
				return end.compareTo(o.end);
			}
	    }
	}
}
