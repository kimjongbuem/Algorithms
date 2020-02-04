import java.util.Scanner;

public class Q1717 {
	static int p[] = new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		for(int i = 0;i <1000001;i++) p[i] = -1;
		for(int i = 0; i < m ; i++) {
			int select = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(select == 0) Union(a, b);
			else {
				String answer = Check(a, b);
				System.out.println(answer);
			}
		}
	}
	public static int find(int number) {
		if(p[number] < 0) return number;
		p[number] = find(p[number]);
		return p[number];
	}
	public static void Union(int a, int b) { 
		a = find(a);
		b = find(b);
		if(a == b) return;
		p[b] = a;
	}
	public static String Check(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return "YES";
		else return "NO";
	}
}
