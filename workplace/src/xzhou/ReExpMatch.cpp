 // basic idea: 2d dp, dp[i][j] => whether the first i of s1 match first j of s2

int main(){
	int numTests;
	cin >> numTests;
	while(numTests--){
		string s1, s2;
		cin >> s1 >> s2;
		int len1 = s1.length(), len2 = s2.length();
		if (len1 == 0 || len2 == 0)
		{
			cout << "False" << endl;
		}
		else{
			// in order to avoid initialize dp seperately, the size is increased by 1
			// dp[i][j] is excacly whether the first i of s1 match first j of s2
			// in order word, the index of string and dp is different by 1
			std::vector<std::vector<bool> > dp(len1 + 1,std::vector<bool> (len2 + 1,false));
			dp[0][0] = true; 
			for (int i = 1; i < len2 && s2[i] == '*'; i+=2)
			{
				// if re is like a*b*c*, this always match ""
				dp[0][i+1] = true;
			}

			for (int i = 1; i <= len1; ++i)
			{
				for(int j = 1; j <= len2; ++j){
					if (s1[i-1] == s2[j-1] || s2[j-1] == '.' )
					{
						dp[i][j] = dp[i-1][j-1];
					}
					else if(s2[j-1] == '*'){
						// dp[i][j-2] is the result of discarding the *
						//  s1[i-1] == s2[j-2] || s2[j-2] == '.') is whether * is match the ith in s1
						// if so, we can discard the ith element => dp[i-1][j]
						dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (s1[i-1] == s2[j-2] || s2[j-2] == '.'));
					}
				}
			}
			cout << dp[len1][len2] << endl;
		}

	}
}