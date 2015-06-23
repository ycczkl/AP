

int main(){
	int numTests;
	cin >> numTests;
	while(numTests--){

		// read the data into vector
		int len; // assume know the length of the array for convinience
		cin >> len;
		std::vector<int> v;
		for (int i = 0; i < len; ++i)
		{
			int t;
			cin >> t;
			v.push_back(t);
		}

		// represent the longest length ending at ith 
		std::vector<int> dp(len,0);

		// true : increase, false : decrease
		std::vector<bool> direction(len,true);
		// record the subsuquece end at ith
		std::vector<std::vector<int> > res(len, std::vector<int>());

		// ignore the consecutive descending sequence at the begining 
		int start = 0;
		// while(start < len-1 && v[start] > v[start+1]){
		// 	start ++;
		// }		

		// if the whole sequence is not decsending 
		if (start != len -1)
		{
			dp[start] = 1;
			res[start].push_back(start);
			
			int final_max = 0, final_idx;
			for (int i = start+1; i < len; ++i)
			{
				
				if (direction[i-1] &&  v[i] > v[i-1])
				{
					dp[i] = dp[i-1] + 1;
					res[i] = res[i-1];
					res[i].push_back(i);
					direction[i] = !direction[i-1];
				}

				else if(!direction[i-1] && v[i] < v[i-1]){
					dp[i] = dp[i-1] + 1;
					res[i] = res[i-1];
					res[i].push_back(i);
					direction[i] = !direction[i-1];
				}

				else {
					int tmp_max = 0, max_idx;
					for(int j = i-1; j >= start; j--){
						if (direction[j] && v[i] > v[j])
						{
							tmp_max = dp[j];
							max_idx = j;
						}
						else if(!direction[j] && v[i] < v[j]){
							tmp_max = dp[j];
							max_idx = j;
						}
					}
					res[i] = res[max_idx];
					res[i].push_back(i);
					dp[i] = dp[max_idx] + 1;
					direction[i] = !direction[max_idx];
				}
				
				if (final_max < dp[i])
				{
					final_max = dp[i];
					final_idx = i;
				}
			}
			cout << final_max << endl;
			for (int i = 0; i < res[final_idx].size(); ++i)
			{
				cout << res[final_idx][i] << " ";
			}
			cout << endl;
			for (int i = 0; i < res[final_idx].size(); ++i)
			{
				cout << v[res[final_idx][i]] << " ";
			}
			cout << endl;
		}

		// if the whole sequence is only one elem
		else{
			cout << 1 << endl;
			cout << 0 << endl;
			cout << v[0] << endl;
		}

		
	}
}