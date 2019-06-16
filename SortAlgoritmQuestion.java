
public class SortAlgoritmQuestion {
	public static void main(String []arg) {
		Solutionss s = new Solutionss();
		int array[]= {1,5,2,6,3,7,4};
		int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
		int answer[] = s.solution(array, commands);
		for(int i = 0 ; i< 3; i++) {
			System.out.println(answer[i]);
		}
	}
	// Äü //
	public void qSort(int array[],int n, int answer[] ) {
		
	}
}
class Solutionss {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        int s = 0; int d = 0; int k = 0;
        // ¹öºí //
        for(int i = 0 ; i < commands.length;i++) {
        	int copyArray[]= {};
        	s = commands[i][0] - 1; d = commands[i][1] - 1; k = commands[i][2] - 1; // -1Àº ÀÎµ¦½º ¸ÂÃçÁÖ±âÀ§ÇÔ.
        	copyArray = new int[d-s+1];
        	for(int a = s, n = 0; a<=d;a++,n++) {
        		copyArray[n] = array[a];
        	}
        	for(int j = 0;j< d-s ;j++) {
        		for(int r = j+1 ;r<= d-s; r++) {
	        		if(copyArray[j] > copyArray[r]) {
	        			int tmp = copyArray[j];
	        			copyArray[j] = copyArray[r];
	        			copyArray[r] = tmp;
	        		}
	        	}
        	}
        	answer[i] = copyArray[k];
        }
        return answer;
    }
}