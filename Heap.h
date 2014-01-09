#include <iostream>
#include <stdlib.h>


class Heap {
	private:
		vector<int> mHeap;

	public:
		Heap(int *input);
		void insert(int n);
		void deleteMin();
		int  getMin();
		bool isEmpty();
};
