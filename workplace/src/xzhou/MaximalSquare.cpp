

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

		// similar to max rect, but only search for diagonal direction, thus decrease 1 demension
		// 1 point and 1 diaganal length determine a squre, with a 3d array, tranvser all the combo 
		vector<vector<vector<bool>>> dp(rows, vector<vector<bool>>(cols, \ 
			vector<bool>(min(rows,cols),false)));
		
		int final_max = 0, left_top_x, left_top_y, diaganal_length;

		for(int m = 0 ; m < min(rows,cols); m++){

			for (int i = 0; i + m < rows; ++i)
			{
				for (int j = 0; j + m  < cols; ++j)
				{
					if (m == 0 && v[i][j] == 1)
						{
							dp[i][j][m] = true;
						}
						else if (v[i][j] == 0 || v[i+m][j+m] == 0){
							dp[i][j][m] = false;
						}
						
						else{
							dp[i][j][m] = dp[i][j][m-1] && dp[i+m-1][j+m][m-1] && dp[i+m][j+m-1][m-1];
						}

						if (dp[i][j][m] && final_max < (m-i + 1) * (n-j + 1))
						{
							final_max = (m-i + 1) * (n-j + 1);
							left_top_x = i;
							left_top_y = j ;
							diaganal_length = m;
						}
				}
			}
		}
		
		cout << final_max << endl;
		cout << left_top_x << " " << left_top_y << " " << left_top_x  << " " << left_top_y + diaganal_length << " " \
		<< left_top_x + diaganal_length << " "<< left_top_y << " " << left_top_x + diaganal_length << " " << left_top_y + diaganal_length << endl;
	}
}