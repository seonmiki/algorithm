#include <iostream>
#include <string>
#include <list>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    
    string input;
    for (int i = 0; i < n; i++)
    {
        cin >> input;
        list<char> L;
        auto cursor = L.begin();
        for (int i = 0; i < input.length(); i++)
        {
            if (input[i] == '<')
            {
                if (cursor != L.begin())
                    cursor--;
            }
            else if (input[i] == '>')
            {
                if (cursor != L.end())
                    cursor++;
            }
            else if (input[i] == '-')
            {
                if (cursor != L.begin())
                {
                    cursor--;
                    cursor = L.erase(cursor);
                }
            }
            else
            {
                L.insert(cursor, input[i]);
            }
        }
        for (auto i = L.begin(); i != L.end(); i++)
            cout << *i;
        cout << "\n";
    }

    return (0);
}
