#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;

int main()
{
    ll numKan, numFlowers, kanIn, maxFlow;
    bool found = false;
    cin >> numKan >> numFlowers;
    kanIn = numKan;
    ll flowers[numFlowers];
    for (ll i = 0; i < numFlowers; i++)
    {
        cin >> flowers[i];
    }
    maxFlow = flowers[0];
    ll kanPos[numKan] = {0};
    while (kanIn > 0)
    {
        for (ll i = 0; i < numKan; i++)
        {
            maxFlow = -1;
            if (kanPos[i] == -1)
            {
                continue;
            }
            for (ll j = kanPos[i]; j < numFlowers; j++)
            {
                if (flowers[j] > maxFlow && flowers[j] != -1)
                {
                    kanPos[i] = j;
                    maxFlow = flowers[j];
                    found = true;
                }
            }
            if (!found)
            {
                kanIn--;
                kanPos[i] = -1;
            }
            else
            {
                flowers[kanPos[i]] = -1;
            }
            found = false;
        }
    }
    ll count = 0;
    for (ll i = 0; i < numFlowers; i++)
    {
        if (flowers[i] != -1)
        {
            count++;
        }
    }
    cout << count;
}