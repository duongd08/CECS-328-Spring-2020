// InsertionSort.cpp : This file contains the 'main' function. Program execution begins and ends there.

using namespace std;

#include <iostream>
#include <vector>
#include <algorithm>


void insertionSort(vector<int> &array) {

	for (int j = 1; j < array.size(); j++) {

		int key = array[j];

		int i = j - 1;

		cout << "i is: " << i << endl;

		while (i >= 0 && array[i] > key) {
			array[i + 1] = array[i];
			i -= 1;

			// Beware, you are still in the while loop

			cout << "Processing Insertion Sort: ";
			for (int i = 0; i < array.size(); i++) {
				cout << array[i] << " ";
			}

			cout << endl;

		}
		cout << "The key is: " << key << endl;
		array[i + 1] = key;
	}
}

int main() {
    //cout << "Hello World!\n";
	vector <int> array = { 31, 41, 59, 26, 41, 58 };
	
	cout << "Before insertion sort: ";

	for (int i = 0; i < array.size(); i++) {
		cout << array[i] << " ";
	}

	cout << endl;

	insertionSort(array);

	cout << "After insertion sort: ";

	for (int i = 0; i < array.size(); i++) {
		cout << array[i] << " ";
	}

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
