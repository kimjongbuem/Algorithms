import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BestAlbum {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};	int[] plays = {500, 600, 150, 800, 2500};
		int[] answer = new BestAlbum().new Solution().solution(genres, plays);
		for(int i : answer) {
			System.out.print(i+" ");
		}
	}
	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	        int[] answer = {};
	        Set<String> genre_Set = new HashSet<String>();
	        List<PlayList> playList = new LinkedList<PlayList>();
	        for(int i = 0; i < plays.length;i++) {
	        	if(!genre_Set.contains(genres[i])) {
	        		genre_Set.add(genres[i]);
	        		playList.add(new PlayList(i, genres[i], plays[i]));
	        	}
	        	
	        	for(int p = 0; p < playList.size(); p++) {
	        		if(genres[i].equals(playList.get(p).Get_genre_name())) {
	        			playList.get(p).Add(i, plays[i]);
	        			break;
	        		}
	        	}
	        }
	        Collections.sort(playList); int idx = 0; List<Integer> answerList = new LinkedList<Integer>();
	        while(!genre_Set.isEmpty()) {
	        	answerList.addAll(playList.get(idx).Return_BestMusicIndex());
	        	genre_Set.remove(playList.get(idx++).Get_genre_name());
	        }
	        answer = answerList.stream().mapToInt(i -> i).toArray();
	        for(int i : answer) {
				System.out.print(i+" ");
			}
	        return answer;
	    }
	
	    
	    class PlayList implements Comparable<PlayList>{
			private String genre_name;
			private List<PlayAMountAndIndexInfo> playAmount;
			int max;
			public PlayList(int index , String genre_name, int amt) {
				this.genre_name = genre_name;
				max = amt;
				playAmount = new LinkedList<PlayAMountAndIndexInfo>();
				playAmount.add(new PlayAMountAndIndexInfo(index, amt));
			}
			int Get_MaxValue() {return max;}
			
			void Add(int idx, int amt){
				max = max > amt ? max :amt;
				playAmount.add(new PlayAMountAndIndexInfo(idx, amt));
			}
			List<Integer> Return_BestMusicIndex(){
				playAmount.sort(Comparator.reverseOrder());
				List<Integer> return_Index_List = new LinkedList<Integer>();
				
				for(int i = 0; i < playAmount.size(); i++) { // 2°³¹ÝÈ¯
					if(i == 2) break; 
					return_Index_List.add(playAmount.get(i).GetIndex());
				}
				
				return return_Index_List;
			}
			String Get_genre_name() {
				return genre_name;
			}
			@Override
			public int compareTo(PlayList o) {
				return o.max - max;
			}
		    class PlayAMountAndIndexInfo implements Comparable<PlayAMountAndIndexInfo>{
		    	private int index ;
		    	private int amount;
		    	public PlayAMountAndIndexInfo(int idx, int amt) {
					index = idx; amount= amt;
				}
		    	public int GetIndex() {
		    		return index;
		    	}
		    	public int GetPlayAmt() {
		    		return amount;
		    	}
				@Override
				public int compareTo(PlayAMountAndIndexInfo o) {
					if(amount == o.amount) {
						return o.index - index;
					}
					else {
						return amount - o.amount;
					}
				}
		    }
		}
	}
	
}
