import java.util.Scanner;

public class Q1051 {
	static int[] data; static int n, m; static char[][]ch; static int len = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로
		m = sc.nextInt(); // 가로
		data = new int[n];
		ch = new char[n][m];
		for(int i = 0; i < n; i++) data[i] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			 ch[i] = String.valueOf(data[i]).toCharArray();
		}
			for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < m - 1; j++) {
				dfs(j, i, 0);
			}
		}
		System.out.println(len * len);
	}
	public static void dfs(int x, int y, int l) {
		if(l == 0) {
			dfs(x, y , l + 1); return;
		}
		if(x + l >= m|| y + l >= n) return;
		
		if(ch[y][x] == ch[y + l][x] && ch[y + l][x + l] == ch[y][x + l]&& ch[y + l][x] == ch[y + l][x + l]
				) {
			len = len > l + 1 ? len : l + 1;
			dfs(x, y , l + 1);
		}else dfs(x, y , l + 1);
	}
}
