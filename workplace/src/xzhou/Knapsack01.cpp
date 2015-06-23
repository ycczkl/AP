

int main(){
	int numTest;
	cin >> numTest;
	while(numTest--){
		int S,N;
		cin >> S >> N;
		std::vector<int> val,size;
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
			val.push_back(t);
		}
		int MaxValue;
		std::vector<int> selectIdx;
		Knapsack(val,size,S,MaxValue,selectIdx);
		
		reverse(selectIdx.begin(), selectIdx.end());
		int Weight = 0;
		for (int i = 0; i < selectIdx.size(); ++i)
		{
			cout << selectIdx[i] << " ";
			Weight += size[selectIdx[i]];
		}
		cout << endl;
		cout << Weight << " ";
		for (int i = 0; i < count; ++i)
		{
			cout << size[selectIdx[i]] << " ";
		}
		cout << endl;
		cout << MaxValue << " ";
		for (int i = 0; i < count; ++i)
		{
			cout << val[selectIdx[i]] << " ";
		}

	}
	return 1;

}

void Knapsack(std::vector<int>& val, std::vector<int>& size, int S, int & MaxValue, std::vector<int> select_Item){
	int n = val.size();
	std::vector<std::vector<int> > dp(n,std::vector<int>(S+1,0));
	for (int i = 0; i < n; ++i)
	{
		for (int j = 1; j <= S; ++j)
		{
			if (i == 0 )
			{
				if(size[i] <= j){
					dp[i][j] = val[i];
				}				
			}
			else{
				if (size[i] <= j)
				{
					dp[i][j] = max(dp[i-1][j],dp[i-1][j-size[i]]+val[i]);
				}
				else{
					dp[i][j] = dp[i-1][j];
				} 
			}
		}
	}
	MaxValue = dp[n-1][S];

	// backtrack the selected items OR we can put extra data in the dp array to indicate the previous one 
	// so that we can save following steps but increase the space consumtion
	int cur_x = n-1 , cur_y = S;
	while(cur_x > 0){
		if (cur_y >= size[cur_x])
		{
			if(dp[cur_x-1][cur_y] < dp[cur_x-1][cur_y-size[cur_x]] + val[cur_x]){
				select_Item.push_back(cur_x);
				cur_y -= size[cur_x];
				cur_x --;
			}
			else{
				cur_x --;
			}
		}
		else{
			cur_x--;
		}
		
	}
	if (cur_y >= size[cur_x])
	{
		select_Item.push_back(cur_x);
	}
}