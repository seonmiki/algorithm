#include <iostream>
using namespace std;

int	main()
{
	int n, k;
	cin >> n >> k;

	int arr[1000][2];
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i][0] >> arr[i][1];
	}

	int dat[7][2] = { 0 };
	for (int j = 0; j < n; j++)
	{
		dat[arr[j][1]][arr[j][0]]++;
	}

	int cnt = 0;
	for (int x = 1; x <= 6; x++)
	{
		cnt += dat[x][0] / k;
		if ((dat[x][0] % k) != 0)
			cnt += 1;
		cnt += dat[x][1] / k;
		if ((dat[x][1] % k) != 0)
			cnt += 1;
	}

	cout << cnt;

	return (0);
}
