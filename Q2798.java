import java.util.Scanner;

public class Q2798 {
	static int N[] = new int[101];
	static int M;
	static int RESULT = 0;
	static int count = 0;
	static int n;
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n = sc.nextInt();
		M = sc.nextInt();
		for(int i = 1;i<=n;i++) N[i] = sc.nextInt();
		Result(1);
		System.out.println(answer);
	}
	public static void Result(int idx) {
		if(answer == M) return;
		if(count >= 3 && RESULT > M) return;
		else if(count >= 3) answer = answer > RESULT ? answer : RESULT; 
		else {
			RESULT += N[idx]; count++;
			for(int i = idx + 1; i <= n;i++) Result(i);
			RESULT -= N[idx]; count--;
		}
	}
}
