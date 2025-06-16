#include <iostream>
#include <string>
#include <cmath>
#include <vector>
// #include<bits/stdc++.h>
#define ll long long
using namespace std;

void solver(int count, string line, vector<int>& nums);

int main()
{
    int tc;
    cin >> tc;

    for (int i = 0; i < tc; i++)
    {
        string line;
        cin >> line;

        int initCount = 0;
        for (int z = 0; z < line.length(); z++){
            if (line[z] == 'o') initCount++;
        }

        vector<int> nums;
        solver(initCount, line, nums);

        int ans = initCount;
        for (int a : nums){
            // std::cout<< a << std::endl;
            if (a < ans) ans = a;
        }

        std::cout<< ans << std::endl;

    }
}

void solver(int count, string line, vector<int>& nums)
{
    nums.push_back(count);

    for (int v = 0; v < line.length(); v++)
    {
        if (v > 2)
        {
            if (line[v - 1] == 'o' && line[v] == 'o' && line[v - 2] == '-') // valid path
            {
                string newline = line.substr(0,v-2) + "o--" + line.substr(v+1,line.length());
                solver(count-1, newline, nums);
            }
        }

        if (v < line.length() - 2)
        {
            if (line[v + 1] == 'o' && line[v] == 'o' && line[v + 2] == '-') // valid path
            {
                string newline = line.substr(0,v) + "--o" + line.substr(v+3,line.length());
                solver(count-1, newline, nums);

            }
        }
    }

    return;
}