// BuildMaxHeap.cpp : This file contains the 'main' function. Program execution begins and ends there.

using namespace std;

#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
#include <cmath>

static int heapSize;

//function protoypes
int left(int);
int right(int);
void buildMaxHeap(vector<int> &);
void maxHeapify(vector<int> &, int);
int getHeight(int);


int left(int nodeIndex) {
	return (2 * nodeIndex) + 1;
}

int right(int nodeIndex) {
	return (2 * nodeIndex) + 2;
}

void buildMaxHeap(vector<int> &ar) {
	heapSize = ar.size();

	for (int i = (ar.size() / 2); i >= 0; i--) {
		maxHeapify(ar, i);
	}
}

void maxHeapify(vector<int> &ar, int i) {
	
	//cout << "Calling max heapify on node: " << i << endl;

	int l = left(i); //left children
	int r = right(i); //right children
	int largest;

	if (l < heapSize && ar[l] > ar[i]) {
		largest = l;
	}

	else {
		largest = i;
	}

	if (r < heapSize && ar[r] > ar[largest]) {
		largest = r;
	}

	if (largest != i) {
		int temporary = ar[i];
		ar[i] = ar[largest];
		ar[largest] = temporary;
		maxHeapify(ar, largest);
	}
}

int getHeight(int heapSize) {

	if (heapSize == 0) {
		return -1;
	}
	
	int height = log2(heapSize);

	return height;
}

int main() {

	vector<int> ar = { 4, 5, 1, 7, 3, 3, 8 };
	//vector<int> ar = {};

	cout << "Given Heap: ";
	for (int i = 0; i < ar.size(); i++) {
		cout << ar[i] << " ";
	}

	cout << endl;

	buildMaxHeap(ar);
	cout << "Outputted Max Heap: ";
	for (int i = 0; i < ar.size(); i++) {
		cout << ar[i] << " ";
	}

	cout << endl << endl;

	cout << "Height: " << getHeight(heapSize) << endl;

	getchar();
	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
