#include <iostream>
#include <list>
#include <string>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    string str;
    cin >> str;

    list<char> L;
    for (int i = 0; i < str.length(); i++)
        L.push_back(str[i]);
    auto cursor = L.end();    

    int m;
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        char ch;
        cin >> ch;
        if (ch == 'P')
        {
            char add;
            cin >> add;
            L.insert(cursor, add);
        }
        else if (ch == 'L')
        {
            if (cursor != L.begin())
                cursor--;
        }
        else if (ch == 'D')
        {
            if (cursor != L.end())
                cursor++;
        }
        else if (ch == 'B')
        {
            if (cursor != L.begin())
            {
                cursor--;
                cursor = L.erase(cursor);
            }
        }
    }

    for (auto i = L.begin(); i != L.end(); i++)
        cout << *i;

    return (0);
}
