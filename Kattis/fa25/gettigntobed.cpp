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


bool dfs(int sX, int sY, vector<vector<int>> &boxes){
    if (sX < 0 || sY < 0 || sX >= boxes.size() || sY >= boxes[0].size()) return false;
    if(boxes[sX][sY] == 2){ // base case
        return true;
    } 
    if (boxes[sX][sY] == 1) return false;
    boxes[sX][sY] = 1; // unvisitable (visited)
    // we will do all calls from this square below, so never VISIT this again (all 4 directions get checked below)

    bool ans = false;

    ans |= dfs(sX+1, sY, boxes); // if true, switches to true, else stays false
    ans |= dfs(sX, sY+1, boxes);
    ans |= dfs(sX-1, sY, boxes);
    ans |= dfs(sX, sY-1, boxes);


    return ans;
}

int main(){

    int m,n,k;

    cin>> m;
    cin>> n;
    cin>> k;


    vector<vector<int>> boxes(n, vector<int>(m, 0));

    for(int h = 0; h < k; h++){
        int x, y;
        cin >>x;
        cin >>y;
        boxes[y][x] = 1;
    }
    int x,y;
    cin>>x;
    cin>>y;
    boxes[y][x] = 2;

    bool possible = dfs(0, 0, boxes);

    if (possible){
        std::cout<< "SLEEPING" << std::endl;
    } else {
        std::cout<< "IMPOSSIBLE" << std::endl;
    }

    return 0;
}