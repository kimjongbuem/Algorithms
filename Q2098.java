import java.util.Scanner;

public class Q2098 {

	static int INF = 987654321;
	static int cost[][] = new int[16][1 << 16];
	static int dp[][] = new int[16][1 << 16];
	static int n;
	static int all;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); all = (1 << n) - 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		System.out.println(TSP(0,1));
	}
	public static int TSP(int here, int visited) {
		if(visited == (1 << n) - 1) {
			if(cost[here][0] == 0) return INF;
			else return cost[here][0];
		}
		int m = dp[here][visited];
		if(m != 0) return dp[here][visited];
		m = INF;
		for(int next = 0; next< n; next++) {
			if(cost[here][next] == 0 || (visited & (1 << next)) != 0) continue;
			int candidate = cost[here][next] + TSP(next, visited + (1 << next));
			m = m > candidate? candidate : m;
		}
		return m;
	}
}
