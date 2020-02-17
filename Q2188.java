import java.util.Scanner;

public class Q2188 {
	static int m,n;
	static int cows[] = new int[201];
	static int shed[] = new int[201];
	static int info[][] =new int[201][201];
	static boolean visited[] = new boolean[201];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i = 1; i <= n;i++) {
			int s = sc.nextInt();
			for(int j = 1; j <= s; j++) {
				info[i][j] = sc.nextInt();
			}
		}
		System.out.println(bmatch());
	}
	static int bmatch() {
		int result = 0;
		for(int i = 1; i <= n; i++) {
			
		}
	}
	static boolean dfs(int here) {
		visited[here] = true;
		int k = 1;
		while(info[here][k] != 0) {
			if()
			k++;
		}
	}
}
