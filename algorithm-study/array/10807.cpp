#include <iostream>
using namespace std;

int	main()
{
	int	n;
	cin >> n;

	int arr[100];
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	
	int	v;
	cin >> v;
	int	cnt = 0;
	for (int j = 0; j < n; j++)
	{
		if (arr[j] == v)
			cnt++;
	}

	cout << cnt;

	return (0);
}
