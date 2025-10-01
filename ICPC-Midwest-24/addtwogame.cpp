#include <iostream>
#define ll long long
using namespace std;

int main()
{
    ll a, b, c, steps = 0;
    cin >> a >> b >> c;
    while (a < c && b < c)
    {
        if (a <= b)
        {
            a += b;
        }
        else 
        {
            b += a;
        }
        steps++;
    }
    cout << steps;
}