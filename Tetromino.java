import java.util.Stack;

public class Tetromino {
	static int max = -1;
	int idxX, idxY; int rotate;
	Stack<Integer> rotateStack = new Stack<Integer>();
	Stack<Boolean> stack = new Stack<Boolean>();
	static int num = 0;
	; // shape에 따른 boolean값 지정
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int m = 5;
		boolean[][]check = new boolean[n][m];
		int[][]values= {
				{1, 2, 3, 4, 5},
				{5, 4, 3, 2, 1},
				{2, 3, 4, 5, 6},
				{6, 5, 4, 3, 2},
				{1, 2, 1, 2, 1},
		};
		new Tetromino().dfs(values,check);
		System.out.println(max);
	}
	void dfs(int[][] values, boolean[][]check) {
		for(int i = 0; i < 5; i++) {
			num++; int[] idx = new int[2];
			if(Check_Move(i, check, values,idx)) {
				dfs(values,check);
				Reset2(check,i,idx);
			}
		}
	}void Reset2(boolean[][]check,int shape, int[] idx) {
		if(shape == 0) {
			check[idx[0]][idx[1]] = false;
			check[idx[0] + 1][idx[1] + 1] = false;
			check[idx[0]][idx[1]+ 1] = false;
			check[idx[0] + 1][idx[1]] = false;
		}else if(shape == 1) {
			if(stack.empty()) return;
			
			if(stack.pop()) {
				check[idx[0]][idx[1]] = false;
				check[idx[0]][idx[1] + 2] = false;
				check[idx[0]][idx[1] + 3] = false;
				check[idx[0]][idx[1] + 1] = false;
			}else {
				check[idx[0]][idx[1]] = false;
				check[idx[0] + 1][idx[1]] = false;
				check[idx[0] + 2][idx[1]] = false;
				check[idx[0] + 3][idx[1]] = false;
			}
		}else if(shape == 2) { if(stack.empty()) return;
			if(stack.pop()) {
				check[idx[0]][idx[1]] = false;
				check[idx[0]][idx[1] + 1] = false;
				check[idx[0] + 1][idx[1] + 1] = false;
				check[idx[0]+ 1][idx[1] + 2] = false;
			}else {
				check[idx[0]][idx[1]] = false;
				check[idx[0] + 2][idx[1] - 1] = false;
				check[idx[0] + 1][idx[1] - 1] = false;
				check[idx[0] + 1][idx[1]] = false;
			}
		}else if(shape == 3) { if(rotateStack.empty()) return;
			if(rotateStack.peek() == 0) {
				rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0] + 1][idx[1]] = false; 
				check[idx[0] + 2][idx[1]] = false; 
				check[idx[0]][idx[1] + 1] = false;
			}else if(rotateStack.peek() == 90) { rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0] + 1][idx[1]] = false; 
				check[idx[0] + 1][idx[1] + 1] = false; 
				check[idx[0] + 1][idx[1] + 2] = false;
			}else if(rotateStack.peek()== 180) { rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0] + 2][idx[1]- 1] = false; 
				check[idx[0] + 2][idx[1]] = false; 
				check[idx[0] + 1][idx[1]] = false;
			}else if(rotateStack.peek() == 270) { rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0]][idx[1] + 1] =false; 
				check[idx[0]][idx[1] + 2] = false; 
				check[idx[0] + 1][idx[1]+ 2] = false;
			}
		}else if(shape == 4) { if(rotateStack.empty()) return;
			if(rotateStack.peek() == 0) { rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0] + 1][idx[1] + 1] = false; 
				check[idx[0] ][idx[1] + 1] = false; 
				check[idx[0]][idx[1] + 2] = false;
			}else if(rotateStack.peek() == 90) { rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0] + 1][idx[1]] = false; 
				check[idx[0]+ 1][idx[1] + 1] = false; 
				check[idx[0] + 2][idx[1]] = false;
			}else if(rotateStack.peek() == 180) { rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0] + 1][idx[1] - 1] = false; 
				check[idx[0] + 1][idx[1] + 1] = false; 
				check[idx[0] + 1][idx[1]] = false;
			}else if(rotateStack.peek() == 270) { rotateStack.pop();
				check[idx[0]][idx[1]] = false; check[idx[0] + 1][idx[1]] =false; 
				check[idx[0] + 2][idx[1]] = false; 
				check[idx[0] + 1][idx[1] -1] = false;
			}
		}
	}
	void Reset(boolean[][]check,int shape, int[] idx) {
		if(shape == 0) {
			check[idxY][idxX] = false;
			check[idxY + 1][idxX + 1] = false;
			check[idxY][idxX + 1] = false;
			check[idxY + 1][idxX] = false;
		}else if(shape == 1) {
			if(stack.pop()) {
				check[idxY][idxX] = false;
				check[idxY][idxX + 2] = false;
				check[idxY][idxX + 3] = false;
				check[idxY][idxX + 1] = false;
			}else {
				check[idxY][idxX] = false;
				check[idxY + 1][idxX] = false;
				check[idxY + 2][idxX] = false;
				check[idxY + 3][idxX] = false;
			}
		}else if(shape == 2) {
			if(stack.pop()) {
				check[idxY][idxX] = false;
				check[idxY][idxX + 1] = false;
				check[idxY + 1][idxX + 1] = false;
				check[idxY + 1][idxX + 2] = false;
			}else {
				check[idxY][idxX] = false;
				check[idxY + 2][idxX - 1] = false;
				check[idxY + 1][idxX - 1] = false;
				check[idxY + 1][idxX] = false;
			}
		}else if(shape == 3) {
			if(rotate == 0) {
				check[idxY][idxX] = false; check[idxY + 1][idxX] = false; 
				check[idxY + 2][idxX] = false; 
				check[idxY][idxX + 1] = false;
			}else if(rotate == 90) {
				check[idxY][idxX] = false; check[idxY + 1][idxX] = false; 
				check[idxY + 1][idxX + 1] = false; 
				check[idxY + 1][idxX + 2] = false;
			}else if(rotate == 180) {
				check[idxY][idxX] = false; check[idxY + 2][idxX - 1] = false; 
				check[idxY + 2][idxX] = false; 
				check[idxY + 1][idxX] = false;
			}else if(rotate == 270) {
				check[idxY][idxX] = false; check[idxY][idxX + 1] =false; 
				check[idxY][idxX + 2] = false; 
				check[idxY + 1][idxX + 2] = false;
			}
		}else if(shape == 4) {
			if(rotate == 0) {
				check[idxY][idxX] = false; check[idxY + 1][idxX + 1] = false; 
				check[idxY ][idxX + 1] = false; 
				check[idxY][idxX + 2] = false;
			}else if(rotate == 90) {
				check[idxY][idxX] = false; check[idxY + 1][idxX] = false; 
				check[idxY + 1][idxX + 1] = false; 
				check[idxY + 2][idxX] = false;
			}else if(rotate == 180) {
				check[idxY][idxX] = false; check[idxY + 1][idxX - 1] = false; 
				check[idxY + 1][idxX + 1] = false; 
				check[idxY + 1][idxX] = false;
			}else if(rotate == 270) {
				check[idxY][idxX] = false; check[idxY + 1][idxX] =false; 
				check[idxY + 2][idxX] = false; 
				check[idxY + 1][idxX -1] = false;
			}
		}
	}
	boolean Check_Move(int shape ,boolean[][]check,int[][] values,int[] idx) {
		if(shape == 0) // O 
		{
			return O_Check(check,values,idx);
		}
		else if(shape == 1) { // I 
			return I_Check(check,values,idx);
		}else if(shape == 2) { // S
			return S_Check(check,values,idx);
		}else if(shape == 3) {
			return L_Check(check,values,idx);
		}else if(shape == 4) {
			return T_Check(check,values,idx);
		}
		
		
		return false;
	}
	
	boolean T_Check(boolean[][]check, int[][] values, int[]idx) {
		// 0
		for(int i = 0; i+1 < check.length;i++) {
			for(int j = 0; j+2 < check[0].length ; j++) {
				if(!check[i][j] && !check[i+1][j + 1] && !check[i][j+1] && !check[i][j + 2])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i+1][j + 1] = true; 
					check[i][j+1] = true; 
					check[i][j + 2] = true;
					rotateStack.add(0);
					int temp = values[i][j] + values[i + 1][j + 1] + values[i][j + 1] + values[i][j + 2];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		// 90
		for(int i = 0; i+2 < check.length;i++) {
			for(int j = 0; j+1 < check[0].length; j++) {
				if(!check[i][j] && !check[i+1][j] && !check[i + 1][j + 1] && !check[i + 2][j])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j] = true; 
					check[i + 1][j + 1] = true; 
					check[i + 2][j] = true;
					rotateStack.add(90);
					int temp = values[i][j] + values[i + 1][j + 1] + values[i + 2][j] + values[i + 1][j];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		// 180
		for(int i = 0; i + 1< check.length ;i++) {
			for(int j = 1; j+1 < check[0].length;j++) {
				if(!check[i][j] && !check[i + 1][j - 1] && !check[i + 1][j + 1] && !check[i + 1][j])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j - 1] = true; 
					check[i + 1][j + 1] = true; 
					check[i + 1][j] = true;
					rotateStack.add(180);
					int temp = values[i][j] + values[i + 1][j - 1] + values[i + 1][j + 1] + values[i + 1][j];
					max = max > temp? max : temp; 
				}
			}
		}
		// 270
		for(int i = 0; i + 2< check.length ;i++) {
			for(int j = 1; j < check[0].length;j++) {
				if(!check[i][j] && !check[i + 1][j] && !check[i + 2][j] && !check[i + 1][j - 1])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j] = true; 
					check[i + 2][j] = true; 
					check[i + 1][j - 1] = true;
					rotateStack.add(270);
					int temp = values[i][j] + values[i + 1][j] + values[i + 2][j] + values[i + 1][j - 1];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		return false;
	}
	
	boolean L_Check(boolean[][]check, int[][] values, int[] idx) {
		// 0
		for(int i = 0; i+2 < check.length;i++) {
			for(int j = 0; j < check[0].length - 1; j++) {
				if(!check[i][j] && !check[i+1][j] && !check[i + 2][j] && !check[i][j + 1])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j] = true; 
					check[i + 2][j] = true; 
					check[i][j + 1] = true;
					rotateStack.add(0);
					int temp = values[i][j] + values[i + 1][j] + values[i + 2][j] + values[i][j + 1];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		// 90
		for(int i = 0; i+1 < check.length;i++) {
			for(int j = 0; j+2 < check[0].length; j++) {
				if(!check[i][j] && !check[i+1][j] && !check[i + 1][j + 1] && !check[i + 1][j + 2])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j] = true; 
					check[i + 1][j + 1] = true; 
					check[i + 1][j + 2] = true;
					rotateStack.add(90);
					int temp = values[i][j] + values[i + 1][j + 1] + values[i + 1][j + 2] + values[i + 1][j];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		// 180
		for(int i = 0; (i + 2)< check.length ;i++) {
			for(int j = 1; j < check[0].length;j++) {
				if(!check[i][j] && !check[i + 2][j - 1] && !check[i + 2][j] && !check[i + 1][j])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 2][j - 1] = true; 
					check[i + 2][j] = true; 
					check[i + 1][j] = true;
					rotateStack.add(180);
					int temp = values[i][j] + values[i + 2][j - 1] + values[i + 2][j] + values[i + 1][j];
					max = max > temp? max : temp; 
				}
			}
		}
		// 270
		for(int i = 0; i + 1< check.length ;i++) {
			for(int j = 0; j+2 < check[0].length;j++) {
				if(!check[i][j] && !check[i][j + 1] && !check[i][j + 2] && !check[i + 1][j + 2])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i][j + 1] = true; 
					check[i][j + 2] = true; 
					check[i + 1][j + 2] = true;
					rotateStack.add(270);
					int temp = values[i][j] + values[i][j + 1] + values[i][j + 2] + values[i + 1][j + 2];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		return false;
	}
	
	boolean S_Check(boolean[][]check, int[][] values, int[] idx) {
		// 0
		for(int i = 0; i+2 < check.length;i++) {
			for(int j = 1; j < check[0].length; j++) {
				if(!check[i][j] && !check[i+1][j -1] && !check[i + 1][j] && !check[i + 2][j - 1])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j - 1] = true; 
					check[i + 1][j] = true; 
					check[i + 2][j - 1] = true;
					stack.push(false);
					int temp = values[i][j] + values[i + 1][j - 1] + values[i + 1][j] + values[i + 2][j - 1];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		// 90
		for(int i = 0; i + 1< check.length ;i++) {
			for(int j = 0; j+2 < check[0].length;j++) {
				if(!check[i][j] && !check[i][j + 1] && !check[i + 1][j + 1] && !check[i + 1][j + 2])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j + 1] = true; 
					check[i][j + 1] = true; 
					check[i + 1][j + 2] = true;
					stack.push(true);
					int temp = values[i][j] + values[i][j + 1] + values[i + 1][j + 2] + values[i + 1][j + 1];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		return false;
	}

	boolean I_Check(boolean[][]check, int[][] values,int[] idx) {
		// ㅡ
		for(int i = 0; i < check.length;i++) {
			for(int j = 0; j + 3 <= check[0].length - 1;j++) {
				if(!check[i][j] && !check[i][j + 1] && !check[i][j + 2] && !check[i][j + 3])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i][j + 2] = true; 
					check[i][j + 1] = true; 
					check[i][j + 3] = true;
					stack.push(true);
					int temp = values[i][j] + values[i][j + 1] + values[i][j + 2] + values[i][j + 3];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		// ㅣ
		for(int i = 0; i + 3<= check.length - 1;i++) {
			for(int j = 0; j < check[0].length;j++) {
				if(!check[i][j] && !check[i + 1][j] && !check[i + 2][j] && !check[i + 3][j])
				{
					idxX = j; idxY = i; idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i + 1][j] = true; 
					check[i + 2][j] = true; 
					check[i + 3][j] = true;
					stack.push(false);
					int temp = values[i][j] + values[i + 1][j] + values[i + 2][j] + values[i + 3][j];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		return false;
	}
	
	boolean O_Check(boolean[][]check, int[][] values,int[] idx) {
		for(int i = 0; i < check.length - 1;i++) {
			for(int j = 0; j < check[0].length - 1;j++) {
				if(!check[i][j] && !check[i][j + 1] && !check[i+ 1][j] && !check[i + 1][j + 1])
				{
					if(j == 4) {
						System.out.println();
					}
					idxX = j; idxY = i;
					idx[0] = i; idx[1] = j;
					check[i][j] = true; check[i][j + 1] = true; 
					check[i+ 1][j] = true; 
					check[i + 1][j + 1] = true;
					int temp = values[i][j] + values[i][j + 1] + values[i + 1][j + 1] + values[i + 1][j];
					max = max > temp? max : temp;
					return true;
				}
			}
		}
		return false;
	}

}
