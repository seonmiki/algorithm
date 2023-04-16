#include <iostream>
#include <string>
using namespace std;

void    indat(string str, int dat[200])
{
    for (int i = 0; i < str.length(); i++)
    {
        dat[str[i]]++;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    string str;
    string find;
    for (int i = 0; i < n; i++)
    {
        int dat1[200] = {0};
        int dat2[200] = {0};
        int flag = 0;
        cin >> str >> find;
        if (str.length() != find.length())
            cout << "Impossible\n";
        else
        {
            indat(str, dat1);
            indat(find, dat2);
            for (char ch = 'a'; ch <= 'z'; ch++)
            {
                if (dat1[ch] != dat2[ch])
                {
                    flag = 1;
                    break;
                }
            }
            if (flag)
                cout << "Impossible\n";
            else
                cout << "Possible\n";
        }
    }
    return (0);
}
