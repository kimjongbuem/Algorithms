class Solution {
	private int height;
    public int solution(int[][] land, int height) {
        int answer = 0;
        this.height =height;
        int col = land.length;
        int row = land[0].length;
        int color = 0;
        int[][] ld = new int[col][row];

        
        
        return answer;
    }

    private void recursiveSameColor( int[][] ld , int color, int[][] land, int c, int r) {
    	if( c  + 1== land.length || r + 1 == land[0].length) return;
    	
    	boolean sameColor = false;
    	if(c- 1 >= 0 && Math.abs(land[c-1][r] - land[c][r]) <= height) {
    		sameColor= true;
    		ld[c][r] = ld[c-1][r];}
    	if(r- 1 >= 0 && Math.abs(land[c][r - 1] - land[c][r]) <= height) {
    		sameColor= true;
    		ld[c][r] = ld[c][r - 1];}
    	if(!sameColor) ld[c][r] = color;
    	
    		if(Math.abs(land[c+1][r] - land[c][r]) <= height) recursiveSameColor(ld, color, land, c + 1, r);
    		else recursiveSameColor(ld, color + 1, land, c, r);

    		if(Math.abs(land[c][r + 1] - land[c][r]) <= height) recursiveSameColor(cv, color, land, c + 1, r);
    		else recursiveSameColor(ld, color + 2, land, c, r);
    }
}
public class JoyStick1 {

	public static void main(String[] args) {
		int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
		System.out.println(new Solution().solution(land,3));
	}
}
