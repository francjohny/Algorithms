//
// Created by Francis Johny on 27/08/22.
//

#include <vector>
#include <iostream>

using namespace std;

// dist[0][i] = distance from node a to node i
// dist[1][i] = distance from node b to node i
int dist[2][200000];
vector<int> adj[200000];

int dfs(int u, int p, int d, int i) {
    dist[i][u] = d;
    int opt = -1;
    for (int v : adj[u]) {
        if (v != p) {
            int x = dfs(v, u, d+1, i);
            if (opt == -1 || dist[i][x] > dist[i][opt]) opt = x;
        }
    }
    return opt == -1 ? u : opt;
}

int main() {
    int n; cin >> n;
    for (int i = 0; i < n-1; i++) {
        int a, b; cin >> a >> b; --a; --b;
        adj[a].push_back(b); adj[b].push_back(a);
    }
    // first, find node a by finding the farthest node from an arbitrary node x
    int mxNode = dfs(0, 0, 0, 0);
    // then, find node b (this step also computes distance from a to every other node)
    int mxNode2 = dfs(mxNode, mxNode, 0, 0);
    // finally, compute the distance from b to every other node
    dfs(mxNode2, mxNode2, 0, 1);

    for (int i = 0; i < n; i++) {
        cout << max(dist[0][i], dist[1][i]) << " \n"[i == n-1];
    }
    return 0;
}