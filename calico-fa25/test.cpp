#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <map>
//#include <set>
//#include <unordered_map>
//#include <unordered_set>
//#include<bits/stdc++.h>
#define ll long long
using namespace std;


int main(){
    map<int, string> people;
    // key, name

    people[1] = "Jerry";
    people[2] = "Emerson";
    people[3] = "Austin";

    
    std::cout<< people[1] << std::endl;

    people.insert({4, "Nayan"});
    people.erase(1);


    return 0;
}