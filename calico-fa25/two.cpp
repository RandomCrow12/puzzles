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
using namespace std;


int main(){

    int t;
    cin >> t;

    for(int i = 0; i < t; i++){
        string stl;
        string l;
        cin >> stl;
        cin >> l;
        
        // predicted number
        int n = 999999;
        
        if (stl != "bizz" && stl != "fuzz" && stl != "bizzfuzz") n = stoi(stl)+2;
        else if (l != "bizz" && l != "fuzz" && l != "bizzfuzz") n = stoi(l)+1;


        if (n == 999999) std::cout<< "crap" << std::endl;
        else if (n % 3 == 0 && n % 5 == 0) std::cout<< "bizzfuzz" << std::endl;
        else if (n % 3 == 0) std::cout<< "bizz" << std::endl;
        else if (n % 5 == 0) std::cout<< "fuzz" << std::endl;
        else std::cout<< n << std::endl;
    }



    return 0;
}