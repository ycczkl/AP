

int main(){
	int numTests;
	cin >> numTests;
	while(numTests--){
		int N,V,U;
		cin >> N >> V >> U;
		std::vector<int>  a, b, value;

		for (int i = 0; i < N; ++i)
		{
			int t;
			cin >> t;
			value.push_back(t);
		}

		for (int i = 0; i < N; ++i)
		{
			int t;
			cin >> t;
			a.push_back(t);
		}
		for (int i = 0; i < N; ++i)
		{
			int t;
			cin >> t;
			b.push_back(t);
		}
		

		// dp[i][j] is the maximum val with less than i size for a and less than j size for b
		// this is the same trick that can be used in knapsack01 
		// if 3d: dp[i][j][k] = max(dp[i-1][j][k], dp[i-1][j-a[i]][k-b[i]]) ;
		std::vector<std::vector<int> > dp (V+1, std::vector<int> (U+1, 0));

		std::vector<int> amount(N,0);

		for (int i = 0; i < N; ++i)
		{
			for (int j = V; j > 0; --j)
			{
				for(int k = U; k > 0 ; --k){

				}
				if (i == 0)
				{
					if(j >= a[i] && k >= b[i]){
						dp[j][k] = value[i]
						amount[i] = 1;
					}
					continue;
				}
				if (j >= a[i] && k >= b[i] && dp[j-a[i]][k-b[i]] + value[i] > dp[j][k] )
				{
					dp[j][k] = dp[j-a[i]][k-b[i]] + value[i];
					amount[i] = 1;
				}
				else{
					amount[i] = 0;
				}
				
			}
		}


		cout << dp[V][U] << endl;
		for (int i = 0; i < N; ++i)
		{
			if (amount[i])
			{
				cout << i << " ";
			}
			
		}
		cout << endl;
	}
}