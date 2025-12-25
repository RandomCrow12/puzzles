#include <iostream>
#include <string>
#include <cmath>
#include <vector>
//#include <map>
//#include <set>
//#include <unordered_map>
//#include <unordered_set>
//#include<bits/stdc++.h>
#define ll long long
#define llu long long unsigned int
using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        vector<int> rlist; // list of indexes at which the target exists
    // nums was given as a vector ptr
     // dereferencing the given vector to index easily

    for(int k = 0; k < nums.size(); k++){
        if (nums.at(k) == val) rlist.push_back(k); // store matching indices in arr
    }

    for(int i = rlist.size()-1; i >= 0; i--){ // going backwards to remove elements from nums to avoid indexing issue
        nums.erase(nums.begin() + rlist[i]);
    }
    return nums.size();
    }
}; // use nums without -> bc it is not a vector<int>* being passed in, it is a reference to nums passed in.
// & (in a fn param specifically makes this work)
