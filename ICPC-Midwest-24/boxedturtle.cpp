#include <iostream>
#define ll long long
using namespace std;

int main()
{
    ll sx, sy, numMoves, boxX = 0, boxY = 0, actX, actY;
    char dir;
    string moves;
    cin >> sx >> sy >> dir >> numMoves >> moves;
    actX = sx;
    actY = sy;
    for (ll i = 0; i < numMoves; i++)
    {
        if (moves[i] == 'F')
        {
        }
        else if (moves[i] == 'B')
        {
            if (dir == 'N')
            {
                dir = 'S';
            }
            else if (dir == 'S')
            {
                dir = 'N';
            }
            else if (dir == 'E')
            {
                dir = 'W';
            }
            else
            {
                dir = 'E';
            }
        }
        else if (moves[i] == 'R')
        {
            if (dir == 'N')
            {
                dir = 'E';
            }
            else if (dir == 'S')
            {
                dir = 'W';
            }
            else if (dir == 'E')
            {
                dir = 'S';
            }
            else
            {
                dir = 'N';
            }
        }
        else
        {
            if (dir == 'N')
            {
                dir = 'W';
            }
            else if (dir == 'S')
            {
                dir = 'E';
            }
            else if (dir == 'E')
            {
                dir = 'N';
            }
            else
            {
                dir = 'S';
            }
        }
        if (dir == 'N')
        {
            if (actY >= boxY + 4)
            {
                boxY++;
                actY++;
            }
            else
            {
                sy++;
                actY++;
            }
        }
        else if (dir == 'S')
        {
            if (actY == boxY)
            {
                boxY--;
                actY--;
            }
            else
            {
                sy--;
                actY--;
            }
        }
        else if (dir == 'E')
        {
            if (actX >= boxX + 4)
            {
                boxX++;
                actX++;
            }
            else
            {
                sx++;
                actX++;
            }
        }
        else
        {
            if (actX == boxX)
            {
                boxX--;
                actX--;
            }
            else
            {
                sx--;
                actX--;
            }
        }
    }
    cout << "(" << boxX << ", " << boxY << ")\n";
    cout << "(" << sx << ", " << sy << ")\n";
    cout << dir;
}
