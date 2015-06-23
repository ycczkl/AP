
int round(int idx, int n){
	int offset = 0;
	while(idx + offset < 0){
		offset += n;
	}
	while(idx + offset >= n){
		offset -= n;
	}
	return idx + offset;
}


// this code is only for minimum score, for maximum score the algorithm is excactly the same except
// taking max instead of min in the comparison
int main(){

	int num;
	cin >> num;
	std::vector<int> heaps;
	for (int i = 0; i < num; ++i)
	{
		int t;
		cin >> t;
		heaps.push_back(t);
	}

	std::vector<int> two_sum(num,0), dp(num-1,0);
	int cur_min = INT_MAX, cur_idx = 0;
	for (int i = 0; i < num; ++i)
	{
		if (i == 0)
		{
			two_sum[i] = heaps[i] + heaps.back();
		}
		else{
			two_sum[i] = heaps[i] + heaps[i-1];
		}
		if (cur_min > two_sum[i])
		{
			cur_min	= two_sum[i];
			cur_idx = i;
		}
	}
	for (int i = 0; i < num-1; ++i)
	{
		// skip the final results first, print out the intermediate resutls, and the last result is the final points. 
		dp[i] = cur_min + dp[i-1];
		cout << dp[i] << " ";
		
		// merge two elements in the original array, round is a helper function that ensure idx is within the bourdary
		heaps[cur_min] += heaps[round(cur_min-1)];

		// update the two_sum result after merging
		two_sum[round(cur_idx-1)] += heaps[round(cur_idx-2)];
		two_sum[round(cur_idx+1)] += heaps[round(cur_idx-1)];

		// delete the element that is merged 
		heaps.erase(heaps.begin() + round(cur_idx-1));
		two_sum.erase(two_sum.begin + cur_idx);

		// find the next merge target
		cur_min = INT_MAX;
		for(int j = 0 ; j < two_sum.size(); j++){
			cout << heaps[j] << " ";
			if (two_sum[j] > cur_min)
			{
				cur_min = two_sum[j];
				cur_idx = j;
			}
		}
		cout << endl;
	}
}