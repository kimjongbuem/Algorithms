#include <iostream>
#include<vector>
#define MAX_SIZE = 8;
using namespace std;
// 오름차순 합병정렬 //
class SortRule;
class AscendingSort;
class DecendingSort;
class Sorts {
public:
	virtual void sort(vector<int>& datas, const SortRule&) = 0;
	void print(vector<int>& datas) const {
		for (int data : datas) {
			cout << data << " ";
		}
		cout << endl;
	}
};
class MergeSort : public Sorts {
private:
	//SortRule& sortRule;
public:
	void sort(vector<int>& datas, const SortRule& rule) {
		//sortRule = rule;
		sorted.resize(8);
		mergeSort(datas, 0, datas.size() - 1);
		for (int data : sorted) {
			cout << data << " ";
		}
		cout << endl;
	}

private:
	void mergeSort(vector<int>& datas,int left, int right) {
		if (!(left < right)) return;
		int mid = (left + right )/ 2;
		
		mergeSort(datas, left, mid);
		mergeSort(datas, mid + 1, right);
		merge(datas, left, mid, right);
	}
	void merge(vector<int>& datas, int left, int mid, int right) {
		int l = left;
		int j = mid + 1;
		int k = left;
		while (l <= mid && j <= right) {
			if (datas[l] <= datas[j]) sorted[k++] = datas[l++];
			else sorted[k++] = datas[j++];
		}
		if (l > mid) {
			for (l = j; l <= right; l++)
				sorted[k++] = datas[l];
		}
		else {
			for (; l <= mid; l++)
				sorted[k++] = datas[l];
		}
		for (l = left; l <= right; l++) {
			datas[l] = sorted[l];
		}
	}
private:
	vector<int> sorted;
};

class SortRule {
	virtual bool operator()(int num1, int num2) = 0;
};
class AscendingSort : public SortRule {
	bool operator()(int num1, int num2) {
		if (num1 - num2 > 0) return true;
		return false;
	}
};
class DecendingSort : public SortRule {
	bool operator()(int num1, int num2) {
		if (num1 - num2 < 0) return true;
		return false;
	}
};
int main() {
	vector<int> datas = { 21,11,30,29,88,455,9,66 };
	Sorts* sort = new MergeSort();
	sort->sort(datas, AscendingSort());
	sort->print(datas);
	system("pause");
}