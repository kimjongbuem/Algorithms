
import java.util.HashMap;
import java.util.Scanner;

public class Q10816 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		int r = sc.nextInt();
		for(int i = 0; i < r;i++) {
			int n = sc.nextInt();
			if(map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else map.put(n, 1);
		}
		r = sc.nextInt();
		for(int i = 0; i < r - 1; i++) {
			int n = sc.nextInt();
			if(map.get(n) == null) System.out.print("0 ");
			else System.out.print(map.get(n)+" ");
		}
		int n = sc.nextInt();
		System.out.print(map.get(n));
	}

}
