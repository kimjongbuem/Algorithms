import java.util.Arrays;


public class BigNumbering {

	public static void main(String[] args) {
		Solution s = new BigNumbering().new Solution();
		int numbers[] = {3,30,34,5,9};
		String str =s.solution(numbers);
		System.out.println(str);
	}
	class Solution{// implements Comparator<String>{
		public String solution(int[] numbers) {	
			String strs[] = new String[numbers.length];
			for(int i = 0; i<numbers.length;i++) {
				strs[i] = Integer.toString(numbers[i]);
			}
			Arrays.sort(strs, (o1,o2) -> (o1+o2).compareTo(o2+o1));
			StringBuilder bs = new StringBuilder();
			for(int i= numbers.length - 1; i>=0;i--) {
				bs.append(strs[i]);
			}
			if(strs[0].equals("0")) return "0";
			return bs.toString();
		}
//		@Override
//		public int compare(String o1, String o2) {
//			String str1 = o1.concat(o2); String str2 = o2.concat(o1);
//			int num1 = Integer.parseInt(str1); int num2 =  Integer.parseInt(str2);
//			return num2 - num1;
//		}
//		}
//		   public String solution(int[] numbers) {	     
//			   String answer = sort(numbers);
//		        return answer;
//		    }
//		   public int permutation(int n) {
//			   int result = 1;
//			   for(int i = 1; i<= n ; i++) {
//				   result *= i;
//			   }
//			   return result;
//		   }
//		   
//		   public String sort(int[] numbers) {
//			   StringBuilder bs = new StringBuilder();
//			   int length = numbers.length;
//			   for(int i = 0; i< length - 1; i++) {
//			    	  for(int j = i + 1; j< length ; j++) {
//				    	  if(numbers[i]% 10 < numbers[j]% 10) {
//				    		  int tmp = numbers[i];
//				    		  numbers[i] = numbers[j];
//				    		  numbers[j] = tmp;
//				    	  }else if(numbers[i] % 10 == numbers[j] % 10) {
//				    		  if(numbers[i]% 10 < numbers[j]% 10) {
//				    			  int tmp = numbers[i];
//					    		  numbers[i] = numbers[j];
//					    		  numbers[j] = tmp;
//				    		  }
//				    	  }
//				      }
//			      }
//		       for(int n = 0; n < numbers.length; n++) {
//		    	   bs.append(Integer.toString(numbers[n]));
//		       }
//		       return bs.toString();
//		   }
//	}

		
	}
}
/*
 * 일단 어떤 num % 10 으로하여 각각의 숫자들을 버블 정렬한다. but %10 연산을하고 같은 값이 있을 수 있다. 그렇다면 이때는 그 숫자 자체를 비교해서 넣어준다.
 */
