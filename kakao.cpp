#include<iostream>
#include <vector>
#include<string>
using namespace std;

//int solution(string s) {
//	int answer = 0;
//	string returnString = "";
//	string storeString[1024];
//
//	int charIndex = 0;
//	int storeIndex = 0;
//	char* cp = new char[128];
//	cp[0] = s[0]; charIndex++;
//	bool isAlone = false;
//	int i = 0;
//	for (; i < s.size(); i++) {
//		string single;
//		int sameCnt = 1;
//		int substrCnt = 1;
//		int size = 1;
//		
//		while (!(s.size() < size + i)) {
//			string temp = s.substr(i, size);
//			if (size == 1) {
//				for (int j = i + 1; j <= s.size(); j++) {
//					single = s[i];
//					if (s[j - 1] == s[j]) sameCnt++;
//					else break;
//				}
//			}
//			else {
//				bool isUpper = false;
//				int cnt = 1;
//				for (int c = 1; c*size + i < s.size(); c++) {
//					
//					if (temp == s.substr(i + c * size, size)) {
//						storeString[storeIndex] = temp;
//						isUpper = true;
//						cnt++;
//					}
//					else break;
//				}
//				if (isUpper) {
//					substrCnt = cnt;
//				}
//			}
//			size++;
//		}
//			if (substrCnt > 1) {
//				i += storeString[storeIndex].size()* substrCnt - 1;
//				returnString += to_string(substrCnt) + storeString[storeIndex++];
//				
//			}
//			else if (sameCnt > 1) {
//				i += sameCnt - 1 ;
//				returnString+= to_string(sameCnt) + single;
//			}
//			else if (sameCnt == 1 ) {
//				returnString += single;
//				if (i == 0) {
//					isAlone = true;
//					break;
//				}
//			}
//		}
//	
//	if (isAlone) {
//		for (i = 1; i < s.size(); i++) {
//			returnString += s[i];
//		}
//	}
//
//	answer = returnString.size();
//	return answer;
//}
#include<stack>
string solution(string p) {
	stack<char> stacks;
	bool inCorrect = false;
	for (int i = 0; i < p.size(); i++) {
		if(p[i] == '(')
			stacks.push(p[i]);
		else if(p[i] == ')') {
			if (stacks.empty() || stacks.top() != ')') {
				inCorrect = true;
				break;
			}
			stacks.pop();
		}
	}
	string answer;
	if (inCorrect)
		answer = "오류";
	else
		answer = "매칭 오케이";

	
	return answer;
}
int main() {
	cout << solution("()())(()")<<endl;
	system("pause");
}