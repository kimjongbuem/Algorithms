import java.util.Scanner;

public class Q11053 {
	static int arr[] = new int[1001]; static int[] dp = new int[1001]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 0; int i;
		for(i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					if(min < dp[j]) min =dp[j];
				}
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[i - 1]);
	}

}
