import java.util.Scanner;

public class MakeOne {
	static int answer = 0;
	static int min = 100000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		new MakeOne().solution(n);
		System.out.println(min);

	}
	public void solution(int n) {
		if(n == 1) {
			min = min < answer ? min : answer;
			return;
		}
		if(answer + 1 >= min) return;
		
		if(n % 2 == 0) {
			answer++;
			solution(n/2);
			answer--;
		}
		if(n % 3 == 0) {
			answer++;
			solution(n/3);
			answer--;
		}
		answer++;
		solution(n - 1);
		answer--;
	}
}
