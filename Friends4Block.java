enum Status {
	Not(0), Rion(1), Muji(2), Apeach(3), Frodo(4), Neo(5), Tube(6), Jeige(7), Corn(8),
	B(9),D(10),E(11);
	int value;

	private Status(int val) {
		value = val;
	}

	public int getValue() {
		return value;
	}
}
class Count{
	int count = 0;
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
}
class RowAndColAndDiagonalCount {
	private int rowCnt;
	private int colCnt;
	private int diagonalCnt;
	
	public void setDiagonalCnt(int diagonalCnt) {
		this.diagonalCnt = diagonalCnt;
	}
	
	public int getDiagonalCnt() {
		return diagonalCnt;
	}
	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public int getColCnt() {
		return colCnt;
	}

	public void setColCnt(int colCnt) {
		this.colCnt = colCnt;
	}

}

class Solution {

	private boolean deleteBlock(RowAndColAndDiagonalCount[][] rcMap, Status[][] enumMap, String[] board, Count cnt) {
		int cLength = rcMap.length;
		int rLength = rcMap[0].length;
		cnt.setCount(0);
		char[][] chArray = new char[cLength][rLength];
		for (int i = 0; i < cLength; i++) {
			
			chArray[i] = board[i].toCharArray();
			board[i] = "";
			for (int j = 0; j < rLength; j++) {
				switch (chArray[i][j]) {
				case 'D':
					enumMap[i][j] = Status.D;
					break;
				case 'E':
					enumMap[i][j] = Status.E;
					break;
				case 'B':
					enumMap[i][j] = Status.B;
					break;
				case 'C':
					enumMap[i][j] = Status.Corn;
					break;
				case 'R':
					enumMap[i][j] = Status.Rion;
					break;
				case 'F':
					enumMap[i][j] = Status.Frodo;
					break;
				case 'J':
					enumMap[i][j] = Status.Jeige;
					break;
				case 'T':
					enumMap[i][j] = Status.Tube;
					break;
				case 'N':
					enumMap[i][j] = Status.Neo;
					break;
				case 'A':
					enumMap[i][j] = Status.Apeach;
					break;
				case 'M':
					enumMap[i][j] = Status.Muji;
					break;
				case ' ':
					enumMap[i][j] = Status.Not;
					break;
				}
				// diagonal
				if (i - 1 < 0 || j - 1 < 0)
					rcMap[i][j].setDiagonalCnt(1);
				else if(enumMap[i][j] != Status.Not && enumMap[i][j] == enumMap[i - 1][j - 1])
					rcMap[i][j].setDiagonalCnt(rcMap[i - 1][j].getDiagonalCnt()+ 1);
				else
					rcMap[i][j].setDiagonalCnt(1);
				// col
				if (i - 1 < 0)
					rcMap[i][j].setColCnt(1);
				else if (enumMap[i][j] != Status.Not && enumMap[i][j] == enumMap[i - 1][j])
					rcMap[i][j].setColCnt(rcMap[i - 1][j].getColCnt() + 1);
				else
				rcMap[i][j].setColCnt(1);
				
				// row
				if (j - 1 < 0)
					rcMap[i][j].setRowCnt(1);
				else if (enumMap[i][j] != Status.Not && enumMap[i][j] == enumMap[i][j - 1])
					rcMap[i][j].setRowCnt(rcMap[i][j - 1].getRowCnt() + 1);
				else
					rcMap[i][j].setRowCnt(1);
			}

		}
		boolean isdelete = false;
		for (int i = 1; i < cLength; i++) {
			for (int j = 1; j < rLength; j++) {
				if (rcMap[i][j].getColCnt() >= 2 && rcMap[i][j].getRowCnt() >= 2 && rcMap[i][j].getDiagonalCnt() >= 2) { // ªË¡¶
					isdelete = true;
					rcMap[i][j].setColCnt(0);
					rcMap[i][j].setRowCnt(0);
					rcMap[i - 1][j].setColCnt(0);
					rcMap[i - 1][j].setRowCnt(0);
					rcMap[i][j - 1].setColCnt(0);
					rcMap[i][j - 1].setRowCnt(0);
					rcMap[i - 1][j - 1].setColCnt(0);
					rcMap[i - 1][j - 1].setRowCnt(0);
					enumMap[i][j] = Status.Not;
					enumMap[i - 1][j] = Status.Not;
					enumMap[i][j - 1] = Status.Not;
					enumMap[i - 1][j - 1] = Status.Not;
				}
			}
		}
		for (int i = 0; i < cLength; i++) {
			for (int j = 0; j < rLength; j++) {
				int status = enumMap[i][j].getValue();
				switch (status) {
				case 0:
					cnt.setCount(cnt.getCount() + 1);
					board[i] += ' ';
					break;
				case 1:
					board[i] += 'R';
					break;
				case 2:
					board[i] += 'M';
					break;
				case 3:
					board[i] += 'A';
					break;
				case 4:
					board[i] += 'F';
					break;
				case 5:
					board[i] += 'N';
					break;
				case 6:
					board[i] += 'T';
					break;
				case 7:
					board[i] += 'J';
					break;
				case 8:
					board[i] += 'C';
					break;
				case 9:
					board[i] += 'B';
					break;
				case 10:
					board[i] += 'D';
					break;
				case 11:
					board[i] += 'E';
					break;
				}
			}

		}
		print(board);
		return isdelete;

	}

	private void dropBlock(Status[][] map, String[] board) {
		int cLength = map.length;
		int rLength = map[0].length;
		int dropCount = 0;
		char[][] chArray = new char[cLength][rLength];
		for (int i = 0; i < cLength; i++) {
			chArray[i] = board[i].toCharArray();
			board[i] = "";
		}

		for (int r = 0; r < rLength; r++) {
			dropCount = 0;
			for (int c = cLength - 1; c >= 0; c--) {
				if (chArray[c][r] != ' ' && dropCount > 0) {
					dropLogic(chArray, c, r, dropCount);
					dropCount = 0;
				} 
				else if (chArray[c][r] != ' ') continue;
				else dropCount++;

			}
		}
		for (int i = 0; i < cLength; i++) {
			board[i] = new String(chArray[i]);
		}
		print(board);
	}
	
	private void dropLogic(char[][] cA, int c, int r, int cnt ) {
		for(int i = c; i >= 0; i--) {
			cA[i + cnt][r] = cA[i][r];
			cA[i][r]=' ';
		}
	}
	public int solution(int m, int n, String[] board) {
		Count cnt = new Count();
		RowAndColAndDiagonalCount[][] rcMap = new RowAndColAndDiagonalCount[m][n];
		Status[][] enumMap = new Status[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				rcMap[i][j] = new RowAndColAndDiagonalCount();
				//enumMap[i][j] = new Status();
			}
		}
		
		while (true) {
			print(board);
			if (!deleteBlock(rcMap, enumMap, board, cnt))
				break;
			dropBlock(enumMap, board);
		}
		print(board);
		return cnt.getCount();
	}

	private void print(String[] board) {
		for (int i = 0; i < board.length; i++)
			System.out.println(board[i]);
		System.out.println("");
		System.out.println("");
	}
	
}

public class Friends4Block {

	public static void main(String[] args) {
		//String[] s = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		String [] s= {"CCBDE","AAADE","AAABF","CCBBF"};
		System.out.println(new Solution().solution(s.length, s[0].toCharArray().length, s));
	}

}
