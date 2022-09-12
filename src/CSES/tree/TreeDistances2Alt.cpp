//
// Created by Francis Johny on 27/08/22.
//

#include <vector>
#include <iostream>

using namespace std;

vector<int> adj[200000];
long counter[200000];
long sumDistance[200000];

void dfs(int u, int p) {
    for (int v: adj[u]) {
        if (v != p) {
            dfs(v, u);
            counter[u] += counter[v];
            sumDistance[u] += sumDistance[v] + counter[v];
        }
    }
    counter[u]++;
}

void dfs1(int u, int p, int n) {
    for (int v: adj[u]) {
        if (v != p) {
            sumDistance[v] = sumDistance[u] - counter[v] + n - counter[v];
            dfs1(v, u, n);
        }
    }
}

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        int a, b;
        cin >> a >> b;
        --a;
        --b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    dfs(0, -1);
    dfs1(0, -1, n);
    for (int i = 0; i < n; i++) {
        cout << sumDistance[i] << " ";
    }
    cout << "\n";
    return 0;
}