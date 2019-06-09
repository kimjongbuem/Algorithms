import java.util.Scanner;

public class algoritm_reverse {

	static int reverseBits(int n) {
       String str = String.valueOf(n) ;
      char[]reverseBit = new char[str.length()];
      char[] numberBits = str.toCharArray();
      for(int i = 0; i<str.length();i++) {
    	  reverseBit[i] = numberBits[str.length()-1-i];
      }
      return Integer.parseInt(new String(reverseBit));
    }
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		int num = Integer.parseInt(data);
		System.out.println(data);
		System.out.println(reverseBits(num));
		}
	}

