class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
    	   if(arr1[0].length!=arr2.length) {
   			throw new UnsupportedOperationException();
   		}
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++) {
        	for(int j= 0; j < answer[0].length; j++) {
            	int sum = 0;
            	for(int k= 0; k < arr1[0].length; k++) {
                	sum += arr1[i][k] * arr2[k][j];               	
                }
            	answer[i][j] = sum;
            }
        }
        return answer;
    }
}
public class MatrixMultiple {

	public static void main(String[] args) {
		int[][] arr1 =  {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 =  {{3,3}, {3,3}};
		System.out.println(new Solution().solution(arr1, arr2));

	}

}
