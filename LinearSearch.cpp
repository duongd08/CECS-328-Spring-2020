// LinearSearch.cpp : This file contains the 'main' function. Program execution begins and ends there.

using namespace std;

#include <iostream>
#include <vector>
#include <algorithm>

int linearSeach(vector <int> &array, int target) {

	bool found = false;
	
	for (int position = 0; position < array.size(); position++) {
		if (array[position] == target) {
			found = true;
			return position ;
		}
	}

	return -1; // return -1 if the element is not in the vector
}

int main() {
	vector<int> array = {4, 5, 1, 7, 3, 3, 8};
	cout << "7 is at postion: " << linearSeach(array, 7) << endl;
	cout << "69: " << linearSeach(array, 69) << endl; // 69 is not in the array
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
