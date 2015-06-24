
int main(){
	int numTests;
	cin >> numTests;
	while(numTests--){
		int N,V;
		cin >> N >> V;
		std::vector<int> size, value;
		for (int i = 0; i < N; ++i)
		{
			int t;
			cin >> t;
			size.push_back(t);
		}
		for (int i = 0; i < N; ++i)
		{
			int t;
			cin >> t;
			value.push_back(t);
		}

		// dp[i] is the maximum val less than i size, optimized version
		std::vector<int> dp(V+1,0);
		std::vector<int> amount(N,0);
		for (int i = 0; i < N; ++i)
		{
			for (int j = 1; j <= V; ++j)
			{
				if (i == 0)
				{
					int num = j/c[i];
					dp[j] = num * w[i];
					amount[i] = num;
					continue;
				}

				// dp[i][j] = max(dp[i-1][j], dp[i][j-size[i]]+value[i]);
				if(j >= size[i]){
					if (dp[j] < dp[j-size[i]] + value[i])
					{
						dp[j] = dp[j-size[i]] + value[i];
						amount[i] += 1;
					}
				}
			}
		}


		cout << dp[V] << endl;
		for (int i = 0; i < N; ++i)
		{
			cout << amount[i] << " ";
		}
		cout << endl;
	}
}