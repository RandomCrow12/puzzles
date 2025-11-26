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

// https://calicojudge.com/team/problems/814/statement

int main(){

    int t;
    // n & m dimensions side view
    cin >> t;

    for(int i = 0; i < t; i++){
        int n, m;
        cin >> n;
        cin >> m;

        string view[n];
        for(int k = 0; k < n; k++){
            cin >> view[k];
        }

        int mask[m];
        for(int i = 0; i < m; i++){ // needed?
            mask[i] = 0;
        }

        for(int k = 0; k < n; k++){ // awful spatial locality
            for(int i = 0; i < m; i++){
                if (view[k][i] == '.') {}
                else {
                    if (mask[i] < view[k][i] - '0'){
                        mask[i] = view[k][i] - '0'; //uhhh


                    }
                }
            }
        }
        
        int area = 0;

        for(int i = 0; i < m; i++){
            area += mask[i];
        }

        std::cout<< area << std::endl;

    }
    


    return 0;
}