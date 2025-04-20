#include <iostream>
#define ll long long
using namespace std;
 
int main()
{
    // Johan X
    // Abdullah O

    //https://open.kattis.com/problems/vemvinner

    string in[9];
    for (ll i = 0; i < 9; i++)
    {
        cin >> in[i];
    }


    // 0  1  2
    // 3  4  5
    // 6  7  8

    bool lmao= false;

ll rows = 0;
while (rows < 7)
{
    if (in[rows] == in[rows+1] && in[rows+1] == in[rows+2]){
        if(in[rows] == "X"){
            cout << "Johan ";
            lmao = true;
        } else if (in[rows] == "O"){
            cout << "Abdullah ";
            lmao = true;
        }
    }

    rows = rows + 3;
}
    
ll col = 0;
while (col < 3)
{
    if (in[col] == in[col+3] && in[col+3] == in[col+6]){
        if(in[col] == "X"){
            cout << "Johan ";
            lmao = true;
        } else if (in[col] == "O"){
            cout << "Abdullah ";
            lmao = true;
        }
    }

    col++;
}

if (in[0] == in[4] && in[4] == in[8]){
        if(in[0] == "X" && !lmao){
            cout << "Johan ";
            lmao = true;
        } else if (in[0] == "O" && !lmao){
            cout << "Abdullah ";
            lmao = true;
        }
    }

if (in[2] == in[4] && in[4] == in[6]){
        if(in[2] == "X" && !lmao){
            cout << "Johan ";
            lmao = true;
        } else if (in[2] == "O" && !lmao){
            cout << "Abdullah ";
            lmao = true;
        }
    }

    if (!lmao){
        cout << "ingen ";
    }

    cout << "har vunnit";
}