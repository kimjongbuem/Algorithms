
public class RomanCharacter {
	class Solution {
		    int romanToInt(String s) {
		        char[] cArray = s.toCharArray();
		        int cnt =  0;
		        int total = 0;
		        while(cnt < cArray.length) {
		        	switch (cArray[cnt]) {
					case 'I':
						try {
						if(cArray[cnt+1] == 'V')
						{
							cnt+=2; 
							total+= 4;
						}
						else if(cArray[cnt+1] == 'X') {
							cnt+=2;
							total+=9;
						}
						else {
							cnt++;
							total+=1;
						}
						}catch(IndexOutOfBoundsException e) {
							cnt++;
							total+=1;
						}
						break;

					case 'V':
						cnt++;
						total+=5;
						break;
					case 'X' :
						try {
							if(cArray[cnt+1] == 'L')
							{
								cnt+=2; 
								total+= 40;
							}
							else if(cArray[cnt+1] == 'C') {
								cnt+=2;
								total+=90;
							}
							else {
								cnt++;
								total+=10;
							}
							}catch(IndexOutOfBoundsException e) {
								cnt++;
								total+=10;
							}
						break;
					}
		        }
		        return total;
		    }
		};
}
