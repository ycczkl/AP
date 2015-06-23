// non-dp, just max - pre_min
int main(){
	int numTests;
	cin >> numTests;
	while(numTests--){
		// assume knowing the length of each array name n, convinient for c++
		int n;
		cin >> n;
		if (n < 1)
		{
			cout << 0 << endl;
			cout << -1 << " ";
			cout << -1 << endl;
			continue;
		}
		// std::vector<int> prices;
		int Min = 100000, Max = -1, Min_idx, Max_idx, profits;
		for (int i = 0; i < n; ++i)
		{
			int t ;
			cin >> t;
			profits = t - Min;
			if (t < Min)
			{
				Min = t;
				Min_idx = i;
			}
			if (profits > Max)
			{
				Max = profits;
				Max_idx = i;
			}

		}
		if (Max == -1)
		{
			cout << 0 << endl;
			cout << -1 << " ";
			cout << -1 << endl;
			continue;
		}
		cout << Max << endl;
		cout << Max_idx << " ";
		cout << Min_idx << endl;

	}
}

// dp version, just core code 
void BestTime(std::vector<int> prices){
	if (prices.size() < 1)
	{
		cout << 0 << endl;
		cout << -1 << " ";
		cout << -1 << endl;
		return;
	}
	int len = prices.size();
	std::vector<int> dp (len,0); // represent the max profits that sell on the ith day
	int buy = 0 , sell = 0 ;
	int Max = 0;
	for (int i = 1; i < len; ++i)
	{
		
		dp[i] = max(dp[i-1] + prices[i] - prices[i-1], prices[i] - prices[i-1]);
		if (Max < dp[i])
		{
			Max = dp[i];
			sell = i;
			buy = dp[i-1] > 0 ? buy : i-1;
		}
	}
	cout << Max << endl;
	cout << sell << " ";
	cout << buy << endl;
}
