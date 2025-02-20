#include <iostream>
#include <queue>
using namespace std;

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
    {
        int n, m;
        cin >> n >> m;
        priority_queue<int> pq;
        queue<pair <int, int> > q;
        for (int i = 0; i < n; i++)
        {
            int im;
            cin >> im;
            q.push(make_pair(i, im));
            pq.push(im);
        }
        
        int cnt = 0;
        while (!q.empty())
        {
            int location = q.front().first;
            int value = q.front().second;
            q.pop();

            if (pq.top() == value)
            {
                pq.pop();
                cnt++;
                if (m == location)
                {
                    cout << cnt << '\n';
                    break ;
                }
            }
            else
                q.push(make_pair(location, value));
        }
    }

    return 0;
}
