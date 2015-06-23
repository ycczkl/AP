

// 1.2 
int knapsack(std::vector<int> c, std::vector<int> w, int V){
	std::vector<std::vector<int> > v (c.size(), std::vector<int> (V+1, 0));
	for (int i = 0; i < c.size(); ++i)
	{
		/* code */
		for (int j = 0; j <= V ; ++j)
		{
			/* code */
			if (i == 0 )
			{
				if(c[i] <= j){
					v[i][j] = c[i];
				}				
			}
			else{
				if (c[i] <= j)
				{
					v[i][j] = max(v[i-1][j],v[i-1][j-c[i]]+w[i]);
				}
				else{
					v[i][j] = v[i-1][j];
				}
			}
		}
	}
	return v[c.size() - 1][V];
}

// 1.2 space optimization
int knapsack(std::vector<int> c, std::vector<int> w, int V){
	std::vector<int > v (V+1,0);
	for (int i = 0; i <= V; ++i)
	{
		
		if (i >= c[0])
		{
			v[i] = w[0];
			/* code */
		}
	}
	for (int i = 0; i < c.size(); ++i)
	{
		/* code */
		for (int j = V; j > 0 ; --j)
		{
			/* code */	
			if (c[i] <= j)
			{
				v[j] = max(v[j],v[j-c[i]]+w[i]);
			}
			
		}
	}
	return v[V];
}


//1.4 
int RepeatKnapsack(std::vector<int> c, std::vector<int> w, int B){
	std::vector<std::vector<int> > dp (c.size(), std::vector<int> (B+1, 0));
	for (int v = 0; v < c.size(); ++v)
	{
		for (int b = 1; i <= B; ++b)
		{
			if (v == 0)
			{
				int num = b/c[v];
				dp[v][b] = num * w[v];
				continue;
			}
			int count = 0;
			while(count * c[v] <= b){
				dp[v][b] = max(dp[v][b],dp[v-1][b-count * c[v]] + count * w[v]);
				count ++;
			}
		}
	}
	return dp.back()[B];
}

// simple optimization
std::vector<int> ToBeDelete(std::vector<int> c, std::vector<int> w, int B){
	std::vector<int> ToBeDeleteIdx;
	std::unordered_map<int,int> map;
	for (int i = 0; i < c.size(); ++i)
	{
		if (c[i] > B)
		{
			ToBeDeleteIdx.push_back(i);
			continue;
		}
		if (map.find(c[i]) == map.end())
		{
			map[c[i]] = w[i];
		}
		else{
			map[c[i]] = max(map[c[i]], w[i]);
		}
	}
	for (int i = 0; i < c.size(); ++i)
	{
		if(map[c[i]] > w[i]){
			ToBeDeleteIdx.push_back(i);
		}
	}
	return ToBeDeleteIdx;
}

//1.4 O(VN) optimization
int RepeatKnapsack(std::vector<int> c, std::vector<int> w, int B){
	std::vector<int > dp (B+1,0);
	for (int v = 0; v < c.size(); ++v)
	{
		for (int b = 1; i <= B; ++b)
		{
			if (v == 0)
			{
				int num = b/c[v];
				dp[b] = num * w[v];
				continue;
			}
			dp[b] = max(dp[b],dp[b-c[v]]+w[v]);
			
		}
		return dp[B];
	}
}


// 1.3 
int LimitedKnapsack(std::vector<int> c, std::vector<int> w, int B, std::vector<int> n){
	std::vector<std::vector<int> > dp (c.size(), std::vector<int> (B+1, 0));
	for (int v = 0; v < c.size(); ++v)
	{
		for (int b = 1; i <= B; ++b)
		{
			if (v == 0)
			{
				int num = b/c[v];
				dp[v][b] = num * w[v];
				continue;
			}
			for(int i = 0; i <= n; i++){
				if (i*c[i] > b)
				{
					break;
				}
				dp[v][b] = max(dp[v][b],dp[v-1][b-i*c[i]]+i*w[i]);
			}
		}
	}
	return dp.back()[B];
}

// 1.3 logn optimization
std::vector<int> Divide(int n){
	std::vector<int> res;
	int num = 1;
	while(num * 2 <= n){
		res.push_back(num);
		num *= 2;
	}
	res.push_back(n-num+1);
	return res;
}

int LimitedKnapsack(std::vector<int> c, std::vector<int> w, int B, std::vector<int> n){
	std::vector<int> new_c, new_w;
	for (int i = 0; i < n.size(); ++i)
	{
		std::vector<int> d = Divide(n[i]);
		for(auto l : d){
			new_c.push_back(l*c[i]);
			new_w.push_back(l*w[i]);
		}
	}
	return knapsack(new_c,new_w,B);
}















