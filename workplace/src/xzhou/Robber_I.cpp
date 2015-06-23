
int main(){
	int numTests;
	cin >> numTests;
	while(numTests--){
		int N; //  assume knowing the length of the array as N
		cin >> N; 
		std::vector<int> v;
		for (int i = 0; i < N; ++i)
		{
			int t;
			cin >> t;
			v.push_back(t);
		}

		if(v.size() <= 1){
			// trivial case
		}
		if(v.size() == 2){
			cout << max(v[0],v[1]) << endl;
			cout << v[0] < v[1] ? 1 : 0 << endl;
			cout << v[0] < v[1] ? v[1] : v[0] << endl;
		}

		// dp[i] is the maximum ending at ith house
		std::vector<int> dp(N,0);
		std::vector<std::vector<int> > record(N, std::vector<int>());
		dp[0] = v[0];
		dp[1] = v[1];
		record[0].push_back(0);
		record[1].push_back(1);

		int final_max = 0, final_idx;
		for (int i = 2; i < N; ++i)
		{
			// dp[i] = max(dp[i-1], dp[i-2]+v[i]);
			if (dp[i-1] > dp[i-2] + v[i])
			{
				dp[i] = dp[i-1];
				record[i] = record[i-1];
			}
			else{
				dp[i] = dp[i-2] + v[i];
				record[i] = record[i-2];
				record[i].push_back(i);
			}
			if (final_max < dp[i])
			{
				final_max = dp[i];
				final_idx = i;
			}
		}
		// output the results
		cout << final_max << endl;
		for (int i = 0; i < record[final_idx].size(); ++i)
		{
			cout << record[final_idx][i] << " ";
		}
		cout << endl
		for (int i = 0; i < record[final_idx].size(); ++i)
		{
			cout << v[record[final_idx][i]] << " ";
		}
		cout << endl;

	}
}