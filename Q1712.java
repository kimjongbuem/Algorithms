import java.util.Scanner;

public class Q1712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int answer = 0;
		sc.close();
		if(B < C) {
			System.out.println(A / (C - B) + 1);
		}else System.out.println(-1);
	}
}
