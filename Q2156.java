import java.util.Scanner;

public class Q2156 {
	static int arr[]; static int max = 0;
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr= new int[10001];
		int dp[] = new int[10001];
		for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 2] + arr[i] > dp[i - 3] + arr[i] + arr[i - 1] ? dp[i - 2] + arr[i] : dp[i - 3] + arr[i] + arr[i - 1] ;
			dp[i] = dp[i] > dp[i - 1] ? dp[i] : dp[i - 1];
		}	
		System.out.println(dp[n]);
 	}
}
