import java.util.Scanner;

public class 좋은수열_백준 {
	static int min = Integer.MAX_VALUE;
	static boolean stop =false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(func(n));

	}
	static String func(int n) { 
		dfs("1", n);
		return String.valueOf(min);
	}
	
	static void dfs(String s, int n) {
		if(stop) return;
		
		if(s.length() == n) {
			int value = Integer.parseInt(s);
			min  = value < min ? value : min;
			stop = true;
		}
		for(int i = 1;i<=3;i++) {
			if(check(s+i)) {
				dfs(s+i, n);
			}
		}
	}
	static boolean check(String s) {
		int r = s.length()/2;
		for(int i = 1; i <= r;i++) {
			if(s.substring(s.length() - i, s.length()).equals(s.substring(s.length() -2*i ,s.length() - i)))
				return false;
		}
		
		return true;
	}
}
