// trivial dp solution: 2d dp[i][j] => the sum starting at i and ending at j

int main(){
	int numTest;
	while(numTest--){
		int S,N; // assume knowing the length of the array as N;
		cin >> S >> N;
		std::vector<int> v;
		for (int i = 0; i < N; ++i)
		{
			int t;
			cin >> t;
			v.push_back(t);
		}
		std::vector<std::vector<int>> dp(N, std::vector<int>(N,0));
		bool found = false;
		int start, end;
		for (int i = 0; i < N; ++i)
		{
			for (int j = i; j < N; ++j)
			{
				if (i == j)
				{
					dp[i][j] = v[i];
				}

				else{
					dp[i][j] = dp[i][j-1] + v[j];
				}
				if(dp[i][j] == S){
					found = true;
					start = i;
					end = j;
					break;
				}
			}
			if (found)
			{
				break;
			}
		}
		if (found)
		{
			cout << "True" << endl;
			for(int k = start ; k <= end; k++){
				cout << k << " ";
			}
			cout << endl;
			for(int k = start ; k <= end; k++){
				cout << v[k] << " ";
			}
			cout << endl;
		}
		else 
			cout << "False" << endl;
	}
	return 1;
}