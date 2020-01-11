import java.util.Scanner;

public class Q2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(); sc.close(); int th = 0; int fi = w / 5; boolean check = false;
		while(fi >= 0) {
			if((w - fi * 5) % 3 == 0) {
				check = true;
				th = (w - fi * 5) / 3; break;
			}
			fi--;
		}
		System.out.println(check == true ? fi + th : -1);
	}
}
