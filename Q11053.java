import java.util.Scanner;

public class Q11053 {
	static int arr[] = new int[1001]; static int[] dp = new int[1001]; 
	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int here = Integer.MIN_VALUE; dp[0] = here;
		for(int i = 1; i <= n; i++) {
			int d  = sc.nextInt();
			if(dp[i - 1] < d) {
				dp[i] = d; answer++;
			}else dp[i] = dp[i - 1];
		}
		System.out.println(answer);
	}

}
