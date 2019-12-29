import java.util.Scanner;

public class MakeOne {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[1000001];
		arr[1] = 0;
		for(int i = 2; i <=n;i++) {
			arr[i] = arr[i - 1] + 1;
			if(i % 2 ==0) arr[i] = arr[i] > arr[i / 2] + 1? arr[i/2] + 1 : arr[i];
			if(i % 3 ==0) arr[i] = arr[i] > arr[i / 3] + 1? arr[i/3] + 1 : arr[i];
		}
		System.out.println(arr[n]);

	}
//	public void solution(int n) {
//		if(n == 1) {
//			min = min < answer ? min : answer;
//			return;
//		}
//		if(answer + 1 >= min) return;
//		
//		if(n % 2 == 0) {
//			answer++;
//			solution(n/2);
//			answer--;
//		}
//		if(n % 3 == 0) {
//			answer++;
//			solution(n/3);
//			answer--;
//		}
//		answer++;
//		solution(n - 1);
//		answer--;
//	}
}
