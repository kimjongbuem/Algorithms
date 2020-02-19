import java.util.Scanner;

public class Q3980 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int val = 1;
		for(int i = 1;i<n;i++) {
			val*=2;
		}
		System.out.println(val - 1);
		HanoiTower(n, 1, 2, 3);
	}
	public static void HanoiTower(int n,int from,int center,int to) {
		if(n == 1) {
			System.out.println(from+" "+to);
			return;
		}
		HanoiTower(n - 1, from, to, center);
		System.out.println(from+" "+to);
		HanoiTower(n - 1, center, from, to);
	}
}
