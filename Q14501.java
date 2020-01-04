import java.util.Scanner;

public class Q14501 {
	static int ans = 0;
	static int N;
	static int[] t,p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		t = new int[N + 1];
		p = new int[N + 1];
		for(int i = 1; i <= N;i++)
		{
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		dfs(1, 0);
		System.out.println(ans);
		
		
	}
	public static void dfs(int day, int sum) {
		if(day == N + 1) {
			ans = ans > sum ? ans : sum;
			return;
		}
		// 상담을 안 하는경우 //
		dfs(day + 1, sum);
		if(day + t[day] <= N + 1) dfs(day + t[day], sum + p[day]);
	}
}

/*
//for(int i = 1; i <= N;i++) { // 첫시작.
//	int sum = 0;
//	int idx = i;
//	int curT = 0;
//	int nextT = t[i]; boolean flag = false;
//	for(int j = i; j <= N;j++) {
//		curT++;
//		if(flag) {
//			idx = j;
//			nextT = t[j];
//			flag = false;
//		}
//		if(nextT == curT) {
//			sum += p[idx];
//			curT = 0;
//			flag = true;
//		}
//	}
//	max = max > sum ? max : sum;
//}
//System.out.println(max);
 * */
 