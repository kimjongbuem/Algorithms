



class Charater{
	private int visitLength = 0;
	private int x = 5, y = 5;
	boolean[][] checked;
	public Charater() {
		checked = new boolean[11][11];
	}
	void Move(char m) {
		switch(m) {
		case 'U':
			if( y + 1 > 11 ) return;
			y += 1;	
			if(!checked[y - 1][x] || !checked[y][x]) {
				visitLength++;
				checked[y - 1][x] = true;
				checked[y][x] = true;
			} 
			
			break;
		case 'D':
			if( y - 1 < 0 ) return;
			y -= 1; 	
			if(!checked[y + 1][x] || !checked[y][x]) {
				visitLength++;
				checked[y + 1][x] = true;
				checked[y][x] = true;
			}
			break;
		case 'R':
			if( x + 1 > 11 ) return;
			x += 1; 	
			if(!checked[y][x - 1] || !checked[y][x]) {
				visitLength++;
				checked[y][x - 1] = true;
				checked[y][x] = true;
			} 
			break;
		case 'L':
			if( x - 1 < 0 ) return;
			x -= 1; 	
			if(!checked[y][x + 1] || !checked[y][x]) {
				visitLength++;
				checked[y][x + 1] = true;
				checked[y][x] = true;
			}
			break;
		}
	
	}
	int getVisitLength() {return visitLength;}
}
class Solution {
    public int solution(String dirs) {
        Charater character = new Charater();
        char[] ch = dirs.toCharArray();
        for(char c :ch) {
        	character.Move(c);
        }
        
        return character.getVisitLength();
    }
}

public class VisitLength {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("ULURRDLLU"));

	}

}
