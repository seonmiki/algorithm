#include <iostream>
using namespace std;

int main()
{
    int dat[10] = {0};
    int n;
    cin >> n;

    while (n / 10)
    {
        if (n % 10 == 9)
            dat[6] += 1;
        else
            dat[n % 10] += 1;
        n = n / 10;
    }
    if (n % 10 == 9)
        dat[6] += 1;
    else
        dat[n % 10] += 1;

    int max = -1;
    dat[6] = (dat[6] / 2) + (dat[6] % 2);
    for (int i = 0; i < 9; i++)
    {
        if (max < dat[i])
            max = dat[i];
    }

    cout << max;

    return (0);
}
