#include <iostream>
using namespace std;

int main()
{
    int a, b, c;
    cin >> a >> b >> c;

    int gob = a * b * c;
    int dat[10] = {0};
    while (gob / 10)
    {
        int tmp = gob % 10;
        dat[tmp] += 1;
        gob = gob / 10;
    }
    dat[gob % 10] += 1;
    for (int i = 0; i < 10; i++)
        cout << dat[i] << endl;
    return (0);
}
