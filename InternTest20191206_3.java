
public class InternTest20191206_3 {
// {".o.", ".ox", "x.."};
	
	public static void main(String[] args) {
		String[] board = {".o.", ".ox", "x.."};// {"oo.", ".x.", "oox"};
		String v = new InternTest20191206_3().new Solution().solution(board);
		System.out.println(v);
	}
		class Solution {
			public String solution(String[] board) {
				String answer = "";
				char[][] charboard = new char[3][3];
				int count = 0; // ���� �������� Ȧ���� O ¦���� X ����
				//initialize 
				for(int i = 0; i < board.length; i++) {
					char[] data = board[i].toCharArray();
					for(int j = 0; j < data.length; j++) {
						if(data[j] != '.') count++;
						charboard[i][j] = data[j];
					}
				}
				
				if(count == 7) { // ������ �¸� ���  x�� o�� �ѹ���  ���λ�Ȳ
					if(charboard[1][1] == 'x') {
						if(charboard[0][1] == 'o' || charboard[2][1] == 'o'  || 
								charboard[1][0] == 'o'  || charboard[1][2] == 'o' ) return "X";
					}
					else return "D";
				}
				
				int OwinCount = 0; int XwinCount = 0;
				// 8 ������ ��� 3���� �ݺ������� �˾ƺ���.
				
				for(int x =0; x < 3; x++) { // x ���� y���̵� //
					int emptyCount= 0;
					int oCount = 0; int xCount = 0;
					for(int y =0; y < 3; y++) {
						if(charboard[y][x] == '.') emptyCount++;
						else if(charboard[y][x] == 'o') oCount++;
						else if(charboard[y][x] == 'x') xCount++;
					}
					if(emptyCount == 1 && oCount == 2) OwinCount++;
					else if(emptyCount == 1 && xCount == 2) XwinCount++; 
				}
				
				for(int y = 0; y < 3; y++) { // y���� x �� �̵�//
					int emptyCount= 0;
					int oCount = 0; int xCount = 0;
					for(int x = 0; x < 3; x++) {
						if(charboard[y][x] == '.') emptyCount++;
						else if(charboard[y][x] == 'o') oCount++;
						else if(charboard[y][x] == 'x') xCount++;
					}
					if(emptyCount == 1 && oCount == 2) OwinCount++;
					else if(emptyCount == 1 && xCount == 2) XwinCount++; 
				}
				for(int a = 0; a < 2; a++) { //�밢 //
					int emptyCount= 0;
					int oCount = 0; int xCount = 0;
					
					if(a == 0) { // �ε��� 0,0-> 1,1 -> 2,2 �밢
						for(int i = 0; i < 3; i++) {
							switch(charboard[i][i]){
							case '.':
								emptyCount++;
								break;
							case 'x':
								xCount++;
								break;
							case 'o':
								oCount++;
								break;
							}
						}
					}else { // �ε��� 0,2 -> 1,1 -> 2,0
						int x = 2;
						for(int i = 0; i < 3; i++) {
							switch(charboard[i][x]){
							case '.':
								emptyCount++;
								break;
							case 'x':
								xCount++;
								break;
							case 'o':
								oCount++;
								break;
							}
							x--;
						}
					}
					
					if(emptyCount == 1 && oCount == 2) OwinCount++;
					else if(emptyCount == 1 && xCount == 2) XwinCount++; 
				}
				count = count%2;
				
				if(count == 0) { //X ����
					if(XwinCount >= 1 ) return "X";
					else if(OwinCount >= 2) return "O";
					else return "D";
				}else {
					if(OwinCount >= 1 ) return "O";
					else if(XwinCount >= 2) return "X";
					else return "D";
				}
			}
		}

	}
