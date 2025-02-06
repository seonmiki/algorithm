#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

vector<int> arr[1005];

bool vis[1005];
void dfs(int cur) {
    vis[cur] = true;
    cout << cur << " ";
    for (auto nxt : arr[cur]) {
        if (vis[nxt] == true) continue ;
        dfs(nxt);
    }
}

queue<int> que;
void bfs() {
    while (!que.empty()) {
        int cur = que.front();
        que.pop();
        cout << cur << " ";
        for (auto nxt : arr[cur]) {
            if (vis[nxt] == true) continue;
            que.push(nxt);
            vis[nxt] = true;
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, v;
    cin >> n >> m >> v;

    //그래프 입력받기
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        arr[a].push_back(b);
        arr[b].push_back(a);
    }

    for (int i = 1; i <= n; i++) {
        sort(arr[i].begin(), arr[i].end());
    }

    //DFS
    fill(vis, vis + n + 1, false);
    dfs(v);
    cout << '\n';

    //BFS
    fill(vis, vis + n + 1, false);
    que.push(v);
    vis[v] = true;
    bfs();

    return 0;
}