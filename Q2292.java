import java.util.Scanner;

public class Q2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		int total = 1; int cnt = 1;
		while(true) {
			if(total >= value) break;
			total += cnt * 6; 
			cnt++;
		}
		System.out.println(cnt);
	}
}
