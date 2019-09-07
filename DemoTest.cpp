#include <iostream>
#include <vector>
using namespace std;

vector<int> solution(vector<vector<int>> v) {
	vector<int> ans;
	
	int x = 0, y = 0;

	v[0][0] != v[1][0] ? v[0][0] != v[2][0] ? x = v[0][0]: x= v[1][0] : x = v[2][0];
	v[0][1] != v[1][1] ? v[0][1] != v[2][1] ? y = v[0][1] : y = v[1][1] : y = v[2][1];
	ans.emplace_back(x);
	ans.emplace_back(y);
	return ans;
}

int main() {
	vector<vector<int> > v;
	vector<int> d1 = { 1,4 };
	vector<int> d2 = { 3,4};
	vector<int> d3 = { 3,10 };
	v.emplace_back(d1);
	v.emplace_back(d2);
	v.emplace_back(d3);

	for (int i = 0; i < 3; i++) {
		cout << v[i][0] << " ";
		cout << v[i][1] << endl;
	}


	auto ans = solution(v);
	cout << ans[0]<< " " << ans[1];
	cout << endl;
	system("pause");

}