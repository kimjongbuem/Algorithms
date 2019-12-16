import java.util.Scanner;
public class Marble_SAMSUNG1 {
	int r_xPos, r_yPos;
	int b_xPos, b_yPos;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt(); // y
			int m = sc.nextInt(); // x
//			5 5
//			#####
//			#..B#
//			#.#.#
//			#RO.#
//			#####
			String[] map = new String[n];
			for(int i = 0; i < n;i++) {
				map[i] = sc.next(); 
			}
			
			
			
			System.out.println(new Marble_SAMSUNG1().MarbleQuestion(n, m, map));
	}
	public int MarbleQuestion(int n, int m, String[] map) {
		
		int answer = 0;
		boolean[][] bool = new boolean[n][m];
		char[][] ch = new char[n][m];
		boolean[] direction = new boolean[4]; // 상 하 좌 우 체크
		boolean goal = false;
		for(int i = 0; i < n ; i++) {
			ch[i] = map[i].toCharArray();
		}
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				if(ch[i][j] == '#' || ch[i][j] == 'R') bool[i][j] = true;
				if(ch[i][j] == 'R') {
					r_xPos = j; r_yPos = i;
				}
				else if(ch[i][j] == 'B') {	
					b_xPos = j;  b_yPos = i;
				}
			}
		}
		
		while(true) {
			int val = CheckRoad(bool, ch, direction);
			if(val == 0) break;
			else if(val == 1) {
				answer++;
				if(direction[0]) { //상
					if(r_xPos == b_xPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_yPos < b_yPos) isStartRed = true;
						
						if(isStartRed) { // 레드 먼저 시작
							int temp;
							for(temp = r_yPos; temp > 0;temp--) {
								if(ch[temp - 1][r_xPos] == '#') break;
								else if(ch[temp - 1][r_xPos] == '.') {
									ch[temp - 1][r_xPos] = 'R';
									ch[temp][r_xPos] = '.';
								}
								else if(ch[temp - 1][r_xPos] == 'O') {
									goal = true;
									ch[temp][r_xPos] = '.';
								}
							}
							
							
						}else { // 블루 먼저 시작
							
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						
					}
				}
				else if(direction[1]) { //하
					
				}
				else if(direction[2]) { // 좌
					
				}
				else if(direction[3]) { //우
					
				}
				for(int i = 0; i < 4;i++) direction[i] = false; // 방향플래그 초기화
			}else {
				
			}
		}
		
		return -1;
	}
	public int CheckRoad(boolean[][] bool, char[][] ch, boolean[] dir) {
		int val = 0;
		int rx = r_xPos; int ry = r_yPos;
		int bx = b_xPos; int by = b_yPos;
		
		// upper //
		if(ry == 0 || !bool[ry - 1][rx] && ch[ry - 1][rx] == '#') {}
		else if(!bool[ry - 1][rx] && ch[ry - 1][rx] == 'B') {
			if(ry - 2 < 0 || ch[ry - 2][rx] == '#') {}
			else {
				val++;
				dir[0] = true;
			}
		}
		
		//down//
		if(ry == ch.length - 1 || !bool[ry + 1][rx] && ch[ry + 1][rx] == '#') {}
		else if(!bool[ry + 1][rx] && ch[ry + 1][rx] == 'B') {
			if(ry + 2 > ch.length - 1 || ch[ry + 2][rx] == '#') {}
			else {
				val++;
				dir[1] = true;
			}
		}
		
		//left//
		if(rx == 0 || !bool[ry][rx - 1] && ch[ry][rx - 1] == '#') {}
		else if(!bool[ry][rx - 1] && ch[ry][rx - 1] == 'B') {
			if(rx - 2 < 0 || ch[ry][rx - 2] == '#') {}
			else {
				val++;
				dir[2] = true;
			}
		}
		
		//right
		if(rx == ch[0].length - 1 || !bool[ry][rx + 1] && ch[ry][rx + 1] == '#') {}
		else if(!bool[ry][rx + 1] && ch[ry][rx + 1] == 'B') {
			if(rx + 2 < ch[0].length - 1 || ch[ry][rx + 2] == '#') {}
			else {
				val++;
				dir[3] = true;
			}
		}
		return val;
	}
}
