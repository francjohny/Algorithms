#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define pb emplace_back
#define FOR(i,L,R) for (int i = L; i < R; i++)
#define FE(i,L,R) for (int i = L; i <= R; i++)

const int MX = 2e5+5;
vector<int> adj[MX];
int timer = 0, st[MX], en[MX];

void dfs(int node, int parent) {
	st[node] = timer++;
	for (int i : adj[node]) {
		if (i != parent) {
			dfs(i, node);
		}
	}
	en[node] = timer-1;
}

template<class T> struct Seg { // comb(ID,b) = b
	const T ID = 0; T comb(T a, T b) { return a+b; }
	int n; vector<T> seg;
	void init(int _n) { n = _n; seg.assign(2*n,ID); }
	void pull(int p) { seg[p] = comb(seg[2*p],seg[2*p+1]); }
	void upd(int p, T val) { // set val at position p
		seg[p += n] = val; for (p /= 2; p; p /= 2) pull(p); }
	T query(int l, int r) {	// sum on interval [l, r]
		T ra = ID, rb = ID;
		for (l += n, r += n+1; l < r; l /= 2, r /= 2) {
			if (l&1) ra = comb(ra,seg[l++]);
			if (r&1) rb = comb(seg[--r],rb);
		}
		return comb(ra,rb);
	}
};

Seg<ll> S;
int v[MX];

int main() {
	int n,q; cin >> n >> q;
	FOR(i,1,n+1) cin >> v[i];
	FE(i,1,n-1) {
		int a,b; cin >> a >> b;
		adj[a].pb(b), adj[b].pb(a);
	}
	dfs(1,0);
	S.init(n);
	FOR(i,1,n+1) S.upd(st[i],v[i]);
	FE(i,1,q) {
		int t; cin >> t;
		if (t == 1) {
			int s,x; cin >> s >> x;
			S.upd(st[s],x);
		} else {
			int s; cin >> s;
			cout << S.query(st[s],en[s]) << "\n";
		}
	}
}