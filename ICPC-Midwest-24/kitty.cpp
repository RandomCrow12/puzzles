#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;
 
int main()
{
    double w, width, height, boxWidth, boxHeight, maxH, minH, maxW, minW;
    cin >> w >> width >> height;
    maxH = minH = height;
    maxW = minW = width;
    for (ll i = 0; i < w+2; i++)
    {
        cin >> width >> height;
        maxH = max(maxH, height);
        minH = min(minH, height);
        maxW = max(maxW, width);
        minW = min(minW, width);
    }
    cin >> boxWidth >> boxHeight;
    double catWidth = abs(minW) + abs(maxW);
    double catHeight = abs(minH) + abs(maxH);
    if (catWidth > boxWidth || catHeight > boxHeight)
    {
        cout << "Sorry kitty!";
    }
    else
    {
        cout << "Kitty fits!";
    }

}