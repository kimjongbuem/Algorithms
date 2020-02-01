import java.util.Scanner;

public class Q1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int s = n;
		int cnt = 0; int val = 1;
		while(n > 0) {
			int beforeVal = val;
			n -= val; val += beforeVal;
			cnt++;
		}
		// v1 / v2
		if(cnt % 2 == 0) { //짝수 인 경우
			int v1 = 1; 
			int v2		
			for(int i = 0;i < cnt;i++) {
				
			}
		}else {
			
		}
	}

}
