
int main(){
	int numTest;
	cin >> numTest;
	while(numTest--){
		string s1,s2;
		cin >> s1 >> s2;
		if (s1 == s2)
		{
			cout << 0 << endl
			cout << 0 << endl;
		}
		else{
			int len1 = s1.length(), len2 = s2.length();

			// 3-D dimension for back tracking, the 3rd dimension is 2, for record the operation each step
			// using interger to represet operation: 0 --> none, 1 --> insert, 2--> delete, 3 --> replace
			std::vector<std::vector< std::vector<int> > > dp(len1, std::vector<std::vector<int> > (len2, std::vector<int> (2,0)) );
			dp[0][0][0] = s1[0] == s2[0] ? 0 : 1;
			dp[0][0][1] = s1[0] == s2[0] ? 0 : 3;
			for (int i = 0; i < len1; ++i)
			{
				for (int j = 0; j < len2; ++j)
				{
					if (i == 0 && j == 0)
					{
						continue;
					}
					if (s1[i] == s[j])
					{
						dp[i][j][1] = 0;
						if (i != 0 && j != 0)
						{
							dp[i][j][0] = dp[i-1][j-1][0];
							dp[i][j][1] = 0;
						}
						else{
							if (i == 0)
							{
								dp[i][j][0] = j;

							}
							else{
								dp[i][j][0] = i;
							}
							
						}
						
					}
					else{
						if (i != 0 && j != 0)
						{
							if(dp[i-1][j-1][0] < dp[i-1][j][0] && dp[i-1][j-1][0] < dp[i][j-1][0]){
								dp[i][j][0] = dp[i-1][j-1][0];
								dp[i][j][1] = 3;
							}
							else if(dp[i-1][j][0] < dp[i-1][j-1][0] && dp[i-1][j][0] < dp[i][j-1][0]){
								dp[i][j][0] = dp[i-1][j][0];
								dp[i][j][1] = 2;
							}
							else{
								dp[i][j][0] = dp[i][j-1][0];
								dp[i][j][1] = 1;
							}
						}
						else{
							if (i == 0)
							{
								dp[i][j][0] = dp[i][j-1][0] + 1;

							}
							else{
								dp[i][j][0] = dp[i-1][j][0] + 1;
							}
							
						}
					}
				}
			}
			cout << dp[len1-1][len2-1][0];
		}
	}
}

