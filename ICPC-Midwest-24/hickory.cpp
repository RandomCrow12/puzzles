#include <iostream>
#include <cmath>
#include <algorithm>
#define ll long long
using namespace std;
 
int main()
{
    ll noses = 0, eyes = 0, ears = 0, tails = 0, paws = 0, n;
    string temp;
    cin >> n;
    for (ll i = 0; i < n; i++)
    {
        cin >> temp;
        if (temp == "paw")
        {
            paws++;
        }
        else if (temp == "paws")
        {
            paws+=2;
        }
        else if (temp == "nose")
        {
            noses++;;
        }
        else if (temp == "noses")
        {
            noses+=2;
        }
        else if (temp == "eye")
        {
            eyes++;;
        }
        else if (temp == "eyes")
        {
            eyes+=2;
        }
        else if (temp == "ear")
        {
            ears++;;
        }
        else if (temp == "ears")
        {
            ears+=2;
        }
        else if (temp == "tail")
        {
            tails++;;
        }
        else if (temp == "tails")
        {
            tails+=2;
        }
    }
    if (paws%4 != 0)
    {
        paws/=4;
        paws++;
    }
    else{
        paws/=4;
    }
    if (eyes%2 != 0)
    {
        eyes/=2;
        eyes++;
    }
    else{
        eyes/=2;
    }
    if (ears%2 != 0)
    {
        ears/=2;
        ears++;
    }
    else{
        ears/=4;
    }
    ll maxNum = max(ears, max(eyes, max(tails, max(paws, noses))));
    if (maxNum == 1)
    {
        cout << "1 mouse";
    }
    else
    {
        cout << maxNum << " mice";
    }
}