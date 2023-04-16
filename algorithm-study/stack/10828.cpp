#include <iostream>
#include <bits/stdc++.h>
#include <string>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    stack<int> S;

    for (int i = 0; i < n; i++)
    {
        string input;
        cin >> input;
        if (input == "push")
        {
            int push;
            cin >> push;
            S.push(push);
        }
        else if (input == "pop")
        {
            if (S.empty())
                cout << "-1\n";
            else
            {
                cout << S.top() << "\n";
                S.pop();
            }
        }
        else if (input == "size")
        {
            cout << S.size() << "\n";
        }
        else if (input == "empty")
        {
            cout << (int)S.empty() << "\n";
        }
        else // "top";
        {
            if (S.empty())
                cout << "-1\n";
            else
                cout << S.top() << "\n";
        }
    }

    return (0);
}
