import java.util.Scanner;

public class Q10844 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int mod = 1000000000;
		int dp[][] = new int[101][10]; 
		for(int i = 1; i<= 9;i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= n;i++) {
			for(int j = 0; j <= 9; j++) {
				dp[i][j] = 0;
				if(j - 1 >= 0) dp[i][j] += dp[i - 1][j - 1];
				if(j + 1 < 10) dp[i][j] += dp[i - 1][j + 1];
				dp[i][j] = dp[i][j] % mod;
			}
		}
		int ans = 0;
		for(int i = 0; i <= 9;i++) ans+=dp[n][i];
		System.out.println(ans); sc.close();
	}

}
