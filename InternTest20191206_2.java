import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class InternTest20191206_2 {

	public static void main(String[] args) {
		int[][] quests = {{1,3},{1,4},{3,5},{5,4}};
		int[] answer =  new InternTest20191206_2().new Solution().solution(5, quests);
		for(int i = 0; i < answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}
	class Solution {
		  public int[] solution(int n, int[][] quests) {
		      int[] answer = new int[n];
		      // 스페셜 퀘스트 값 단일화
		      LinkedList<Integer> speicalValue = new LinkedList<Integer>();
		      for(int i = 0; i < quests.length; i++) {speicalValue.add(quests[i][1]);}
		      HashSet<Integer> sv = new HashSet<Integer>(speicalValue); speicalValue = new LinkedList<Integer>(sv);
		      LinkedList<Quest> questList = new LinkedList<Quest>(); sv.clear();
		     Collections.sort(speicalValue); // 정렬
		      // Quest 목록들 추가
		      
		      int k = 0;
		      for(int i = 1; i <= n; i++) {
		    	  if(i == speicalValue.get(k)) {
		    		  questList.add(new SpecialQuest(i));
		    		  k++; continue;
		    	  }
		    	  questList.add(new Quest(i));
		      }
		      // 스페셜값 해당 스페셜퀘스트에 목록을 추가.
		      
		      
		      for(int i = 0; i < quests.length; i++) {
		    	 questList.get(quests[i][1] - 1).GetRemainQuest().add(quests[i][0]);
		      }
		      // 
		      k = 0;
		      while(k <= quests.length) {
		    	  if(k == 4) {
		    		  System.out.println("");
		    	  }
		    	  
		    	  for(int i = 0; i < questList.size(); i++) {
		    		  if(questList.get(i).finish) continue;
		    		  else if(!questList.get(i).speical) {
		    			  answer[k] = i + 1;
		    			  questList.get(i).finish = true;
		    		  }else { // special Quest
		    			  LinkedList<Integer> remainList = questList.get(i).GetRemainQuest();
		    			  for(int q = 0; q < quests.length; q++) {
		    				  if(remainList.size() == 0) break;
		    				  for(int r = 0; r < remainList.size();r++) {
		    					  if(remainList.size() == 0) break;
		    					  if(quests[q][1] == i + 1) {
		    						  if(quests[q][0] == remainList.get(r) && questList.get(quests[q][0] - 1).finish) {
		    							  remainList.remove(r);
		    							  r--;
		    						  }
		    					  } 
		    				  }
		    			  }
		    			  questList.get(i).SetRemainQuest(remainList);
		    			  if(questList.get(i).GetRemainQuest().size() == 0) {
		    				  answer[k] = i + 1;
		    				  questList.get(i).finish = true;
		    			  }
		    		  }
		    		  if(questList.get(i).finish) k++;
		    	  }
		      }
		      return answer;
		  }
		  class Quest{
			  int v;
			  boolean speical;
			  boolean finish;
			  Quest(int v){
				  	this.v =v;
				  	speical = false;
				  	finish = false;
			  }
			  public boolean ReturnIsSpeical() {return false;}
			  public int GetValue() {return v;}
			  public LinkedList<Integer> GetRemainQuest(){
				  return null;
			  }
			  public void SetRemainQuest(LinkedList<Integer> list) {
				  
			  }
		}
		class SpecialQuest extends Quest{
			LinkedList<Integer> remain;
			SpecialQuest(int v){ 
				super(v);
				speical = true;
				remain = new LinkedList<Integer>();
			}
			@Override
			public boolean ReturnIsSpeical() {
				return true;
			}
			@Override
			public LinkedList<Integer> GetRemainQuest() {
				return remain;
			}
			@Override
			public void SetRemainQuest(LinkedList<Integer> list) {
					remain = list;
			}
		}
	}
}
