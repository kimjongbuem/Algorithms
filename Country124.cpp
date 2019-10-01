#include<iostream>
#include<algorithm>
#include <string>
#include <vector>

using namespace std;

string solution(int n) {
	string result="";
	while (n != 0) {
		int q = n % 3;
		n /= 3;
		if (q == 0) n -= 1;

		switch (q)
		{
		case 0: result += "4";
			break;
		case 1: result += "1";
			break;
		case 2: result += "2";
			break;
		}
	}
	reverse(begin(result), end(result));
	return result;
}

int main() {
	auto c = solution(4);

}