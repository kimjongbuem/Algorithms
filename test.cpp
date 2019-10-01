#include <string>
#include <vector>
#include<algorithm>
using namespace std;
int max(int a, int b) {
	return a < b ? b : a;
}

vector<int> solution(vector<int> answers) {
	vector<int> answer;
	int supoza1[5] = { 1,2,3,4,5 };
	int supoza2[8] = { 2,1,2,3,2,4,2,5};
	int supoza3[10] = { 3,3,1,1,2,2,4,4,5,5};
	int cnt[3] = {0};
	for (int i = 0; i < answers.size(); i++) {
		if (supoza1[i % 5] == answers[i]) cnt[0]++;
		if (supoza2[i % 8] == answers[i]) cnt[1]++;
		if (supoza3[i % 10] == answers[i]) cnt[2]++;
	}
	int v = max(max(cnt[0], cnt[1]), cnt[2]);;
	for (int i = 0; i < 3; ++i) {
		if (cnt[i] == v) answer.push_back(1 + i);
	}
	return answer;
}

int main() {
	solution({ 1,2,3,4,5 });
}