#include <iostream>
#include <list>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, k;
    cin >> n >> k;

    list<int> L;
    for (auto i = 1; i <= n; i++)
        L.push_back(i);

    cout << "<";
    auto p = L.begin();
    while (L.size() != 1)
    {
        for (int i = 0; i < k - 1; i++)
        {
            p++;
            if (p == L.end())
                p = L.begin();
        }
        cout << *p << ", ";
        p = L.erase(p);
        if (p == L.end())
            p = L.begin();
    } 
    cout << *p << ">";

    return (0);
}
