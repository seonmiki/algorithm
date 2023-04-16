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

    string str1, str2;
    cin >> str1 >> str2;

    int dat1[200] = {0};
    int dat2[200] = {0};
    indat(str1, dat1);
    indat(str2, dat2);
    int cnt = 0;
    for (char ch = 'a'; ch <= 'z'; ch++)
    {
        if (dat1[ch] != dat2[ch])
        {
            if (dat1[ch] > dat2[ch])
                cnt += dat1[ch] - dat2[ch];
            else
                cnt += dat2[ch] - dat1[ch];
        }
    }
    cout << cnt;

    return (0);
}
