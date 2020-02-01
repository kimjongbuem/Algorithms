import java.util.Scanner;

public class Q1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int s = n;
		int cnt = 0; int val = 1;
		while(n > 0) {
			n -= val; val += 1;
			cnt++;
		}
		val = cnt - 1; n = 0;
		for(int i = val; i >= 1; i--) {
			n += i;
		}
		// v1 / v2
		if(cnt % 2 == 0) { //짝수 인 경우
			int v1 = 1; 
			int v2 = cnt;		
			for(int i = 1;i < s - n;i++) {
				v1 += 1; v2 -=1;
			}
			System.out.println(v1+"/"+v2);
		}else {
			int v1 = cnt; 
			int v2 = 1;		
			for(int i = 1;i < s - n;i++) {
				v1 -= 1; v2 +=1;
			}
			System.out.println(v1+"/"+v2);
		}
	}

}
