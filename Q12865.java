import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Q12865 {
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int K = sc.nextInt();
		int[][] dp = new int[n + 1][K + 1]; 
		int w[] = new int[n + 1]; int v[] = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			w[i] = sc.nextInt(); v[i] = sc.nextInt();
		} sc.close();
		
		for(int i = 1; i <= n; i++) {
			for(int k = 1; k <= K; k++) {
				dp[i][k] = dp[i - 1][k];
				if(k - w[i] >= 0) {
					dp[i][k] = dp[i][k]> dp[i - 1][k - w[i]] + v[i] ? dp[i][k] : dp[i - 1][k - w[i]] + v[i];
				}
			}
		}
		System.out.println(dp[n][K]);
		
//		LinkedList<Stuff> stuffs = new LinkedList<Stuff>();
//		for(int i = 0; i < n; i++) stuffs.add(new Stuff(sc.nextInt(), sc.nextInt()));
//		stuffs.sort(new Comparator<Stuff>() {
//			@Override
//			public int compare(Stuff o1, Stuff o2) {
//				return o2.w - o1.w;
//			}
//		});
//		sc.close();
//		for(int i = 1; i <= n; i++) {
//			Stuff s = stuffs.get(i - 1); // 넣을 아이;
//			for(int k = 0; k <= K; k++) {
//				if(k == 0) dp[i][k] = 0;
//				else if(s.w == k) dp[i][k] = s.v;
//				else if(dp[i - 1][k] != 0 && s.w + k <= K) dp[i][k] = dp[i - 1][k] + s.v;
//				else dp[i][k] = dp[i - 1][k] > dp[i][k - 1]? dp[i - 1][k] : dp[i][k - 1];
//			}
//		}
//		System.out.println(dp[n][K]);
	}
//	static class Stuff {
//		int v;
//		int w;
//		public Stuff(int w, int v){
//			this.v = v; this.w = w;
//		}
//	}
}	

