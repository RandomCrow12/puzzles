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
        int n;
        string win;

        cin >> n;


        // false = 6
        // true = 7

        // b
        // o



        bool prev = true;
        bool player = false;

        // if (n == 1){
        //     std::cout<< "Oski" << std::endl;
        //     continue;
        // } else if (n == 2){
        //     std::cout<< "Big Ben" << std::endl;
        //     continue;
        // } else if (n == 3){
        //     std::cout<< "Oski" << std::endl;
        //     continue;
        // }


        // 0, b), 7 => o,1) 6 => b,2) 6 => o,3) 7 

        for(int i = 0; i < n; i++){
            bool winning = false;

            // total - turns remaining
            if ((n-i)%2 == 0){
                // current player winning parity
                winning = true;
            }

            if (winning){
                // prev same
                if (i != n-1) player = !player;
            } else {
                if (prev == false){ // 6
                    prev = !prev; // 7
                } else {
                    prev = !prev; 
                    if (i != n-1) player = !player;
                }
                
            }
        }

        if (player){
            std::cout<< "Big Ben" << std::endl;
        } else {
            std::cout<< "Oski" << std::endl;

        }
    }

    
    return 0;
}