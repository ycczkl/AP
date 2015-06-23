
int main(){
	int numTests;
	cin >> numTests;
	while(numTests--){

		// read the data in
		int rows, cols;
		cin >> rows >> cols;
		std::vector<std::vector<int>> v(rows, std::vector<int>(cols,0));
		for (int i = 0; i < rows; ++i)
		{
			for(int j = 0 ; j < cols ; ++j){
				int t;
				cin >> t;
				v[i][j] = t;
			}
		}

		// 2 points determine a rect, with a 4d array, tranvser all the combo of any 2 points
		vector<vector<vector<vector<bool>>>> dp(rows, vector<vector<vector<bool>>>(cols, \ 
			vector<vector<bool>>(rows, vector<bool> (cols,false) )));
		
		int final_max = 0, left_top_x, left_top_y, right_bottom_x, right_bottom_y;
		for (int i = 0; i < rows; ++i)
		{
			for(int j = 0 ; j < cols; j++){

				for(int m = i; m < rows; m++){

					for(int n = j; n < cols; n++){

						if (m == i && n == j && v[i][j] == 1)
						{
							dp[i][j][m][n] = true;
						}
						else if (v[i][j] == 0 || v[m][n] == 0){
							dp[i][j][m][n] = false;
						}
						else if(m == i){
							dp[i][j][m][n] = dp[i][j][m][n-1];
						}
						else if(n == j){
							dp[i][j][m][n] = dp[i][j][m-1][n];
						}
						else{
							dp[i][j][m][n] = dp[i][j][m-1][n] && dp[i][j][m][n-1];
						}

						if (dp[i][j][m][n] && final_max < (m-i + 1) * (n-j + 1))
						{
							final_max = (m-i + 1) * (n-j + 1);
							left_top_x = i;
							left_top_y = j ;
							right_bottom_x = m;
							right_bottom_y = n;
						}
					}
				}
			}
		}

		cout << final_max << endl;
		cout << left_top_x << " " << left_top_y << " " << left_top_x << " " << right_bottom_y << " " \
		<< right_bottom_x << " "<< left_top_y << " " << right_bottom_x << " " << right_bottom_y << endl;
	}
}