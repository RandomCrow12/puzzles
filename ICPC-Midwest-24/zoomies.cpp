#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;
 
int main()
{
    ll n, count = 1, maxCount = 1;
    cin >> n;
    ll arr1[n];
    ll dis[n-1];
    for (ll i = 0; i < n; i++)
    {
        cin >> arr1[i];
    }
    for(ll i = 0; i < n-1; i++)
    {
        dis[i] = abs(arr1[i]-arr1[i+1]);
    }
    // cout << "\n";
    // for (ll num : dis)
    // {
    //     cout << num << "\n";
    // }
    // cout << "\n";
    for (ll i = 0; i < n-2; i++)
    {
        if (dis[i+1] >= dis[i] && dis[i] != 0)
        {
            count++;
        }
        else
        {
            maxCount = max(count, maxCount);
            count = 1;
        }
    }
    maxCount = max(count, maxCount);
    if (n <= 1)
    {
        cout << 0;
    }
    else
    {
        cout << maxCount;
    }
}