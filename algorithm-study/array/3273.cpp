#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{

    int arr[100001];
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    int xx;
    cin >> xx;

    sort(arr, arr + n);
    int cnt = 0;
    int left = 0;
    int right = n - 1;
    while (left < right)
    {
        if (arr[left] + arr[right] == xx)
        {
            cnt++;
            right--;
        }
        else if (arr[left] + arr[right] > xx)
            right--;
        else
            left++;
    }
    cout << cnt;
    return (0);
}
