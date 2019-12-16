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
//			for(int i = 0; i < n;i++) {
//				map[i] = sc.next(); 
//			}
//			
			
			
			System.out.println(new Marble_SAMSUNG1().MarbleQuestion(n - 1, m - 1, map));
	}
	public int MarbleQuestion(int n, int m, String[] map) {
		
		int answer = 0;
		boolean[][] bool = new boolean[n][m];
		char[][] ch = new char[n][m];
		boolean[] direction = new boolean[4]; // 상 하 좌 우 체크
		boolean goal = false; boolean first = false;
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
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_yPos; temp > 0;temp--) {
								if(ch[temp - 1][r_xPos] == '#') break;
								else if(ch[temp - 1][r_xPos] == '.') {
									bool[temp - 1][r_xPos] = true;
									ch[temp - 1][r_xPos] = 'R';
									ch[temp][r_xPos] = '.';
								}
								else if(ch[temp - 1][r_xPos] == 'O') {
									goal = true;
									ch[temp][r_xPos] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_yPos; temp > 0;temp--) { // 블루이동
								if(ch[temp - 1][b_xPos] == '#' || ch[temp - 1][b_xPos] == 'R') break;
								else if(ch[temp - 1][b_xPos] == '.') {
									bool[temp - 1][b_xPos] = true;
									ch[temp - 1][b_xPos] = 'B';
									ch[temp][b_xPos] = '.';
								}
								else if(ch[temp - 1][r_xPos] == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
							
						}else { // 블루 먼저 시작
							for(temp = b_yPos; temp > 0;temp--) {
								if(ch[temp - 1][b_xPos] == '#') break;
								else if(ch[temp - 1][b_xPos] == '.') {
									bool[temp - 1][b_xPos] = true;
									ch[temp - 1][b_xPos] = 'B';
									ch[temp][b_xPos] = '.';
								}
								else if(ch[temp - 1][b_xPos] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_yPos; temp > 0;temp--) { // 레드이동
								if(ch[temp - 1][r_xPos] == '#' || ch[temp - 1][r_xPos] == 'B') break;
								else if(ch[temp - 1][r_xPos] == '.') {
									bool[temp - 1][r_xPos] = true;
									ch[temp - 1][r_xPos] = 'R';
									ch[temp][r_xPos] = '.';
								}
								else if(ch[temp - 1][r_xPos] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_yPos; temp > 0;temp--) { // 레드이동
							if(ch[temp - 1][r_xPos] == '#') break;
							else if(ch[temp - 1][r_xPos] == '.') {
								bool[temp - 1][r_xPos] = true;
								ch[temp - 1][r_xPos] = 'R';
								ch[temp][r_xPos] = '.';
							}
							else if(ch[temp - 1][r_xPos] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
						for(temp = b_yPos; temp > 0;temp--) { // 블루이동
							if(goal) break;
							if(ch[temp - 1][b_xPos] == '#') break;
							else if(ch[temp - 1][b_xPos] == '.') {
								bool[temp - 1][b_xPos] = true;
								ch[temp - 1][b_xPos] = 'B';
								ch[temp][b_xPos] = '.';
							}
							else if(ch[temp - 1][b_xPos] == 'O') {
								return -1;
							}
						} // 블루 이동끝 
					}
				}
				else if(direction[1]) { //하
					if(r_xPos == b_xPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_yPos > b_yPos) isStartRed = true;
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_yPos; temp < n;temp++) {
								if(ch[temp + 1][r_xPos] == '#') break;
								else if(ch[temp + 1][r_xPos] == '.') {
									bool[temp + 1][r_xPos] = true;
									ch[temp + 1][r_xPos] = 'R';
									ch[temp][r_xPos] = '.';
								}
								else if(ch[temp + 1][r_xPos] == 'O') {
									goal = true;
									ch[temp][r_xPos] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_yPos; temp < n;temp++) { // 블루이동
								if(ch[temp + 1][b_xPos] == '#' || ch[temp + 1][b_xPos] == 'R') break;
								else if(ch[temp + 1][b_xPos] == '.') {
									bool[temp + 1][b_xPos] = true;
									ch[temp + 1][b_xPos] = 'B';
									ch[temp][b_xPos] = '.';
								}
								else if(ch[temp + 1][r_xPos] == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
							
						}else { // 블루 먼저 시작
							for(temp = b_yPos; temp < n;temp++) {
								if(ch[temp + 1][b_xPos] == '#') break;
								else if(ch[temp + 1][b_xPos] == '.') {
									bool[temp + 1][b_xPos] = true;
									ch[temp + 1][b_xPos] = 'B';
									ch[temp][b_xPos] = '.';
								}
								else if(ch[temp + 1][b_xPos] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_yPos; temp < n;temp++) { // 레드이동
								if(ch[temp + 1][r_xPos] == '#' || ch[temp + 1][r_xPos] == 'B') break;
								else if(ch[temp + 1][r_xPos] == '.') {
									bool[temp + 1][r_xPos] = true;
									ch[temp + 1][r_xPos] = 'R';
									ch[temp][r_xPos] = '.';
								}
								else if(ch[temp + 1][r_xPos] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_yPos; temp < n;temp++) { // 레드이동
							if(ch[temp + 1][r_xPos] == '#') break;
							else if(ch[temp + 1][r_xPos] == '.') {
								bool[temp + 1][r_xPos] = true;
								ch[temp + 1][r_xPos] = 'R';
								ch[temp][r_xPos] = '.';
							}
							else if(ch[temp + 1][r_xPos] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
						for(temp = b_yPos; temp < n;temp++) { // 블루이동
							if(goal) break;
							if(ch[temp + 1][b_xPos] == '#') break;
							else if(ch[temp + 1][b_xPos] == '.') {
								bool[temp + 1][b_xPos] = true;
								ch[temp + 1][b_xPos] = 'B';
								ch[temp][b_xPos] = '.';
							}
							else if(ch[temp + 1][b_xPos] == 'O') {
								return -1;
							}
						} // 블루 이동끝 
					}
				}
				else if(direction[2]) { // 좌
					if(r_yPos == b_yPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_xPos < b_xPos) isStartRed = true;
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_xPos; temp > 0;temp--) {
								if(ch[r_yPos][temp - 1] == '#') break;
								else if(ch[r_yPos][temp - 1] == '.') {
									bool[r_yPos][temp - 1] = true;
									ch[r_yPos][temp - 1] = 'R';
									ch[r_yPos][temp] = '.';
								}
								else if(ch[r_yPos][temp - 1] == 'O') {
									goal = true;
									ch[r_yPos][temp] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_xPos; temp > 0;temp--) { // 블루이동
								if(ch[b_yPos][temp - 1] == '#' || ch[b_yPos][temp - 1] == 'R') break;
								else if(ch[b_yPos][temp - 1]  == '.') {
									bool[b_yPos][temp - 1] = true;
									ch[b_yPos][temp - 1]  = 'B';
									ch[b_yPos][temp]  = '.';
								}
								else if(ch[b_yPos][temp - 1]  == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
						}else { // 블루 먼저 시작
							for(temp = b_xPos; temp > 0;temp--) {
								if(ch[b_yPos][temp - 1] == '#') break;
								else if(ch[b_yPos][temp - 1] == '.') {
									bool[b_yPos][temp - 1] = true;
									ch[b_yPos][temp - 1]  = 'B';
									ch[b_yPos][temp]  = '.';
								}
								else if(ch[b_yPos][temp - 1] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_xPos; temp > 0;temp--) { // 레드이동
								if(ch[r_yPos][temp - 1]  == '#' || ch[r_yPos][temp - 1]  == 'B') break;
								else if(ch[r_yPos][temp - 1]  == '.') {
									bool[r_yPos][temp - 1] = true;
									ch[r_yPos][temp - 1]  = 'R';
									ch[r_yPos][temp]  = '.';
								}
								else if(ch[r_yPos][temp - 1] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_xPos; temp > 0;temp--) { // 레드이동
							if(ch[r_yPos][temp - 1]  == '#') break;
							else if(ch[r_yPos][temp - 1]  == '.') {
								bool[r_yPos][temp - 1] = true;
								ch[r_yPos][temp - 1]  = 'R';
								ch[r_yPos][temp] = '.';
							}
							else if(ch[r_yPos][temp - 1] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
						for(temp = b_xPos; temp > 0;temp--) { // 블루이동
							if(goal) break;
							if(ch[b_yPos][temp - 1]  == '#') break;
							else if(ch[b_yPos][temp - 1]  == '.') {
								bool[b_yPos][temp - 1] = true;
								ch[b_yPos][temp - 1]  = 'B';
								ch[b_yPos][temp - 1]  = '.';
							}
							else if(ch[b_yPos][temp - 1]  == 'O') {
								return -1;
							}
						} // 블루 이동끝 
					}
				}
				else if(direction[3]) { //우
					if(r_yPos == b_yPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_xPos > b_xPos) isStartRed = true;
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_xPos; temp < m; temp++) {
								if(ch[r_yPos][temp + 1] == '#') break;
								else if(ch[r_yPos][temp + 1] == '.') {
									bool[r_yPos][temp + 1] = true;
									ch[r_yPos][temp + 1] = 'R';
									ch[r_yPos][temp] = '.';
								}
								else if(ch[r_yPos][temp + 1] == 'O') {
									goal = true;
									ch[r_yPos][temp] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_xPos; temp < m;temp++) { // 블루이동
								if(ch[b_yPos][temp + 1] == '#' || ch[b_yPos][temp - 1] == 'R') break;
								else if(ch[b_yPos][temp + 1]  == '.') {
									bool[b_yPos][temp + 1] = true;
									ch[b_yPos][temp + 1]  = 'B';
									ch[b_yPos][temp]  = '.';
								}
								else if(ch[b_yPos][temp + 1]  == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
						}else { // 블루 먼저 시작
							for(temp = b_xPos; temp < m;temp++) {
								if(ch[b_yPos][temp + 1] == '#') break;
								else if(ch[b_yPos][temp + 1] == '.') {
									bool[b_yPos][temp + 1] = true;
									ch[b_yPos][temp + 1]  = 'B';
									ch[b_yPos][temp]  = '.';
								}
								else if(ch[b_yPos][temp + 1] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_xPos; temp < m;temp++) { // 레드이동
								if(ch[r_yPos][temp + 1]  == '#' || ch[r_yPos][temp + 1]  == 'B') break;
								else if(ch[r_yPos][temp + 1]  == '.') {
									bool[r_yPos][temp + 1] = true;
									ch[r_yPos][temp + 1]  = 'R';
									ch[r_yPos][temp]  = '.';
								}
								else if(ch[r_yPos][temp + 1] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_xPos; temp < m;temp++) { // 레드이동
							if(ch[r_yPos][temp + 1]  == '#') break;
							else if(ch[r_yPos][temp + 1]  == '.') {
								bool[r_yPos][temp + 1] = true;
								ch[r_yPos][temp + 1]  = 'R';
								ch[r_yPos][temp] = '.';
							}
							else if(ch[r_yPos][temp + 1] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
						for(temp = b_xPos; temp < m;temp++) { // 블루이동
							if(goal) break;
							if(ch[b_yPos][temp + 1]  == '#') break;
							else if(ch[b_yPos][temp + 1]  == '.') {
								bool[b_yPos][temp + 1] = true;
								ch[b_yPos][temp + 1]  = 'B';
								ch[b_yPos][temp + 1]  = '.';
							}
							else if(ch[b_yPos][temp + 1]  == 'O') {
								return -1;
							}
						} // 블루 이동끝 
					}
				}
				
			}else { // val이 2개 이상일 때... ㅠㅠㅠㅠㅠ
				answer++;
				first = true;
				if(direction[0]) { //상
					char[][] tempMap = ch;
					if(r_xPos == b_xPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_yPos < b_yPos) isStartRed = true;
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_yPos; temp > 0;temp--) {
								if(tempMap[temp - 1][r_xPos] == '#') break;
								else if(tempMap[temp - 1][r_xPos] == '.') {
									tempMap[temp - 1][r_xPos] = 'R';
									tempMap[temp][r_xPos] = '.';
								}
								else if(ch[temp - 1][r_xPos] == 'O') {
									goal = true;
									tempMap[temp][r_xPos] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_yPos; temp > 0;temp--) { // 블루이동
								if(tempMap[temp - 1][b_xPos] == '#' || tempMap[temp - 1][b_xPos] == 'R') break;
								else if(tempMap[temp - 1][b_xPos] == '.') {
									tempMap[temp - 1][b_xPos] = 'B';
									tempMap[temp][b_xPos] = '.';
								}
								else if(tempMap[temp - 1][r_xPos] == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
							
						}else { // 블루 먼저 시작
							for(temp = b_yPos; temp > 0;temp--) {
								if(tempMap[temp - 1][b_xPos] == '#') break;
								else if(tempMap[temp - 1][b_xPos] == '.') {
									tempMap[temp - 1][b_xPos] = 'B';
									tempMap[temp][b_xPos] = '.';
								}
								else if(tempMap[temp - 1][b_xPos] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_yPos; temp > 0;temp--) { // 레드이동
								if(tempMap[temp - 1][r_xPos] == '#' || tempMap[temp - 1][r_xPos] == 'B') break;
								else if(tempMap[temp - 1][r_xPos] == '.') {
									tempMap[temp - 1][r_xPos] = 'R';
									tempMap[temp][r_xPos] = '.';
								}
								else if(ch[temp - 1][r_xPos] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_yPos; temp > 0;temp--) { // 레드이동
							if(tempMap[temp - 1][r_xPos] == '#') break;
							else if(tempMap[temp - 1][r_xPos] == '.') {
								tempMap[temp - 1][r_xPos] = 'R';
								tempMap[temp][r_xPos] = '.';
							}
							else if(tempMap[temp - 1][r_xPos] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
					}
				}
				if(direction[1] && !goal) { //하
					char[][] tempMap = ch;
					if(r_xPos == b_xPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_yPos > b_yPos) isStartRed = true;
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_yPos; temp < n;temp++) {
								if(tempMap[temp + 1][r_xPos] == '#') break;
								else if(tempMap[temp + 1][r_xPos] == '.') {
									tempMap[temp + 1][r_xPos] = 'R';
									tempMap[temp][r_xPos] = '.';
								}
								else if(tempMap[temp + 1][r_xPos] == 'O') {
									goal = true;
									tempMap[temp][r_xPos] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_yPos; temp < n;temp++) { // 블루이동
								if(tempMap[temp + 1][b_xPos] == '#' || tempMap[temp + 1][b_xPos] == 'R') break;
								else if(tempMap[temp + 1][b_xPos] == '.') {
									tempMap[temp + 1][b_xPos] = 'B';
									tempMap[temp][b_xPos] = '.';
								}
								else if(tempMap[temp + 1][r_xPos] == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
							
						}else { // 블루 먼저 시작
							for(temp = b_yPos; temp < n;temp++) {
								if(tempMap[temp + 1][b_xPos] == '#') break;
								else if(tempMap[temp + 1][b_xPos] == '.') {
									tempMap[temp + 1][b_xPos] = 'B';
									tempMap[temp][b_xPos] = '.';
								}
								else if(tempMap[temp + 1][b_xPos] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_yPos; temp < n;temp++) { // 레드이동
								if(tempMap[temp + 1][r_xPos] == '#' || tempMap[temp + 1][r_xPos] == 'B') break;
								else if(tempMap[temp + 1][r_xPos] == '.') {
									tempMap[temp + 1][r_xPos] = 'R';
									tempMap[temp][r_xPos] = '.';
								}
								else if(tempMap[temp + 1][r_xPos] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_yPos; temp < n;temp++) { // 레드이동
							if(tempMap[temp + 1][r_xPos] == '#') break;
							else if(tempMap[temp + 1][r_xPos] == '.') {
								tempMap[temp + 1][r_xPos] = 'R';
								tempMap[temp][r_xPos] = '.';
							}
							else if(ch[temp + 1][r_xPos] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
					}
				}
				if(direction[2] && !goal) { // 좌
					char[][]tempMap = ch;
					if(r_yPos == b_yPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_xPos < b_xPos) isStartRed = true;
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_xPos; temp > 0;temp--) {
								if(tempMap[r_yPos][temp - 1] == '#') break;
								else if(tempMap[r_yPos][temp - 1] == '.') {
									tempMap[r_yPos][temp - 1] = 'R';
									tempMap[r_yPos][temp] = '.';
								}
								else if(tempMap[r_yPos][temp - 1] == 'O') {
									goal = true;
									tempMap[r_yPos][temp] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_xPos; temp > 0;temp--) { // 블루이동
								if(tempMap[b_yPos][temp - 1] == '#' || tempMap[b_yPos][temp - 1] == 'R') break;
								else if(tempMap[b_yPos][temp - 1]  == '.') {
									tempMap[b_yPos][temp - 1]  = 'B';
									tempMap[b_yPos][temp]  = '.';
								}
								else if(tempMap[b_yPos][temp - 1]  == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
						}else { // 블루 먼저 시작
							for(temp = b_xPos; temp > 0;temp--) {
								if(tempMap[b_yPos][temp - 1] == '#') break;
								else if(ch[b_yPos][temp - 1] == '.') {
									bool[b_yPos][temp - 1] = true;
									tempMap[b_yPos][temp - 1]  = 'B';
									tempMap[b_yPos][temp]  = '.';
								}
								else if(ch[b_yPos][temp - 1] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_xPos; temp > 0;temp--) { // 레드이동
								if(tempMap[r_yPos][temp - 1]  == '#' || tempMap[r_yPos][temp - 1]  == 'B') break;
								else if(ch[r_yPos][temp - 1]  == '.') {
									tempMap[r_yPos][temp - 1]  = 'R';
									tempMap[r_yPos][temp]  = '.';
								}
								else if(tempMap[r_yPos][temp - 1] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_xPos; temp > 0;temp--) { // 레드이동
							if(ch[r_yPos][temp - 1]  == '#') break;
							else if(ch[r_yPos][temp - 1]  == '.') {
								bool[r_yPos][temp - 1] = true;
								ch[r_yPos][temp - 1]  = 'R';
								ch[r_yPos][temp] = '.';
							}
							else if(ch[r_yPos][temp - 1] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
						for(temp = b_xPos; temp > 0;temp--) { // 블루이동
							if(goal) break;
							if(ch[b_yPos][temp - 1]  == '#') break;
							else if(ch[b_yPos][temp - 1]  == '.') {
								bool[b_yPos][temp - 1] = true;
								ch[b_yPos][temp - 1]  = 'B';
								ch[b_yPos][temp - 1]  = '.';
							}
							else if(ch[b_yPos][temp - 1]  == 'O') {
								return -1;
							}
						} // 블루 이동끝 
					}
				}
				if(direction[3] && !goal) { //우
					char[][]tempMap = ch;
					if(r_yPos == b_yPos) { //구슬과 구슬이 같은 라인선상에 있을 때...
						boolean isStartRed = false; //먼저 레드가 움직여야 된다는 플레그!!
						if(r_xPos > b_xPos) isStartRed = true;
						int temp;
						if(isStartRed) { // 레드 먼저 시작
							for(temp = r_xPos; temp < m; temp++) {
								if(tempMap[r_yPos][temp + 1] == '#') break;
								else if(tempMap[r_yPos][temp + 1] == '.') {
									tempMap[r_yPos][temp + 1] = 'R';
									tempMap[r_yPos][temp] = '.';
								}
								else if(tempMap[r_yPos][temp + 1] == 'O') {
									goal = true;
									tempMap[r_yPos][temp] = '.';
								}
							} // 레드 이동끝 
							for(temp = b_xPos; temp < m;temp++) { // 블루이동
								if(tempMap[b_yPos][temp + 1] == '#' || tempMap[b_yPos][temp - 1] == 'R') break;
								else if(tempMap[b_yPos][temp + 1]  == '.') {
									tempMap[b_yPos][temp + 1]  = 'B';
									tempMap[b_yPos][temp]  = '.';
								}
								else if(tempMap[b_yPos][temp + 1]  == 'O') {
									return -1; // 블루가 도착하면 안됨.....
								}
							} // 블루 이동끝 
						}else { // 블루 먼저 시작
							for(temp = b_xPos; temp < m;temp++) {
								if(tempMap[b_yPos][temp + 1] == '#') break;
								else if(tempMap[b_yPos][temp + 1] == '.') {
									tempMap[b_yPos][temp + 1]  = 'B';
									tempMap[b_yPos][temp]  = '.';
								}
								else if(tempMap[b_yPos][temp + 1] == 'O') {
									return -1;
								}
							} // 레드 이동끝 
							for(temp = r_xPos; temp < m;temp++) { // 레드이동
								if(tempMap[r_yPos][temp + 1]  == '#' || tempMap[r_yPos][temp + 1]  == 'B') break;
								else if(tempMap[r_yPos][temp + 1]  == '.') {
									tempMap[r_yPos][temp + 1]  = 'R';
									tempMap[r_yPos][temp]  = '.';
								}
								else if(tempMap[r_yPos][temp + 1] == 'O') {
									goal = true;
									break;
								}
							} // 레드 이동끝 
						}
						
					}
					else { // 구술끼리 라인선상이 아닐떄
						int temp;
						for(temp = r_xPos; temp < m;temp++) { // 레드이동
							if(tempMap[r_yPos][temp + 1]  == '#') break;
							else if(tempMap[r_yPos][temp + 1]  == '.') {
								tempMap[r_yPos][temp + 1]  = 'R';
								tempMap[r_yPos][temp] = '.';
							}
							else if(tempMap[r_yPos][temp + 1] == 'O') {
								goal = true;
								break;
							}
						} // 레드 이동끝 
					}
				}
			}
			if(goal) return answer;
			else if(first) break;
			
			for(int i = 0; i < 4;i++) direction[i] = false; // 방향플래그 초기화
		}
		
		return -1;
	}
	public int CheckRoad(boolean[][] bool, char[][] ch, boolean[] dir) {
		int val = 0;
		int rx = r_xPos; int ry = r_yPos;
		
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
