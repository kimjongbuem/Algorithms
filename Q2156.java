import java.util.LinkedList;
import java.util.Scanner;

public class Q2156 {
	static int grasps[]; static int max = 0;
	static LinkedList<Integer> list = new LinkedList<Integer>();
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		grasps = new int[n + 1];
		for(int i = 1; i <= n; i++) grasps[i] = sc.nextInt();
		re(0);
		System.out.println(max);
 	}
	public static void re(int curIndex) {
		if(curIndex >= grasps.length) {
			int v = list.stream().reduce(0, Integer::sum);
			max = max > v? max : v;
		}
		else {
			// ø¨º” 1¿‹ , 2¿‹ ∏‘æ˙¿ª∂ß....
			list.add(grasps[curIndex]);
			re(curIndex + 2);
			list.pop();
			
			list.add(grasps[curIndex]); 
			if(curIndex + 1 <= grasps.length - 1) list.add(grasps[curIndex + 1]); 
			re(curIndex + 2);
			list.pop(); if(curIndex + 1 <= grasps.length - 1) list.pop();
		}
	}
}
