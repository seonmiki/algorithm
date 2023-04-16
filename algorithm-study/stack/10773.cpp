#include <iostream>
#include <bits/stdc++.h>
#include <string>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int k;
    cin >> k;

    stack<int> S;

    int sum = 0;
    for (int i = 0; i < k; i++)
    {
        int n;
        cin >> n;
        if (n == 0)
        {
            if (!S.empty())
            {
                sum -= S.top();
                S.pop();
            }
        }
        else
        {
            S.push(n);
            sum += S.top();
        }
    }
    cout << sum;

    return (0);
}