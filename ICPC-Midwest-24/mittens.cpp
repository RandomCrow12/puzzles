#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;
 
int main()
{
    ll arr1[8];
    ll arr2[8];
    for (ll i = 0; i < 8; i++)
    {
        cin >> arr1[i];
    }
    for (ll i = 0; i < 8; i++)
    {
        cin >> arr2[i];
    }
    sort(arr1, arr1 + 8);
    sort(arr2, arr2 + 8);
    for (ll i = 0; i < 8; i++)
    {
        if (abs(arr1[i] - arr2[i]) > 1)
        {
            cout << "Some kittens will not have mittens";
            return 0;
        }
    }
    cout << "All kittens can have mittens";
}