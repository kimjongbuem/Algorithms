#include <string>
#include <vector>
#include <set>
#include<iterator>
using namespace std;

// ���� ������ ������ ��� �Լ� ���� �ʱ�ȭ �ڵ带 �� �ۼ����ּ���.
string solution(int m, int n, vector<string> board) {
	string answer = "";
	set<char> data;

	for (int h = 0; h < m; h++) { // set �ڷᱸ���� ���� �켱���� �˷��ֱ�.
		for (int w = 0; w < n; w++) {
			if (board[h][w] == '.' || board[h][w] == '*') continue;
			data.insert(board[h][w]);
		}
	} 
	
	while (!data.empty()) { // set�� ���� ���� ���� ��ӹݺ�
		bool remove = false;
		auto iter = data.begin();
		for (; iter != data.end(); iter++) {
			if (remove) break;
			char c = *iter;
			for (int h = 0; h < m; h++) {
				if (remove) break;
				for (int w = 0; w < n; w++) {
					if (remove) break;
					if (board[h][w] == '.' || board[h][w] == '*' || c != board[h][w]) continue;
					else { // ������...
						for (int y = h; y < m; ++y) {
							if (board[y][w] == '*' || remove) break;
							int r; if (y == h && w + 1 != n) r = w + 1; else if (y == h && w + 1 == n) continue; else r = w;
							for (int x = r; x < n; x++) {
								if (board[y][x] == '.') continue;
								else if (board[y][x] != c || board[y][w] == '*') {
									break;
								}
								else {
									for (int i = h; i <= y; i++) board[i][w] = '.';
									for (int i = w; i <= x; i++) board[y][i] = '.'; // update
									answer += c;
									data.erase(c);
									remove = true;
									iter = data.begin();
									if (iter == data.end()) {
										return answer;
									}
									break;
								}
							}
						}
						for (int x = w; x < n; ++x) {
							if (board[h][x] == '*' || remove) break;
							int r; if (x == w && h + 1 != m) r = h + 1; else if (x == w && h + 1 == m) continue; else r = h;
							for (int y = r; y < m; y++) {
								if (board[y][x] == '.') continue;
								else if (board[y][x] != c || board[h][x] == '*') {
									break;
								}
								else {
									for (int i = h; i <= y; i++) board[i][x] = '.';
									for (int i = w; i <= x; i++) board[h][i] = '.'; // update
									answer += c;
									data.erase(c);
									remove = true;
									iter = data.begin(); if (iter == data.end()) return answer;
									break;
								}
							}
						}
					}
				}
			}
		}
		if (!remove) return "IMPOSSIBLE";
	}
	return answer;
}





int main() {
	vector<string> board = { "NRYN", "ARYA" };
	solution(2, 4, board);
}