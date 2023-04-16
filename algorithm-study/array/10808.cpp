#include <iostream>
using namespace std;

int main()
{
    int dat[200] = {0};
    char str[101];
    int i;

    cin >> str;

    i = 0;
    while (str[i])
    {
        dat[str[i]]++;
        i++;
    }

    for (int j = 'a'; j <= 'z'; j++)
        cout << dat[j] << " ";

    return 0;
}