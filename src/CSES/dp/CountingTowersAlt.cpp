#include<bits/stdc++.h>
#pragma GCC optimize("O3")

// #define fisier 1

using namespace std;

typedef long long ll;

const int mod = 1000000007;

ll dp[1000002][2];

int main()
{
	#ifdef fisier
		ifstream cin("input.in");
		ofstream cout("output.out");
	#endif

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	dp[1][0] = 1, dp[1][1] = 1;
	for(int i = 1; i < 1000000; ++i)
	{
		dp[i][0] %= mod;
		dp[i][1] %= mod;
		dp[i+1][0] += 2*dp[i][0];
		dp[i+1][1] += dp[i][0];
		dp[i+1][0] += dp[i][1];
		dp[i+1][1] += 4*dp[i][1];
	}
	int t;
	cin >> t;
	for(; t; --t)
	{
		int n;
		cin >> n;
		ll ans = dp[n][0] + dp[n][1];
		ans %= mod;
		cout << ans << '\n';
	}
	return 0;
}