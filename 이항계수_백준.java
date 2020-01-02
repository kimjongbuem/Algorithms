import java.util.Scanner;

public class 이항계수_백준 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		//System.out.println(recursive(n, k));
		int[][] m = new int[n + 1][n + 1];
		for(int c = 1; c<=n ;c++) {
			for(int r = c; r >= 0 ; r--) {
				if(r == 1) m[c][r] = c;
				else if(r == 0 || r == c) m[c][r] = 1;
				else {
					m[c][r] = m[c - 1][r] + m[c - 1][r - 1] % 10007; 
				}
			}
		}
		System.out.println(m[n][k]);
	}
	public static int recursive(int n, int k) {
		if(n == k) return 1;
		if(k == 0) return 1;
		return recursive(n - 1, k) + recursive(n - 1, k - 1);
	}
}
